
(ns respo-ui.comp.layouts-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(defn render [] (fn [state mutate!] (div {} (comp-text "layouts" nil))))

(def comp-layouts-page (create-comp :layouts-page render))
