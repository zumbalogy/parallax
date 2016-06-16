(ns parallax.core
  (:require [reagent.core :as r]
            [parallax.scroll :as scroll]
            [parallax.poem :as poem]))

(defn page []
  (let [pos (scroll/scale-pos @scroll/position)]
    [:div (poem/build-text pos)]))

(r/render-component [page] (js/document.getElementById "app"))
