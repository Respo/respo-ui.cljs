
(ns respo-ui.comp.icons-page
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [respo-ui.comp.icon :refer [comp-ion comp-icon comp-android-icon comp-ios-icon]]
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
  (div
   {}
   (comp-md "Render iOS icon with `(comp-ios-icon :bell)`")
   (=< 16 nil)
   (comp-ios-icon :bell))
  (div
   {}
   (comp-md "Render Android icon with `(comp-android-icon :cart)`")
   (=< 16 nil)
   (comp-android-icon :cart))))
