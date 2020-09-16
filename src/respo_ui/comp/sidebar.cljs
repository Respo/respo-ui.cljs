
(ns respo-ui.comp.sidebar
  (:require [respo.core :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]
            [respo.comp.space :refer [=<]]))

(defn on-route [path-name] (fn [e dispatch! mutate!] (dispatch! :router/nav path-name)))

(defn render-entry [path title router-name]
  (div
   {:style (merge
            {:color (hsl 0 0 20),
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

(def style-logo
  {:background-image "url(http://cdn.tiye.me/logo/respo.png)",
   :width 80,
   :height 80,
   :background-size :cover,
   :display :inline-block,
   :vertical-align :text-bottom})

(defcomp
 comp-sidebar
 (router-name)
 (div
  {:style {:width 160, :margin-right 24}}
  (div {:style {:text-align :right}} (div {:style style-logo}))
  (=< nil 16)
  (render-entry "index.html" "Respo UI" router-name)
  (render-entry "layouts.html" "Layouts" router-name)
  (render-entry "lay-out.html" "Lay Out" router-name)
  (render-entry "widgets.html" "Widgets" router-name)
  (render-entry "fonts.html" "Fonts" router-name)
  (render-entry "components.html" "Components" router-name)))
