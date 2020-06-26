
(ns respo-ui.comp
  (:require [respo.core
             :refer
             [defcomp div list-> input textarea button span select option a <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]
            ["emotion" :refer [cx css]])
  (:require-macros [clojure.core.strint :refer [<<]]))

(def style-button
  (css
   (<<
    "background-color: white;\npadding: 0px 12px;\ndisplay: inline-block;\nfont-size: 13px;\nline-height: 24px;\nborder-radius: 4px;\ncursor: pointer;\nuser-select: none;\ntransition-duration: 100ms;\n\n&:active {\ntransition-duration: 0ms;\n}")))

(def style-button-cancel
  (css
   "border: 1px solid hsl(0,0%,80%);\ncolor: hsl(0,0%,40%);\n\n&:hover {\n  border-color: hsl(0,0%,85%);\n}\n\n&:active {\n  transform: scale(1.05);\n}\n"))

(def style-button-disabled
  (css "background-color: hsl(0,0%,80%);\ncolor: white;\ncursor: not-allowed;"))

(def style-button-main
  (css
   "background-color: hsl(200,90%,60%);\ncolor: white;\n\n&:hover {\nbackground-color: hsl(200,90%,65%);\n}\n\n&:active {\ntransform: scale(1.05);\n}"))

(def style-button-normal
  (css
   "border: 1px solid hsl(0,0%,80%);\ncursor: pointer;\n\n&:active {\ntransform: scale(1.05);\n}"))

(defcomp
 comp-button
 (props)
 (div
  {:class-name (cx
                style-button
                (if (:disabled? props)
                  style-button-disabled
                  (case (:type props)
                    :main style-button-main
                    :cancel style-button-cancel
                    (do style-button-normal)))
                (:class-name props)),
   :style (:style props),
   :on-click (if (:disabled? props) nil (:on-click props)),
   :disabled (:disabled? props),
   :inner-text (or (:text props) "BUTTON")}))

(def style-link
  (css
   "color: hsl(240,80%,70%);\ntext-decoration: underline;\ncursor: pointer;\ntransition-duration: 100ms;\nuser-select: none;\n\n&:hover {\ncolor: hsl(240,80%,80%);\n}\n\n&:active {\ntransition-duration: 0ms;\ntransform: scale(1.05);\ncolor: hsl(240,80%,65%);\n}"))

(defcomp
 comp-link
 (props)
 (a
  {:href (:href props),
   :on-click (:on-click props),
   :class-name (cx style-link (:class-name props)),
   :style (:style props),
   :inner-text (or (:text props) "LINK")}))

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
