
(ns respo-ui.style (:require [hsl.core :refer [hsl]] [respo-ui.style.colors :as colors]))

(def center
  {:align-items "center",
   :justify-content "center",
   :display "flex",
   :flex-direction "column"})

(def column-center {:align-items "center", :display "flex", :flex-direction "column"})

(def global
  {:line-height 2,
   :color colors/texture,
   :font-size "14px",
   :font-family "Hind,Verdana,'Hiragino Sans GB','WenQuanYi Micro Hei','Microsoft Yahei',sans-serif"})

(def input
  (merge
   global
   {:line-height 2,
    :font-size "14px",
    :background-color (hsl 0 0 96),
    :width "auto",
    :padding "0 8px",
    :outline "none",
    :border "none"}))

(def column {:align-items "stretch", :display "flex", :flex-direction "column"})

(def row {:align-items "stretch", :display "flex", :flex-direction "row"})

(def fullscreen {:top 0, :width "100%", :position "absolute", :height "100%", :left 0})

(def card {:padding "16px"})

(def flex {:flex 1})

(def row-center {:align-items "center", :display "flex", :flex-direction "row"})

(def button
  {:line-height 2.2,
   :min-width "64px",
   :color (hsl 0 0 100),
   :text-align "center",
   :background-color (hsl 200 80 60),
   :cursor "pointer",
   :padding "0 8px",
   :display "inline-block"})
