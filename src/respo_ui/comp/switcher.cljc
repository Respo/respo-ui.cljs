
(ns respo-ui.comp.switcher
  (:require [respo.alias :refer [create-comp div a img]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style.colors :as colors]))

(def style-button
  {:background-color colors/motif,
   :width 32,
   :opacity 0.3,
   :position :absolute,
   :transition-duration "300ms",
   :height 32,
   :left 0})

(def style-switcher
  {:vertical-align :top,
   :background-color colors/paper,
   :width 96,
   :cursor :pointer,
   :display :inline-block,
   :position :relative,
   :transition-duration "300ms",
   :margin-bottom 16,
   :height 16})

(def comp-switcher
  (create-comp
   :switcher
   (fn [status on-change]
     (fn [state mutate!]
       (div
        {:style style-switcher, :event {:click (fn [e dispatch!] (on-change (not status)))}}
        (div {:style (merge style-button (if status {:opacity 1, :left 64}))}))))))
