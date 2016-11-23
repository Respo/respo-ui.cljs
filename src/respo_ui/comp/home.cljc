
(ns respo-ui.comp.home
  (:require [respo.alias :refer [create-comp div a img]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style.colors :as colors]))

(def repo-url "http://github.com/Respo/respo-ui")

(def style-logo
  {:width 160,
   :background-image "url(http://logo.respo.site/respo.png)",
   :background-size :cover,
   :height 160})

(defn render []
  (fn [state mutate!]
    (div
     {}
     (div
      {:style {:color colors/motif,
               :font-size 48,
               :font-weight 100,
               :font-family "Josefin Sans"}}
      (comp-text "Styles for Respo" nil)
      (comp-space 16 nil)
      (img {:attrs {:src "https://img.shields.io/clojars/v/respo/ui.svg"}}))
     (div {:style style-logo})
     (comp-space nil 32)
     (div
      {}
      (comp-text "Find more at: ")
      (a {:attrs {:href repo-url}} (comp-text repo-url nil))))))

(def comp-home (create-comp :home render))
