
(ns respo-ui.comp.widgets-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(defn render [] (fn [state mutate!] (div {} (comp-text "widgets" nil))))

(def comp-widgets-page (create-comp :widget-page render))
