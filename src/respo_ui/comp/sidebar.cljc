
(ns respo-ui.comp.sidebar
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(defn on-route [path-name] (fn [e dispatch!] (dispatch! :router/nav path-name)))

(def style-entry {:line-height "40px", :color "red", :cursor "pointer", :padding "0 16px"})

(defn render []
  (fn [state mutate!]
    (div
     {}
     (div
      {:style style-entry, :event {:click (on-route "/index.html")}}
      (comp-text "Home" nil))
     (div
      {:style style-entry, :event {:click (on-route "/colors.html")}}
      (comp-text "Colors" nil))
     (div
      {:style style-entry, :event {:click (on-route "/widgets.html")}}
      (comp-text "Widgets" nil)))))

(def comp-sidebar (create-comp :sidebar render))
