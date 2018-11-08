
(ns respo-ui.comp.icons-page
  (:require [respo.core :refer [defcomp div i <>]]
            [respo-ui.core :as ui]
            [respo-ui.comp.icon :refer [comp-ion comp-icon]]
            [respo-md.comp.md :refer [comp-md comp-md-block]]
            [respo.comp.space :refer [=<]]))

(defcomp
 comp-icons-page
 ()
 (div
  {}
  (<> "Icon pages")
  (comp-md-block
   "Icons can be found at http://cdn.tiye.me/favored-fonts/ionioncs-2.0.1/cheatsheet.html"
   {})
  (div
   {}
   (comp-md "Render icon with `(comp-ion :home {:color :red})`")
   (=< 16 nil)
   (comp-ion :home {:color :red}))
  (div {} (comp-md "Render icon with `(comp-icon :flash)`") (=< 16 nil) (comp-icon :flash))
  (div {} (i {:class-name "eva eva-activity"}))))
