
(ns respo-ui.comp.home
  (:require [respo.alias :refer [create-comp div a img]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style.colors :as colors]))

(def repo-url "http://github.com/Respo/respo-ui")

(def style-logo
  {:background-image "url(http://logo.respo.site/respo.png)",
   :width 160,
   :height 160,
   :background-size :cover})

(def comp-home
  (create-comp
   :home
   (fn []
     (fn [state mutate!]
       (div
        {}
        (div
         {:style {:font-size 48,
                  :font-family "Josefin Sans",
                  :color colors/motif,
                  :font-weight 100}}
         (comp-text "Styles for Respo" nil)
         (comp-space 16 nil)
         (img {:attrs {:src "https://img.shields.io/clojars/v/respo/ui.svg"}}))
        (div {:style style-logo})
        (comp-space nil 32)
        (div
         {}
         (comp-text "Find more at: ")
         (a {:attrs {:href repo-url}} (comp-text repo-url nil))))))))
