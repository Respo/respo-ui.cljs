
(ns respo-ui.comp.components
  (:require [respo.alias :refer [create-comp div a]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]))

(defn render-entry [url title] (div {} (a {:attrs {:inner-text title, :href url}})))

(defn render []
  (fn [state mutate!]
    (div
     {}
     (comp-text "There are also components follow the guidelines of Respo UI:" nil)
     (render-entry "https://github.com/Respo/global-popup" "global-popup")
     (render-entry "https://github.com/Respo/inflow-popup" "inflow-popup")
     (render-entry "https://github.com/Respo/respo-message" "respo-message"))))

(def comp-components-page (create-comp :components render))
