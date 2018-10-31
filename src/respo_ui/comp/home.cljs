
(ns respo-ui.comp.home
  (:require [respo.core :refer [defcomp div a img <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.colors :as colors]
            [respo-md.comp.md :refer [comp-md-block]]))

(def style-home
  {:font-size 32, :font-family "Josefin Sans", :color colors/motif, :font-weight 100})

(defcomp
 comp-home
 ()
 (div
  {}
  (div
   {:style style-home}
   (<> "Styles for Respo")
   (=< 16 nil)
   (img {:src "https://img.shields.io/clojars/v/respo/ui.svg"}))
  (=< nil 32)
  (div
   {}
   (<> "Find more at: ")
   (comp-md-block
    "Respo UI is some minimal style collections for creating small pieces of apps. It includes variables for Flexbox layouts, basic button and input styles, icons from [Ionicons](https://github.com/driftyco/ionicons/), fonts like \"Josefin Sans\" and \"Hind\".\n\nYou may read code on [GitHub](http://github.com/Respo/respo-ui). [Fonts files](https://github.com/tiye/favored-fonts) are hosted separately on my server."
    {}))))
