(ns parallax.poem)

(defn paragraph [& args]
  (map-indexed (fn [i x] [:div {:key i} x]) args))

(defn scale [a b]
  (Math/abs (quot a b)))

(defn grabber
  ; TODO: better as macro maybe
  ([x]
    (fn [& args]
      (nth args (mod x (count args)))))
  ([x func]
    (fn [z & args]
      (if-let [result (func x z)]
        (nth args (mod result (count args)))))))

; TODO: helper for building thing that types out something letter[/word?] at a time like a typewriter
; and also one for deleting them

(defn build-text [x]
  (let [n (scale x 200)
        nnth (grabber n)
        xth (grabber x scale)
        btwn (grabber n (fn [a [b c]] (<= b a c)))
        blink (grabber n #(if (even? (quot %1 %2)) %1))
        rand-pick (grabber n #(quot (.getTime (js/Date.)) %2))
        ]
    [:div (paragraph
      (str "raw " x)
      (str "scaled " n)
      (btwn [0 15]
        [:div (str "this is a "
          (xth 500 "scrolling" (xth 20 "cool" "c0ool" "c00ol" "c000l" "c0000l" "co000l" "co00l" "coo0l" "cool") "good" "hard to read")
          " "
          (rand-pick 2000 "poem" "message" "story"))
          [:br]
          "this is the start. scroll to read"])
      (blink 2 "this should blink")
      )]))
