(ns parallax.core
  (:require [reagent.core :as r]
            [parallax.scroll :as scroll]
            [parallax.poem :as poem]))

(defn page []
    [:div
      [:p "raw: " @scroll/position]
      (poem/build-text @scroll/position)])

(r/render-component [page] (js/document.getElementById "app"))
