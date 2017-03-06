
(ns respo-ui.comp.sidebar
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style.colors :as colors]))

(defn on-route [path-name] (fn [e dispatch!] (dispatch! :router/nav path-name)))

(def style-container {:width 240})

(def style-entry
  {:color colors/texture,
   :line-height "40px",
   :padding "0 16px",
   :font-size "16px",
   :cursor "pointer"})

(defn render-entry [path title]
  (div {:style style-entry, :event {:click (on-route path)}} (comp-text title nil)))

(defn render []
  (fn [state mutate!]
    (div
     {:style style-container}
     (render-entry "index.html" "Home")
     (render-entry "colors.html" "Colors")
     (render-entry "fonts.html" "Fonts")
     (render-entry "widgets.html" "Widgets")
     (render-entry "layouts.html" "Layouts")
     (render-entry "components.html" "Components"))))

(def comp-sidebar (create-comp :sidebar render))
