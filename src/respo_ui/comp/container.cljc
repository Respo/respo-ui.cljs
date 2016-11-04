
(ns respo-ui.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.alias :refer [create-comp div span input]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]
            [respo-ui.comp.sidebar :refer [comp-sidebar]]
            [respo-ui.comp.home :refer [comp-home]]
            [respo-ui.comp.colors-page :refer [comp-colors-page]]
            [respo-ui.comp.widgets-page :refer [comp-widgets-page]]
            [respo-ui.comp.layouts-page :refer [comp-layouts-page]]
            [respo-ui.comp.fonts-page :refer [comp-fonts-page]]
            [respo-ui.comp.navbar :refer [comp-navbar]]))

(defn render [store]
  (fn [state mutate!]
    (let [router (:router store)]
      (div
       {:style (merge ui/fullscreen ui/global)}
       (comp-navbar)
       (div
        {:style (merge ui/row {:padding-top 80})}
        (comp-sidebar)
        (div
         {:style ui/flex}
         (case (:name router)
           "home" (comp-home)
           "index.html" (comp-home)
           "dev.html" (comp-home)
           "colors.html" (comp-colors-page)
           "widgets.html" (comp-widgets-page)
           "layouts.html" (comp-layouts-page)
           "fonts.html" (comp-fonts-page)
           (comp-text (pr-str router) nil))))))))

(def comp-container (create-comp :container render))
