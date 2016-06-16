(ns parallax.core
  (:require [reagent.core :as r]
            [parallax.scroll :as scroll]
            [parallax.poem :as poem]))

(defn poem []
  (let [pos (Math/abs (int (/ @scroll/position 200)))]
    [:div [:p (nth poem/raw-text pos)]]))

(r/render-component [poem] (js/document.getElementById "app"))
