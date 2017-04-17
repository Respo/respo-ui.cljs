
(ns respo-ui.comp.widgets-page
  (:require [respo.alias :refer [create-comp create-element div input textarea button a]]
            [respo.comp.text :refer [comp-text]]
            [respo.comp.space :refer [comp-space]]
            [respo-ui.style :as ui]
            [respo-ui.style.colors :as colors]))

(defn option [props & children] (create-element :option props children))

(defn select [props & children] (create-element :select props children))

(def comp-widgets-page
  (create-comp
   :widget-page
   (fn [states]
     (fn [cursor]
       (let [state (:data states)]
         (div
          {}
          (div
           {}
           (comp-text "Widgets" nil)
           (comp-space 8 nil)
           (a
            {:attrs {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/widgets_page.cljs",
                     :target "_blank",
                     :inner-text "Source"}}))
          (div
           {}
           (comp-text "Some text as description" ui/text-label)
           (comp-space nil 16)
           (comp-text "clickable" ui/clickable-text))
          (comp-space nil 16)
          (div
           {}
           (button
            {:style (merge ui/button {:background-color colors/attractive})}
            (comp-text "Yes" nil))
           (comp-space 16 nil)
           (button
            {:style (merge ui/button {:background-color colors/irreversible})}
            (comp-text "Yes" nil))
           (comp-space 16 nil))
          (comp-space nil 16)
          (div
           {}
           (input
            {:style ui/input,
             :attrs {:placeholder "Some short text"},
             :event {:input (fn [e dispatch!] (dispatch! :states [cursor (:value e)]))}})
           (comp-space 16 nil)
           (button {:style (merge ui/button)} (comp-text "Add" nil))
           (comp-space 16 nil)
           (comp-text "nothing" ui/text-label))
          (comp-space nil 16)
          (div
           {}
           (select
            {:style ui/select}
            (option {:attrs {:selected true, :inner-text "Haskell"}})
            (option {:attrs {:selected true, :inner-text "Clojure"}})
            (option {:attrs {:selected false, :inner-text "OCaml"}})))
          (comp-space nil 16)
          (div
           {}
           (textarea {:style ui/textarea, :attrs {:placeholder "Some long text"}})
           (comp-space 16 nil)
           (button {:style (merge ui/button)} (comp-text "Add" nil)))))))))
