
(ns respo-ui.comp.fonts-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(defn render [] (fn [state mutate!] (div {} (comp-text "fonts" nil))))

(def comp-fonts-page (create-comp :fonts-page render))
