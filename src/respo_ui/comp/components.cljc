
(ns respo-ui.comp.components
  (:require [respo.alias :refer [create-comp div a]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.comp.switcher :refer [comp-switcher]]))

(defn update-state [state new-state] new-state)

(defn render-entry [url title] (div {} (a {:attrs {:inner-text title, :href url}})))

(defn init-state [& args] {:switcher-on? false})

(def comp-components-page
  (create-comp
   :components
   init-state
   update-state
   (fn []
     (fn [state mutate!]
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
          {:attrs {:inner-text "Source",
                   :target "_blank",
                   :href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/components.cljc"}}))
        (div
         {}
         (comp-text "respo-ui.comp.switcher/comp-switcher")
         (comp-space 16 nil)
         (comp-switcher
          (:switcher-on? state)
          (fn [new-status] (mutate! (assoc state :switcher-on? new-status))))))))))
