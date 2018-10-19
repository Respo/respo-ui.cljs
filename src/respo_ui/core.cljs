
(ns respo-ui.core (:require [hsl.core :refer [hsl]] [respo-ui.colors :as colors]))

(def button
  {:min-width "80px",
   :line-height "30px",
   :border-radius "16px",
   :font-size 14,
   :text-align "center",
   :border (str "1px solid " colors/motif),
   :color colors/motif,
   :cursor "pointer",
   :display "inline-block",
   :padding "0 8px",
   :outline :none,
   :vertical-align :top,
   :background-color :white})

(def card {:padding "16px"})

(def center
  {:display "flex",
   :flex-direction "column",
   :justify-content "center",
   :align-items "center"})

(def column {:display "flex", :align-items "stretch", :flex-direction "column"})

(def column-dispersive
  {:display "flex",
   :align-items "center",
   :justify-content "space-around",
   :flex-direction "column"})

(def column-parted
  {:display :flex,
   :align-items :stretch,
   :justify-content :space-between,
   :flex-direction :column})

(def default-fonts
  "Hind,Verdana,'Hiragino Sans GB','WenQuanYi Micro Hei','Microsoft Yahei',sans-serif")

(def flex {:flex 1})

(def font-code "Source Code Pro, Menlo, monospace")

(def font-fancy "Josefin Sans, Helvetica neue, Arial, sans-serif")

(def font-normal "Hind, Helvatica, Arial, sans-serif")

(def fullscreen
  {:position "absolute", :left 0, :top 0, :width "100%", :height "100%", :overflow :auto})

(def global
  {:line-height 2, :font-size "14px", :font-family default-fonts, :color colors/texture})

(def input
  (merge
   global
   {:border (str "1px solid " (hsl 0 0 80)),
    :outline "none",
    :border-radius "4px",
    :font-size "14px",
    :padding "8px 8px",
    :min-width "120px",
    :line-height "16px",
    :height 32,
    :font-family default-fonts,
    :vertical-align :top}))

(def link
  {:color colors/motif,
   :text-decoration :underline,
   :user-select :no-select,
   :height 24,
   :line-height "24px",
   :margin 4,
   :display :inline-block,
   :cursor :pointer})

(def row {:display "flex", :align-items "stretch", :flex-direction "row"})

(def row-center
  {:display "flex", :align-items "center", :justify-content "center", :flex-direction "row"})

(def row-dispersive
  {:display "flex",
   :align-items "center",
   :justify-content "space-around",
   :flex-direction "row"})

(def row-middle
  {:display :flex, :align-items :center, :justify-content :flex-start, :flex-direction :row})

(def row-parted
  {:display "flex",
   :align-items "center",
   :justify-content "space-between",
   :flex-direction "row"})

(def select
  {:height 32,
   :outline "none",
   :font-size 14,
   :min-width 120,
   :border (str "1px solid " (hsl 0 0 80)),
   :border-radius "4px",
   :font-family default-fonts,
   :vertical-align :top})

(def text-label
  {:line-height "32px",
   :font-size 14,
   :color colors/texture,
   :display :inline-block,
   :vertical-align :top})

(def textarea
  {:outline :none,
   :border (str "1px solid " (hsl 0 0 80)),
   :font-size 14,
   :font-family default-fonts,
   :border-radius "4px",
   :padding 8,
   :min-width 240,
   :vertical-align :top})
