
(ns respo-ui.comp.switchy
  (:require [respo.macros :refer [defcomp div a img <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.style.colors :as colors]))

(def style-button
  {:background-color colors/motif,
   :height 32,
   :width 32,
   :position :absolute,
   :left 0,
   :opacity 0.3,
   :transition-duration "300ms"})

(def style-switch
  {:background-color colors/paper,
   :width 96,
   :height 16,
   :position :relative,
   :cursor :pointer,
   :transition-duration "300ms",
   :margin-bottom 16,
   :display :inline-block,
   :vertical-align :top})

(defcomp
 comp-switch
 (status on-change)
 (div
  {:style style-switch,
   :on {:click (fn [e dispatch! mutate!] (on-change (not status) dispatch! mutate!))}}
  (div {:style (merge style-button (if status {:left 64, :opacity 1}))})))
