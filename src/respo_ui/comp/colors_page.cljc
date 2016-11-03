
(ns respo-ui.comp.colors-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(defn render [] (fn [state mutate!] (div {} (comp-text "colors" nil))))

(def comp-colors-page (create-comp :colors-page render))
