
(ns respo-ui.style (:require [hsl.core :refer [hsl]] [respo-ui.style.colors :as colors]))

(def clickable-text
  {:line-height "24px",
   :color colors/motif,
   :cursor :pointer,
   :padding "0 8px",
   :text-decoration :underline,
   :display :inline-block,
   :user-select :no-select,
   :height 24,
   :margin 4})

(def text-label
  {:line-height "32px",
   :color colors/texture,
   :vertical-align :top,
   :font-size 14,
   :display :inline-block})

(def center
  {:align-items "center",
   :justify-content "center",
   :display "flex",
   :flex-direction "column"})

(def default-fonts
  "Hind,Verdana,'Hiragino Sans GB','WenQuanYi Micro Hei','Microsoft Yahei',sans-serif")

(def select
  {:min-width 120,
   :vertical-align :top,
   :font-size 14,
   :background-color colors/paper,
   :outline "none",
   :border "none",
   :font-family default-fonts,
   :height 32})

(def column-center
  {:align-items "center",
   :justify-content "space-around",
   :display "flex",
   :flex-direction "column"})

(def global
  {:line-height 2, :color colors/texture, :font-size "14px", :font-family default-fonts})

(def input
  (merge
   global
   {:line-height "16px",
    :min-width "120px",
    :vertical-align :top,
    :font-size "14px",
    :background-color colors/paper,
    :padding "8px 8px",
    :outline "none",
    :border "none",
    :font-family default-fonts,
    :height 32}))

(def column {:align-items "stretch", :display "flex", :flex-direction "column"})

(def textarea
  {:min-width 240,
   :vertical-align :top,
   :font-size 14,
   :background-color colors/paper,
   :padding 8,
   :outline :none,
   :border :none,
   :font-family default-fonts})

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
   :vertical-align :top,
   :font-size 14,
   :background-color colors/motif,
   :cursor "pointer",
   :padding "0 8px",
   :outline :none,
   :display "inline-block",
   :border :none})
