(ns parallax.core
  (:require [reagent.core :as r]
            [parallax.scroll :as scroll]))

(scroll/listen!)

(def poem-data ["hello" "wolf" "sdf"])

(defn poem []
  [:div [:p @scroll/position]])

(r/render-component [poem] (js/document.getElementById "app"))
