
(ns respo-ui.comp.icons-page
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [respo-ui.comp.icon :refer [comp-icon comp-android-icon comp-ios-icon]]
            [respo-markdown.comp.md-article :refer [comp-md-article]]))

(defcomp
 comp-icons-page
 ()
 (div
  {}
  (<> "Icon pages")
  (comp-md-article
   "Icons can be found at http://cdn.tiye.me/favored-fonts/ionioncs-2.0.1/cheatsheet.html"
   {})
  (div {} (comp-md-article "Render icon with `(comp-icon :flash)`" {}) (comp-icon :flash))
  (div
   {}
   (comp-md-article "Render iOS icon with `(comp-ios-icon :bell)`" {})
   (comp-ios-icon :bell))
  (div
   {}
   (comp-md-article "Render Android icon with `(comp-android-icon :cart)`" {})
   (comp-android-icon :cart))))
