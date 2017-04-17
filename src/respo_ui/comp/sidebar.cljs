
(ns respo-ui.comp.sidebar
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style.colors :as colors]))

(defn on-route [path-name] (fn [e dispatch!] (dispatch! :router/nav path-name)))

(defn style-container [mobile?] (if mobile? {:margin-bottom 16} {:width 240}))

(defn style-entry [mobile?]
  (merge
   {:color colors/texture,
    :line-height "40px",
    :padding "0 16px",
    :font-size "16px",
    :cursor "pointer"}
   (if mobile? {:display :inline-block, :padding "0 8px", :line-height "32px"})))

(defn render-entry [path title mobile?]
  (div {:style (style-entry mobile?), :event {:click (on-route path)}} (comp-text title nil)))

(def comp-sidebar
  (create-comp
   :sidebar
   (fn [mobile?]
     (fn [cursor]
       (div
        {:style (style-container mobile?)}
        (render-entry "index.html" "Home" mobile?)
        (render-entry "colors.html" "Colors" mobile?)
        (render-entry "fonts.html" "Fonts" mobile?)
        (render-entry "widgets.html" "Widgets" mobile?)
        (render-entry "layouts.html" "Layouts" mobile?)
        (render-entry "components.html" "Components" mobile?))))))
