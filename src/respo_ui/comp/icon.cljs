
(ns respo-ui.comp.icon
  (:require [respo.core
             :refer
             [create-element defcomp div input textarea button span select option a <>]]))

(defn get-string [icon-name]
  (cond
    (keyword? icon-name) (name icon-name)
    (string? icon-name) icon-name
    :else (throw (js/Error. (str "Unknown icon: " (pr-str icon-name))))))

(defn comp-icon [icon-name]
  (create-element :i {:class-name (str "eva eva-" (get-string icon-name))}))

(defn comp-ion [icon-name styles]
  (create-element :i {:class-name (str "eva eva-" (get-string icon-name)), :style styles}))
