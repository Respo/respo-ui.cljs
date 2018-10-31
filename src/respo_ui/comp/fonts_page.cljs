
(ns respo-ui.comp.fonts-page
  (:require [respo.core :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [respo.comp.space :refer [=<]]
            [respo-md.comp.md :refer [comp-md-block]]))

(def style-demo {:font-size 20, :font-weight "bold", :line-height "56px"})

(defn render-font-demo [family weight]
  (div
   {:style (merge
            style-demo
            {:font-family family, :font-weight weight, :font-size 16, :line-height "32px"})}
   (<> (str "This is a demo of the font, guess what you like: " family " " weight))))

(def style-section {:font-size 24, :font-family ui/font-fancy, :line-height "60px"})

(defcomp
 comp-fonts-page
 ()
 (div
  {}
  (div {:style style-section} (<> "Normal fonts"))
  (comp-md-block "which can be used with `ui/font-normal`. It's Hind fonts." {})
  (render-font-demo ui/font-normal 300)
  (render-font-demo ui/font-normal 400)
  (render-font-demo ui/font-normal 500)
  (=< nil 32)
  (div {:style style-section} (<> "Fancy fonts"))
  (comp-md-block "which can be used with `ui/font-fancy`. Josefin Sans is used here." {})
  (render-font-demo ui/font-fancy 100)
  (render-font-demo ui/font-fancy 300)
  (render-font-demo ui/font-fancy 400)
  (=< nil 32)
  (div {:style style-section} (<> "Code fonts"))
  (comp-md-block "which can be used with `ui/font-code`." {})
  (render-font-demo ui/font-code 100)
  (render-font-demo ui/font-code 300)
  (render-font-demo ui/font-code 400)))
