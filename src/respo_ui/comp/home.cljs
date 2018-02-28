
(ns respo-ui.comp.home
  (:require [respo.macros :refer [defcomp div a img <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.colors :as colors]))

(def repo-url "http://github.com/Respo/respo-ui")

(def style-home
  {:font-size 32, :font-family "Josefin Sans", :color colors/motif, :font-weight 100})

(def style-logo
  {:background-image "url(http://logo.respo.site/respo.png)",
   :width 40,
   :height 40,
   :background-size :cover,
   :display :inline-block,
   :vertical-align :text-bottom})

(defcomp
 comp-home
 ()
 (div
  {}
  (div
   {:style style-home}
   (div {:style style-logo})
   (=< 16 nil)
   (<> "Styles for Respo")
   (=< 16 nil)
   (img {:src "https://img.shields.io/clojars/v/respo/ui.svg"}))
  (=< nil 32)
  (div {} (<> "Find more at: ") (a {:href repo-url} (<> repo-url)))))
