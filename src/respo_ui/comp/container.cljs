
(ns respo-ui.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo.core :refer [defcomp >> div span input <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.core :as ui]
            [respo-ui.comp.sidebar :refer [comp-sidebar]]
            [respo-ui.comp.home :refer [comp-home]]
            [respo-ui.comp.widgets-page :refer [comp-widgets-page]]
            [respo-ui.comp.layouts-page :refer [comp-layouts-page]]
            [respo-ui.comp.fonts-page :refer [comp-fonts-page]]
            [respo-ui.comp.components :refer [comp-components-page]]))

(def style-content {:padding 8})

(defcomp
 comp-container
 (store)
 (let [router (first (:path (:router store))), states (:states store)]
   (div
    {:style (merge ui/fullscreen ui/row ui/global {:padding-top 16})}
    (comp-sidebar (or (:name router) "index.html"))
    (div
     {:style (merge ui/flex style-content)}
     (case (:name router)
       nil (comp-home)
       "home" (comp-home)
       "index.html" (comp-home)
       "dev.html" (comp-home)
       "widgets.html" (comp-widgets-page (>> states :widgets))
       "layouts.html" (comp-layouts-page)
       "fonts.html" (comp-fonts-page)
       "components.html" (comp-components-page (>> states :components))
       (<> (pr-str router)))))))
