
(ns respo-ui.comp.layouts-page
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn render-flex [color] (div {:style (merge ui/flex {:background-color color})}))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (comp-text "layouts" nil)
     (div
      {}
      (div {} (comp-text "Children in row with ui/row" nil))
      (div
       {:style (merge ui/row {:width 80, :height 80})}
       (render-flex colors/motif)
       (render-flex colors/motif-dark)
       (render-flex colors/motif))
      (div
       {}
       (div {} (comp-text "Children in column with ui/column" nil))
       (div
        {:style (merge ui/column {:width 80, :height 80})}
        (render-flex colors/motif)
        (render-flex colors/motif-dark)
        (render-flex colors/motif)))))))

(def comp-layouts-page (create-comp :layouts-page render))
