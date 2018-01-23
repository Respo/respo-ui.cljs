
(ns respo-ui.comp.icons-page
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [respo-ui.comp.icon :refer [comp-icon comp-android-icon comp-ios-icon]]))

(defcomp
 comp-icons-page
 ()
 (div
  {}
  (<> "icon pages")
  (div {} (comp-icon :flash))
  (div {} (comp-ios-icon :bell))
  (div {} (comp-android-icon :cart))))
