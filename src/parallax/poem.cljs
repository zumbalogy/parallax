(ns parallax.poem)

(def br [:br])

(defn c [& args]
  (cycle args))

(defn scale [a b]
  (Math/abs (int (/ a b))))

(defn rand-pick [speed & args]
  (let [time (.getTime (js/Date.))
        len (count args)
        seed (* (inc len) (int (/ time speed)))
        modded (mod seed len)]
    (nth args modded)))

; TODO: if args have a length of one, most the helper functions should apply maybe

; TODO: helper for building thing that types out something letter[/word?] at a time like a typewriter
; and also one for deleting them

; TODO: a helper that just goes striaght though and bottoms/cielings out, instead of looking with cycle or mod

(defn build-text [x]
  (let [n (scale x 200)
        nnth (fn [& args] (nth args (mod n (count args))))
        xth (fn [s & args] (nth args (mod (scale x s) (count args))))
        nmod (fn [m & args] (nth args (mod (mod n m) (count args))))
        btwn (fn [a b & args] (when (<= a n b) (apply nnth args)))
        ]
    [:div
      "this is a "
      (xth 500 "scrolling" (xth 100 "cool" "c00l") "good" "hard to read")
      " "
      (rand-pick 2000 "poem" "message" "story")
      br
      (nnth "part" "2" "electirc bugaloo")
      br
      (nnth [:div "testing p"])
      (nnth "a" "b" (rand-nth ["x" "y"]))
      br
      (nnth "a" "b" (rand-pick 2000 "x" "y"))
      br
      "i am more of a "
      (get ["morning" "night" "morning" "night" "boring"] n)
      " person"
      br
      (btwn 0 50 "this is the start")
      br
      (btwn 50 100 "chapter 2" "chapter 2.1")
    ]))
