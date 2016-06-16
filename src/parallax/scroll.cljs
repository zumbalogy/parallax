(ns parallax.scroll
  (:require [reagent.core :as r]))

(def position (r/atom 0))
(def prev-position (r/atom 0))

(defn scale-pos [n]
  (Math/abs (int (/ n 200))))

(defn update-position [e]
  (let [delta (.-deltaY e)]
    (reset! prev-position position)
    (swap! position + delta)))

(defn init! []
  (let [doc (.-documentElement js/document)]
    (when-not (.-onmousewheel doc)
      (set! (.-onmousewheel doc) update-position))))

(init!)
