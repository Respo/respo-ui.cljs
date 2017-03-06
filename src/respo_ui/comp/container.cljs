
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
            [respo-ui.comp.components :refer [comp-components-page]]
            [respo-ui.comp.navbar :refer [comp-navbar]]))

(def style-content {:padding 8})

(def comp-container
  (create-comp
   :container
   (fn [store]
     (fn [state mutate!]
       (let [router (:router store), mobile? (:mobile? store)]
         (div
          {:style (merge ui/fullscreen ui/global)}
          (comp-navbar)
          (div
           {:style (if mobile? nil (merge ui/row {:padding-top 32}))}
           (comp-sidebar mobile?)
           (div
            {:style (merge ui/flex style-content)}
            (case (:name router)
              "home" (comp-home)
              "index.html" (comp-home)
              "dev.html" (comp-home)
              "colors.html" (comp-colors-page)
              "widgets.html" (comp-widgets-page)
              "layouts.html" (comp-layouts-page)
              "fonts.html" (comp-fonts-page)
              "components.html" (comp-components-page)
              (comp-text (pr-str router) nil))))))))))
