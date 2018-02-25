
(ns respo-ui.comp.navbar
  (:require [respo.macros :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [respo-ui.colors :as colors]
            [hsl.core :refer [hsl]]))

(def style-header
  (merge
   ui/row
   {:width "100%",
    :height 48,
    :align-items "center",
    :padding "0 16px",
    :font-size 24,
    :font-weight 300,
    :font-family "Josefin Sans",
    :border-bottom (str "1px solid " (hsl 0 0 90))}))

(defcomp comp-navbar () (div {:style style-header} (<> "Respo UI")))
