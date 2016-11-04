
(ns respo-ui.style (:require [hsl.core :refer [hsl]] [respo-ui.style.colors :as colors]))

(def text-label
  {:line-height "32px", :color colors/texture, :font-size 14, :display "inline-block"})

(def center
  {:align-items "center",
   :justify-content "center",
   :display "flex",
   :flex-direction "column"})

(def select
  {:min-width 120,
   :font-size 14,
   :background-color colors/paper,
   :outline "none",
   :border "none",
   :font-family "Hind",
   :height 32})

(def column-center
  {:align-items "center",
   :justify-content "space-around",
   :display "flex",
   :flex-direction "column"})

(def global
  {:line-height 2,
   :color colors/texture,
   :font-size "14px",
   :font-family "Hind,Verdana,'Hiragino Sans GB','WenQuanYi Micro Hei','Microsoft Yahei',sans-serif"})

(def input
  (merge
   global
   {:line-height "16px",
    :min-width "120px",
    :font-size "14px",
    :background-color colors/paper,
    :padding "8px 8px",
    :outline "none",
    :border "none",
    :font-family "Hind",
    :height 32}))

(def column {:align-items "stretch", :display "flex", :flex-direction "column"})

(def textarea
  {:min-width 240,
   :font-size 14,
   :background-color colors/paper,
   :padding 8,
   :outline "none",
   :border "none",
   :font-family "Hind"})

(def row {:align-items "stretch", :display "flex", :flex-direction "row"})

(def fullscreen {:top 0, :width "100%", :position "absolute", :height "100%", :left 0})

(def card {:padding "16px"})

(def flex {:flex 1})

(def row-center
  {:align-items "center",
   :justify-content "space-around",
   :display "flex",
   :flex-direction "row"})

(def button
  {:line-height "32px",
   :min-width "80px",
   :color (hsl 0 0 100),
   :text-align "center",
   :font-size 14,
   :background-color colors/motif,
   :cursor "pointer",
   :padding "0 8px",
   :display "inline-block"})
