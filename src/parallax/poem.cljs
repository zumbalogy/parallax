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

(defn build-text [n]
  (let [nnth (fn [& args] (nth args (mod n (count args))))
        nmod (fn [m & args] (nth args (mod (mod n m) (count args))))]
    [:p
      "this is a "
      (nnth "scrolling" (nnth "cool" "c001") "good")
      " "
      (rand-pick 200 "poem" "message" "story")
      br
      (nmod 3 "part" "2")
    ]))
