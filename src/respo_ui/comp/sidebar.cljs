
(ns respo-ui.comp.sidebar
  (:require [respo.macros :refer [defcomp div <>]] [respo-ui.colors :as colors]))

(defn on-route [path-name] (fn [e dispatch! mutate!] (dispatch! :router/nav path-name)))

(def style-entry
  {:color colors/texture,
   :line-height "40px",
   :padding "0 16px",
   :font-size "16px",
   :cursor "pointer"})

(defn render-entry [path title]
  (div {:style style-entry, :on {:click (on-route path)}} (<> title)))

(def style-container {:width 240})

(defcomp
 comp-sidebar
 ()
 (div
  {:style style-container}
  (render-entry "index.html" "Home")
  (render-entry "layouts.html" "Layouts")
  (render-entry "widgets.html" "Widgets")
  (render-entry "icons.html" "Icons")
  (render-entry "fonts.html" "Fonts")
  (render-entry "components.html" "Components")
  (render-entry "colors.html" "Colors")))
