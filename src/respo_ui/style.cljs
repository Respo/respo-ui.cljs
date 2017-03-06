
(ns respo-ui.style (:require [hsl.core :refer [hsl]] [respo-ui.style.colors :as colors]))

(def clickable-text
  {:color colors/motif,
   :text-decoration :underline,
   :user-select :no-select,
   :height 24,
   :line-height "24px",
   :margin 4,
   :padding "0 8px",
   :display :inline-block,
   :cursor :pointer})

(def text-label
  {:line-height "32px",
   :font-size 14,
   :color colors/texture,
   :display :inline-block,
   :vertical-align :top})

(def center
  {:display "flex",
   :flex-direction "column",
   :justify-content "center",
   :align-items "center"})

(def default-fonts
  "Hind,Verdana,'Hiragino Sans GB','WenQuanYi Micro Hei','Microsoft Yahei',sans-serif")

(def select
  {:height 32,
   :outline "none",
   :font-size 14,
   :min-width 120,
   :border "none",
   :background-color colors/paper,
   :font-family default-fonts,
   :vertical-align :top})

(def column-center
  {:display "flex",
   :align-items "center",
   :justify-content "space-around",
   :flex-direction "column"})

(def global
  {:line-height 2, :font-size "14px", :font-family default-fonts, :color colors/texture})

(def input
  (merge
   global
   {:border "none",
    :outline "none",
    :background-color colors/paper,
    :font-size "14px",
    :padding "8px 8px",
    :min-width "120px",
    :line-height "16px",
    :height 32,
    :font-family default-fonts,
    :vertical-align :top}))

(def column {:display "flex", :align-items "stretch", :flex-direction "column"})

(def textarea
  {:outline :none,
   :border :none,
   :font-size 14,
   :font-family default-fonts,
   :background-color colors/paper,
   :padding 8,
   :min-width 240,
   :vertical-align :top})

(def row {:display "flex", :align-items "stretch", :flex-direction "row"})

(def fullscreen {:position "absolute", :left 0, :top 0, :width "100%", :height "100%"})

(def card {:padding "16px"})

(def flex {:flex 1})

(def row-center
  {:display "flex",
   :align-items "center",
   :justify-content "space-around",
   :flex-direction "row"})

(def button
  {:min-width "80px",
   :line-height "32px",
   :font-size 14,
   :text-align "center",
   :background-color colors/motif,
   :color (hsl 0 0 100),
   :cursor "pointer",
   :display "inline-block",
   :padding "0 8px",
   :border :none,
   :outline :none,
   :vertical-align :top})
