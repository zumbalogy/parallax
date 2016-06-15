(ns parallax.core
  (:require [reagent.core :as r]))

(def poem-data ["hello" "wolf" "sdf"])

(defn poem []
  [:p (str poem-data)])

(r/render-component poem (js/document.getElementById "app"))
