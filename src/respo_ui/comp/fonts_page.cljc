
(ns respo-ui.comp.fonts-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(def style-demo {:font-size 16, :font-weight "bold"})

(defn render-font-demo [family]
  (div
   {:style (merge style-demo {:font-family family})}
   (comp-text (str "This is a demo of the font, guess what you like: " family) nil)))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (render-font-demo "Skia")
     (render-font-demo "Gill Sans")
     (render-font-demo "Avenir")
     (render-font-demo "Optima")
     (render-font-demo "Nanum Gothic"))))

(def comp-fonts-page (create-comp :fonts-page render))
