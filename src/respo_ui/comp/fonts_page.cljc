
(ns respo-ui.comp.fonts-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(def style-demo {:line-height "56px", :font-size 20, :font-weight "bold"})

(defn render-font-demo [family weight]
  (div
   {:style (merge style-demo {:font-weight weight, :font-family family})}
   (comp-text
    (str "This is a demo of the font, guess what you like: " family " " weight)
    nil)))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (render-font-demo "Hind" 300)
     (render-font-demo "Hind" 400)
     (render-font-demo "Hind" 500)
     (render-font-demo "Josefin Sans" 300)
     (render-font-demo "Josefin Sans" 400))))

(def comp-fonts-page (create-comp :fonts-page render))
