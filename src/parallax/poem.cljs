(ns parallax.poem)

(def br [:br])

(defn c [& args]
  (cycle args))

(defn rand-pick [speed & args]
  (let [time (.getTime (js/Date.))
        len (count args)
        seed (* (inc len) (int (/ time speed)))
        modded (mod seed len)]
    (nth args modded)))

; TODO: have an nnth type of thing that takes a sensitivity (how much to divide the original
; scroll position by

; TODO: helper for building thing that types out something letter[/word?] at a time like a typewriter
; and also one for deleting them

; TODO: a helper that just goes striaght though and bottoms/cielings out, instead of looking with cycle or mod

(defn build-text [n]
  (let [nnth (fn [& args] (nth args (mod n (count args))))
        nmod (fn [m & args] (nth args (mod (mod n m) (count args))))]
    [:div
      "this is a "
      (nnth "scrolling" (nnth "cool" "c00l") "good" "hard to read")
      " "
      (rand-pick 200 "poem" "message" "story")
      br
      (nnth "part" "2" "electirc bugaloo")
      (nnth [:div "testing p"])
      (nnth "a" (rand-nth ["b" "c"]))
      br
      "i am more of a "
      (get ["morning" "night" "morning" "night" "boring"] n)
      " person"
    ]))
