
(ns respo-ui.comp.navbar
  (:require [respo.alias :refer [create-comp div]]
            [respo.comp.text :refer [comp-text]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(def style-container
  (merge
   ui/row
   {:background-color colors/motif,
    :width "100%",
    :height 48,
    :align-items "center",
    :padding "0 16px",
    :color "white",
    :font-size 24,
    :font-weight 300,
    :font-family "Josefin Sans"}))

(def comp-navbar
  (create-comp
   :navbar
   (fn [] (fn [cursor] (div {:style style-container} (comp-text "Respo UI" nil))))))
