
(ns respo-ui.comp.components
  (:require [respo.macros :refer [defcomp div a <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.comp.switchy :refer [comp-switch]]))

(defn render-entry [url title] (div {} (a {:href url, :inner-text title})))

(defcomp
 comp-components-page
 (states)
 (let [state (or (:data states) false)]
   (div
    {}
    (div
     {}
     (<> "There are also components follow the guidelines of Respo UI:")
     (render-entry "https://github.com/Respo/global-popup" "global-popup")
     (render-entry "https://github.com/Respo/inflow-popup" "inflow-popup")
     (render-entry "https://github.com/Respo/respo-message" "respo-message"))
    (=< nil 32)
    (div
     {}
     (<> "Built-in Components")
     (=< 8 nil)
     (a
      {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/components.cljs",
       :target "_blank",
       :inner-text "Source"}))
    (div
     {}
     (<> "respo-ui.comp.switchy/comp-switch")
     (=< 16 nil)
     (comp-switch state (fn [new-status dispatch! mutate!] (mutate! (not state))))))))
