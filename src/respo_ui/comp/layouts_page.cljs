
(ns respo-ui.comp.layouts-page
  (:require [respo.macros :refer [defcomp div a <>]])
  (:require [respo.core :refer [create-comp]]
            [respo.comp.space :refer [=<]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn render-small [color] (div {:style {:width 20, :height 20, :background-color color}}))

(defn render-flex [color] (div {:style (merge ui/flex {:background-color color})}))

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
  (div
   {}
   (div {} (<> "Children in row with ui/row"))
   (div
    {:style (merge ui/row {:width 80, :height 80})}
    (render-flex colors/motif)
    (render-flex colors/motif-dark)
    (render-flex colors/motif))
   (div
    {}
    (div {} (<> "Children in column with ui/column"))
    (div
     {:style (merge ui/column {:width 80, :height 80})}
     (render-flex colors/motif)
     (render-flex colors/motif-dark)
     (render-flex colors/motif)))
   (div
    {}
    (div {} (<> "Children in column with ui/column-center"))
    (div
     {:style (merge
              ui/column-center
              {:width 100, :height 100, :background-color colors/motif-light})}
     (render-small colors/motif)
     (render-small colors/motif-dark)
     (render-small colors/motif)))
   (div
    {}
    (div {} (<> "Children in row with ui/row-center"))
    (div
     {:style (merge
              ui/row-center
              {:width 100, :height 100, :background-color colors/motif-light})}
     (render-small colors/motif)
     (render-small colors/motif-dark)
     (render-small colors/motif)))
   (div
    {}
    (div {} (<> "Child centerred with ui/center"))
    (div
     {:style (merge ui/center {:width 80, :height 80, :background-color colors/motif})}
     (div {:style {:width 40, :height 40, :background-color colors/motif-dark}}))))))
