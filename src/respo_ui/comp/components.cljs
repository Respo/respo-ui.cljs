
(ns respo-ui.comp.components
  (:require [respo.alias :refer [create-comp div a]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.comp.switchy :refer [comp-switch]]))

(defn update-state [state new-state] new-state)

(defn render-entry [url title] (div {} (a {:attrs {:href url, :inner-text title}})))

(defn init-state [& args] {:switch-on? false})

(def comp-components-page
  (create-comp
   :components
   (fn [states]
     (fn [cursor]
       (let [state (or (:data states) false)]
         (div
          {}
          (div
           {}
           (comp-text "There are also components follow the guidelines of Respo UI:" nil)
           (render-entry "https://github.com/Respo/global-popup" "global-popup")
           (render-entry "https://github.com/Respo/inflow-popup" "inflow-popup")
           (render-entry "https://github.com/Respo/respo-message" "respo-message"))
          (comp-space nil 32)
          (div
           {}
           (comp-text "Built-in Components")
           (comp-space 8 nil)
           (a
            {:attrs {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/components.cljs",
                     :target "_blank",
                     :inner-text "Source"}}))
          (div
           {}
           (comp-text "respo-ui.comp.switchy/comp-switch")
           (comp-space 16 nil)
           (comp-switch
            state
            (fn [new-status dispatch!] (dispatch! :states [cursor (not state)]))))))))))
