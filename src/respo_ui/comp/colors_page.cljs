
(ns respo-ui.comp.colors-page
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.style.colors :as colors]
            [respo-ui.style :as ui]))

(def style-palette
  {:max-width 400,
   :height 40,
   :color "white",
   :margin 16,
   :justify-content "space-around",
   :align-items "center",
   :font-family "Menlo,monospace",
   :font-size 13})

(defn render-palette [title color]
  (div {:style (merge ui/row style-palette {:background-color color})} (<> title) (<> color)))

(defcomp
 comp-colors-page
 ()
 (div
  {}
  (div {} (<> "respo-ui.style.colors"))
  (div {} (<> "Motif colors"))
  (render-palette "motif" colors/motif)
  (render-palette "motif-light" colors/motif-light)
  (render-palette "motif-dark" colors/motif-dark)
  (div {} (<> "Functional colors"))
  (render-palette "attractive" colors/attractive)
  (render-palette "irreversible" colors/irreversible)
  (render-palette "attentive" colors/attentive)
  (render-palette "verdant" colors/verdant)
  (render-palette "warm" colors/warm)
  (div {} (<> "Text colors"))
  (render-palette "texture" colors/texture)
  (render-palette "texture-light" colors/texture-light)
  (render-palette "texture-dark" colors/texture-dark)
  (div {} (<> "Border colors"))
  (render-palette "intersected" colors/intersected)
  (render-palette "intersected-light" colors/intersected-light)
  (div {} (<> "Paper colors"))
  (render-palette "paper" colors/paper)
  (render-palette "paper-light" colors/paper-light)
  (render-palette "paper-dark" colors/paper-dark)))
