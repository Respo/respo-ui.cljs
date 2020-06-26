
(ns respo-ui.comp
  (:require [respo.core
             :refer
             [defcomp div list-> input textarea button span select option a <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]))

(defcomp
 comp-placeholder
 (text)
 (div
  {:style (merge
           ui/center
           {:padding 16,
            :font-family ui/font-fancy,
            :color (hsl 0 0 80),
            :font-size 12,
            :font-style :italic})}
  (<> text)))

(defn comp-sidebar [] )

(defcomp
 comp-snippet
 (text styles)
 (div
  {:style (merge
           {:font-family ui/font-code,
            :white-space :pre,
            :font-size 12,
            :line-height "20px",
            :color (hsl 0 0 40),
            :padding "4px 6px",
            :border (str "1px solid " (hsl 0 0 90)),
            :border-radius "4px"}
           styles)}
  (<> text)))

(defcomp
 comp-tabs
 (options tabs on-route)
 (list->
  {:style (merge
           (if (:vertical? options) ui/column ui/row)
           {:padding "8px 16px 0", :width (:width options)}
           (:style options))}
  (->> tabs
       (map
        (fn [info]
          [(:name info)
           (div
            {:style (merge
                     {:padding "0 8px",
                      :font-family ui/font-fancy,
                      :font-weight 300,
                      :cursor :pointer,
                      :font-size 16,
                      :color (hsl 0 0 70),
                      :line-height "32px"}
                     (if (= (:selected options) (:name info))
                       {:font-weight 500, :color (hsl 0 0 30)})),
             :on-click (fn [e d!] (on-route info d!))}
            (<> (:title info)))])))))
