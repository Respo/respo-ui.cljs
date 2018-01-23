
(ns respo-ui.comp.icon
  (:require [respo.macros :refer [defcomp div input textarea button span select option a <>]]
            [respo.core :refer [create-element]]))

(defn get-string [icon-name]
  (cond
    (keyword? icon-name) (name icon-name)
    (string? icon-name) icon-name
    :else (throw (js/Error. (str "Unknown icon: " (pr-str icon-name))))))

(defcomp
 comp-android-icon
 (icon-name)
 (create-element :i {:class-name (str "ion-android-" (get-string icon-name))}))

(defn comp-icon [icon-name]
  (create-element :i {:class-name (str "ion-" (get-string icon-name))}))

(defcomp
 comp-ios-icon
 (icon-name)
 (create-element :i {:class-name (str "ion-ios-" (get-string icon-name))}))
