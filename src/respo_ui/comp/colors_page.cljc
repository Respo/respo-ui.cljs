
(ns respo-ui.comp.colors-page
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style.colors :as colors]
            [respo-ui.style :as ui]))

(def style-palette
  {:align-items "center",
   :color "white",
   :font-size 13,
   :width 400,
   :justify-content "space-around",
   :font-family "Menlo,monospace",
   :height 40,
   :margin 16})

(defn render-palette [title color]
  (div
   {:style (merge ui/row style-palette {:background-color color})}
   (comp-text title nil)
   (comp-text color nil)))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (comp-text "respo-ui.style.colors" nil)
     (render-palette "motif-light" colors/motif-light)
     (render-palette "motif" colors/motif)
     (render-palette "motif-dark" colors/motif-dark)
     (render-palette "attractive" colors/attractive)
     (render-palette "irreversible" colors/irreversible)
     (render-palette "warm" colors/warm)
     (render-palette "attentive" colors/attentive)
     (render-palette "verdant" colors/verdant)
     (render-palette "texture-light" colors/texture-light)
     (render-palette "texture" colors/texture)
     (render-palette "texture-dark" colors/texture-dark)
     (render-palette "intersected-dark" colors/intersected-dark)
     (render-palette "intersected" colors/intersected)
     (render-palette "intersected-light" colors/intersected-light))))

(def comp-colors-page (create-comp :colors-page render))
