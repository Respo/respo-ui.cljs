
(ns respo-ui.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span input]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.common :refer [init-input update-input on-input]]
            [respo-ui.comp.sidebar :refer [comp-sidebar]]
            [respo-ui.comp.home :refer [comp-home]]
            [respo-ui.comp.colors-page :refer [comp-colors-page]]
            [respo-ui.comp.widgets-page :refer [comp-widgets-page]]))

(defn render [store]
  (fn [state mutate!]
    (let [router (:router store)]
      (div
       {:style (merge ui/fullscreen ui/global ui/row)}
       (comp-sidebar)
       (case (:name router)
         "index.html" (comp-home)
         "dev.html" (comp-home)
         "colors.html" (comp-colors-page)
         "widgets.html" (comp-widgets-page)
         (comp-text (pr-str router) nil))
       (div
        {:style ui/row-center}
        (input
         {:style ui/input,
          :event {:input (on-input mutate!)},
          :attrs {:placeholder "input"}})
        (comp-text state nil))))))

(def comp-container (create-comp :container init-input update-input render))
