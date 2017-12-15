
(ns respo-ui.comp.layouts-page
  (:require [respo.macros :refer [defcomp div a <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn render-small [color] (div {:style {:width 20, :height 20, :background-color color}}))

(defn render-flex [color] (div {:style (merge ui/flex {:background-color color})}))

(def style-area {:width 100, :height 100, :background-color colors/motif-light})

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
   (div {} (<> "ui/center"))
   (div
    {:style (merge ui/center style-area)}
    (render-small colors/motif)
    (div {:style {:width 40, :height 40, :background-color colors/motif-dark}})
    (render-small colors/motif)))
  (div
   {}
   (div {} (<> "ui/row"))
   (div
    {:style (merge ui/row style-area)}
    (render-flex colors/motif)
    (render-flex colors/motif-dark)
    (render-flex colors/motif)))
  (div
   {}
   (div {} (<> "ui/column"))
   (div
    {:style (merge ui/column style-area)}
    (render-flex colors/motif)
    (render-flex colors/motif-dark)
    (render-flex colors/motif)))
  (div
   {}
   (div {} (<> "ui/row-parted"))
   (div
    {:style (merge ui/row-parted style-area)}
    (render-small colors/motif)
    (render-small colors/motif-dark)
    (render-small colors/motif)))
  (div
   {}
   (div {} (<> "ui/row-center"))
   (div
    {:style (merge ui/row-center style-area)}
    (render-small colors/motif)
    (render-small colors/motif-dark)
    (render-small colors/motif)))
  (div
   {}
   (div {} (<> "ui/row-dispersive"))
   (div
    {:style (merge ui/row-dispersive style-area)}
    (render-small colors/motif)
    (render-small colors/motif-dark)
    (render-small colors/motif)))
  (div
   {}
   (div {} (<> "ui/column-dispersive"))
   (div
    {:style (merge ui/column-dispersive style-area)}
    (render-small colors/motif)
    (render-small colors/motif-dark)
    (render-small colors/motif)))))
