(ns parallax.scroll
  (:require [reagent.core :as r]))

(def position (r/atom 0))

(defn update-position [e]
  (let [delta (.-deltaY e)]
    (swap! position + delta)))

(defn init! []
  (let [doc (.-documentElement js/document)]
    (when-not (.-onmousewheel doc)
      (set! (.-onmousewheel doc) update-position))))

(init!)
