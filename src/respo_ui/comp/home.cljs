
(ns respo-ui.comp.home
  (:require [respo.macros :refer [defcomp div a img <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.style.colors :as colors]))

(def repo-url "http://github.com/Respo/respo-ui")

(def style-home
  {:font-size 48, :font-family "Josefin Sans", :color colors/motif, :font-weight 100})

(def style-logo
  {:background-image "url(http://logo.respo.site/respo.png)",
   :width 160,
   :height 160,
   :background-size :cover})

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
  (div {:style style-logo})
  (=< nil 32)
  (div {} (<> "Find more at: ") (a {:href repo-url} (<> repo-url)))))
