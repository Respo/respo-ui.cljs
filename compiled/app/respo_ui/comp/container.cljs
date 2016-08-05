
(ns respo-ui.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span input]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]))

(defn render [store]
  (fn [state mutate!]
    (div
      {:style (merge ui/fullscreen ui/global ui/card)}
      (div
        {:style ui/row-center}
        (div {:style ui/button} (comp-text "save" nil))
        (comp-space "8px" nil)
        (div {:style ui/button} (comp-text "cancel" nil)))
      (comp-space nil "16px")
      (div
        {:style ui/row-center}
        (input {:style ui/input, :attrs {:placeholder "input"}})))))

(def comp-container (create-comp :container render))
