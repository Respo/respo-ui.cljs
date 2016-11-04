
(ns respo-ui.comp.home
  (:require [respo.alias :refer [create-comp div a]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style.colors :as colors]))

(def repo-url "http://github.com/Respo/respo-ui")

(defn render []
  (fn [state mutate!]
    (div
     {}
     (div
      {:style {:color colors/motif,
               :font-size 48,
               :font-weight 100,
               :font-family "Josefin Sans"}}
      (comp-text "A simple collection of styles for Respo." nil))
     (div
      {}
      (comp-text "Find more at: ")
      (a {:attrs {:href repo-url}} (comp-text repo-url nil))))))

(def comp-home (create-comp :home render))
