
(ns respo-ui.comp.layouts-page
  (:require [respo.alias :refer [create-comp div a]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn render-small [color] (div {:style {:width 20, :height 20, :background-color color}}))

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
       {:attrs {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/layouts_page.cljc",
                :inner-text "Source",
                :target "_blank"}}))
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
                 {:width 100, :height 100, :background-color colors/motif-light})}
        (render-small colors/motif)
        (render-small colors/motif-dark)
        (render-small colors/motif)))
      (div
       {}
       (div {} (comp-text "Children in row with ui/row-center" nil))
       (div
        {:style (merge
                 ui/row-center
                 {:width 100, :height 100, :background-color colors/motif-light})}
        (render-small colors/motif)
        (render-small colors/motif-dark)
        (render-small colors/motif)))
      (div
       {}
       (div {} (comp-text "Child centerred with ui/center" nil))
       (div
        {:style (merge ui/center {:width 80, :height 80, :background-color colors/motif})}
        (div {:style {:width 40, :height 40, :background-color colors/motif-dark}})))))))

(def comp-layouts-page (create-comp :layouts-page render))
