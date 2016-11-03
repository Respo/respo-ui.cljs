
(ns respo-ui.comp.home
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(defn render [] (fn [state mutate!] (div {} (comp-text "Home" nil))))

(def comp-home (create-comp :home render))
