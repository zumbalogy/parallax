(ns parallax.core
  (:require [reagent.core :as r]
            [parallax.scroll :as scroll]))

(def poem-data ["hello" "wolf" "sdf"])

(defn poem []
  (let [pos (int (/ @scroll/position 200))]
    [:div [:p pos]]))

(r/render-component [poem] (js/document.getElementById "app"))
