
(ns respo-ui.comp.fonts-page
  (:require [respo.macros :refer [defcomp div <>]] [respo-ui.core :as ui]))

(def style-demo {:font-size 20, :font-weight "bold", :line-height "56px"})

(defn render-font-demo [family weight]
  (div
   {:style (merge
            style-demo
            {:font-family family, :font-weight weight, :font-size 18, :line-height "32px"})}
   (<> (str "This is a demo of the font, guess what you like: " family " " weight))))

(def style-section {:font-size 32, :font-family ui/font-fancy, :line-height "60px"})

(defcomp
 comp-fonts-page
 ()
 (div
  {}
  (div {:style style-section} (<> "Normal fonts:"))
  (render-font-demo ui/font-normal 300)
  (render-font-demo ui/font-normal 400)
  (render-font-demo ui/font-normal 500)
  (div {:style style-section} (<> "Fancy fonts:"))
  (render-font-demo ui/font-fancy 100)
  (render-font-demo ui/font-fancy 300)
  (render-font-demo ui/font-fancy 400)
  (div {:style style-section} (<> "Mono fonts"))
  (render-font-demo ui/font-code 100)
  (render-font-demo ui/font-code 300)
  (render-font-demo ui/font-code 400)))
