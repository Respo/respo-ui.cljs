
(ns respo-ui.comp.layouts-page
  (:require [respo.macros :refer [defcomp div a <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.core :as ui]
            [respo-ui.colors :as colors]
            [hsl.core :refer [hsl]]
            [respo-md.comp.md :refer [comp-md-block]]))

(def style-sample
  {:padding "4px 8px", :color :white, :font-size 12, :font-family ui/font-code})

(defn render-demo [title layout]
  (div
   {:style {:margin 16}}
   (div {:style {}} (<> title))
   (div
    {:style (merge
             layout
             {:border (str "1px solid " (hsl 0 0 86)), :width 120, :height 120})}
    (div {:style (merge style-sample {:background-color (hsl 0 80 70)})} (<> "A"))
    (div {:style (merge style-sample {:background-color (hsl 120 80 70)})} (<> "B"))
    (div {:style (merge style-sample {:background-color (hsl 240 80 80)})} (<> "C")))))

(defcomp
 comp-layouts-page
 ()
 (div
  {}
  (div
   {}
   (<> "Layouts")
   (=< 8 nil)
   (a
    {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/layouts_page.cljs",
     :inner-text "Source",
     :target "_blank"}))
  (comp-md-block
   "Flexbox styles are defined in variables like `ui/row` `ui/center` in flex containers. Here are how they take effects."
   {})
  (div
   {:style (merge ui/row {:flex-wrap :wrap, :font-family ui/font-code, :font-size 12})}
   (render-demo "ui/center" ui/center)
   (render-demo "ui/row-center" ui/row-center)
   (render-demo "ui/row-middle" ui/row-middle)
   (render-demo "ui/row" ui/row)
   (render-demo "ui/column" ui/column)
   (render-demo "ui/row-parted" ui/row-parted)
   (render-demo "ui/column-parted" ui/column-parted)
   (render-demo "ui/row-dispersive" ui/row-dispersive)
   (render-demo "ui/column-dispersive" ui/column-dispersive))))
