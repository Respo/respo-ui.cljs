
(ns respo-ui.comp.widgets-page
  (:require [respo.alias :refer [create-comp div input]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style :as ui]
            [respo-ui.common :refer [on-input init-input update-input]]))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (comp-text "widgets" nil)
     (div
      {:style ui/row-center}
      (input
       {:style ui/input, :event {:input (on-input mutate!)}, :attrs {:placeholder "input"}})
      (comp-text state nil)))))

(def comp-widgets-page (create-comp :widget-page init-input update-input render))
