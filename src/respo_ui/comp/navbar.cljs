
(ns respo-ui.comp.navbar
  (:require-macros [respo.macros :refer [defcomp div <>]])
  (:require [respo.core :refer [create-comp]]
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

(defcomp comp-navbar () (div {:style style-container} (<> "Respo UI")))
