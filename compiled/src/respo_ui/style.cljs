
(ns respo-ui.style
  (:require [hsl.core :refer [hsl]]))

(def global
 {:line-height 2,
  :font-size "14px",
  :font-family
  "Verdana,'Hiragino Sans GB','WenQuanYi Micro Hei','Microsoft Yahei',sans-serif"})

(def fullscreen
 {:top 0, :width "100%", :position "absolute", :height "100%", :left 0})

(def card {:padding "16px"})

(def button
 {:line-height "24px",
  :min-width "64px",
  :color (hsl 0 0 100),
  :text-align "center",
  :background-color (hsl 200 80 60),
  :cursor "pointer"})

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

(def flex {:flex 1})

(def row
 {:align-items "strech", :display "flex", :flex-direction "row"})

(def row-center
 {:align-items "center", :display "flex", :flex-direction "row"})

(def column
 {:align-items "strech", :display "flex", :flex-direction "column"})

(def column-center
 {:align-items "center", :display "flex", :flex-direction "column"})
