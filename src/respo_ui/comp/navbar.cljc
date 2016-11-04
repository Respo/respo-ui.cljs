
(ns respo-ui.comp.navbar
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(def style-container
  (merge
   ui/row
   {:align-items "center",
    :color "white",
    :bottom 0,
    :font-size 24,
    :top 0,
    :font-weight 100,
    :background-color colors/motif,
    :width "100%",
    :padding "0 16px",
    :position "fixed",
    :font-family "Josefin Sans",
    :height 48}))

(defn render []
  (fn [state mutate!] (div {:style style-container} (comp-text "Respo UI" nil))))

(def comp-navbar (create-comp :navbar render))
