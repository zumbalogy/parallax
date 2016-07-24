(ns parallax.poem)

(defn paragraph [& args]
  (map-indexed (fn [i x] [:p {:key i} x]) args))

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

; TODO: if args have a length of one, most the helper functions should apply maybe

; TODO: helper for building thing that types out something letter[/word?] at a time like a typewriter
; and also one for deleting them

(defn build-text [x]
  (let [n (scale x 200)
        nnth (grabber n)
        xth (grabber x scale)
        btwn (grabber n (fn [a [b c]] (<= b a c)))
        rand-pick (grabber x #(quot (.getTime (js/Date.)) %2))]
    [:div (paragraph
      (str "raw " x)
      (str "scaled " n)
      (str "this is a "
        (xth 500 "scrolling" (xth 100 "cool" "c00l") "good" "hard to read")
        " "
        (rand-pick 2000 "poem" "message" "story"))
      (btwn [0 30] "this is the start")
      )]))
