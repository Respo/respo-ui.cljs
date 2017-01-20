
(ns respo-ui.comp.layouts-page
  (:require [respo.alias :refer [create-comp div a]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn render-small [color] (div {:style {:background-color color, :width 20, :height 20}}))

(defn render-flex [color] (div {:style (merge ui/flex {:background-color color})}))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (div
      {}
      (comp-text "Layouts" nil)
      (comp-space 8 nil)
      (a
       {:attrs {:inner-text "Source",
                :target "_blank",
                :href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/layouts_page.cljc"}}))
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
        (render-flex colors/motif)))
      (div
       {}
       (div {} (comp-text "Children in column with ui/column-center" nil))
       (div
        {:style (merge
                 ui/column-center
                 {:background-color colors/motif-light, :width 100, :height 100})}
        (render-small colors/motif)
        (render-small colors/motif-dark)
        (render-small colors/motif)))
      (div
       {}
       (div {} (comp-text "Children in row with ui/row-center" nil))
       (div
        {:style (merge
                 ui/row-center
                 {:background-color colors/motif-light, :width 100, :height 100})}
        (render-small colors/motif)
        (render-small colors/motif-dark)
        (render-small colors/motif)))
      (div
       {}
       (div {} (comp-text "Child centerred with ui/center" nil))
       (div
        {:style (merge ui/center {:background-color colors/motif, :width 80, :height 80})}
        (div {:style {:background-color colors/motif-dark, :width 40, :height 40}})))))))

(def comp-layouts-page (create-comp :layouts-page render))
