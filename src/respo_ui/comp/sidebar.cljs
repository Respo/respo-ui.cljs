
(ns respo-ui.comp.sidebar
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.colors :as colors]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]))

(defn on-route [path-name] (fn [e dispatch! mutate!] (dispatch! :router/nav path-name)))

(defn render-entry [path title router-name]
  (div
   {:style (merge
            {:color colors/texture,
             :line-height "40px",
             :font-size 20,
             :cursor "pointer",
             :font-weight 100,
             :font-family ui/font-fancy,
             :text-align :right,
             :padding "0 16px"}
            (if (= path router-name) {:background-color (hsl 0 0 50 0.1)})),
    :on-click (on-route path)}
   (<> title)))

(defcomp
 comp-sidebar
 (router-name)
 (div
  {:style {:width 160, :margin-right 24}}
  (render-entry "index.html" "Respo UI" router-name)
  (render-entry "layouts.html" "Layouts" router-name)
  (render-entry "widgets.html" "Widgets" router-name)
  (render-entry "icons.html" "Icons" router-name)
  (render-entry "fonts.html" "Fonts" router-name)
  (render-entry "components.html" "Components" router-name)
  (render-entry "colors.html" "Colors" router-name)))
