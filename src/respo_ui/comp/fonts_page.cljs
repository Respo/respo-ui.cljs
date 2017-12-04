
(ns respo-ui.comp.fonts-page (:require [respo.macros :refer [defcomp div <>]]))

(def style-demo {:font-size 20, :font-weight "bold", :line-height "56px"})

(defn render-font-demo [family weight]
  (div
   {:style (merge style-demo {:font-family family, :font-weight weight})}
   (<> (str "This is a demo of the font, guess what you like: " family " " weight))))

(defcomp
 comp-fonts-page
 ()
 (div
  {}
  (div {} (<> "Content fonts:"))
  (render-font-demo "Hind" 300)
  (render-font-demo "Hind" 400)
  (render-font-demo "Hind" 500)
  (div {} (<> "Fancy fonts:"))
  (render-font-demo "Josefin Sans" 100)
  (render-font-demo "Josefin Sans" 300)
  (render-font-demo "Josefin Sans" 400)))
