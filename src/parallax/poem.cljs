(ns parallax.poem)

(def br [:br])

(defn paragraph [& args]
  (map-indexed (fn [i x] [:p {:key i} x]) args))

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

(defn build-text [x]
  (let [n (scale x 200)
        nnth (fn [& args] (nth (cycle args) n))
        xth (fn [s & args] (nnth (scale x s)))
        nmod (fn [m & args] (nnth (mod n m)))
        btwn (fn [a b & args] (when (<= a n b) (apply nnth args)))]
    [:div (paragraph
      (str "this is a "
        (xth 500 "scrolling" (xth 100 "cool" "c00l") "good" "hard to read")
        " "
        (rand-pick 2000 "poem" "message" "story"))
      (nnth "part" "2" "electirc bugaloo")
      (nnth [:div "testing p"])
      (nnth "a" "b" (rand-nth ["x" "y"]))
      (nnth "a" "b" (rand-pick 2000 "x" "y"))
      (str "i am more of a "
        (get ["morning" "night" "morning" "night" "boring"] n)
        " person")
      (btwn 0 50 "this is the start")
      (btwn 50 100 "chapter 2" "chapter 2.1"))]))
