
(ns respo-ui.comp.fonts-page
  (:require [respo.alias :refer [create-comp div]] [respo.comp.text :refer [comp-text]]))

(def style-demo {:font-size 20, :font-weight "bold", :line-height "56px"})

(defn render-font-demo [family weight]
  (div
   {:style (merge style-demo {:font-family family, :font-weight weight})}
   (comp-text
    (str "This is a demo of the font, guess what you like: " family " " weight)
    nil)))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (div {} (comp-text "Content fonts:" nil))
     (render-font-demo "Hind" 300)
     (render-font-demo "Hind" 400)
     (render-font-demo "Hind" 500)
     (div {} (comp-text "Fancy fonts:" nil))
     (render-font-demo "Josefin Sans" 100)
     (render-font-demo "Josefin Sans" 300)
     (render-font-demo "Josefin Sans" 400))))

(def comp-fonts-page (create-comp :fonts-page render))
