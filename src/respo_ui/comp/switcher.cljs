
(ns respo-ui.comp.switcher
  (:require [respo.alias :refer [create-comp div a img]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style.colors :as colors]))

(def style-switcher
  {:background-color colors/paper,
   :width 96,
   :height 16,
   :position :relative,
   :cursor :pointer,
   :transition-duration "300ms",
   :margin-bottom 16,
   :display :inline-block,
   :vertical-align :top})

(def style-button
  {:background-color colors/motif,
   :height 32,
   :width 32,
   :position :absolute,
   :left 0,
   :opacity 0.3,
   :transition-duration "300ms"})

(def comp-switcher
  (create-comp
   :switcher
   (fn [status on-change]
     (fn [state mutate!]
       (div
        {:style style-switcher, :event {:click (fn [e dispatch!] (on-change (not status)))}}
        (div {:style (merge style-button (if status {:left 64, :opacity 1}))}))))))
