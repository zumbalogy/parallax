(ns parallax.scroll
  (:require [reagent.core :as r]))

(def position (r/atom 0))

(defn update-position [e]
  (swap! position + (.-deltaY e)))

(defn listen! []
  (.addEventListener (.-documentElement js/document) "mousewheel" update-position))
