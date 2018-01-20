
(ns respo-ui.comp.sidebar
  (:require [respo.macros :refer [defcomp div <>]] [respo-ui.colors :as colors]))

(defn on-route [path-name] (fn [e dispatch! mutate!] (dispatch! :router/nav path-name)))

(defn style-entry [mobile?]
  (merge
   {:color colors/texture,
    :line-height "40px",
    :padding "0 16px",
    :font-size "16px",
    :cursor "pointer"}
   (if mobile? {:display :inline-block, :padding "0 8px", :line-height "32px"})))

(defn render-entry [path title mobile?]
  (div {:style (style-entry mobile?), :on {:click (on-route path)}} (<> title)))

(defn style-container [mobile?] (if mobile? {:margin-bottom 16} {:width 240}))

(defcomp
 comp-sidebar
 (mobile?)
 (div
  {:style (style-container mobile?)}
  (render-entry "index.html" "Home" mobile?)
  (render-entry "colors.html" "Colors" mobile?)
  (render-entry "fonts.html" "Fonts" mobile?)
  (render-entry "widgets.html" "Widgets" mobile?)
  (render-entry "layouts.html" "Layouts" mobile?)
  (render-entry "components.html" "Components" mobile?)))
