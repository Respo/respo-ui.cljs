
(ns respo-ui.comp.widgets-page
  (:require [respo.macros :refer [defcomp div input textarea button span select option a <>]]
            [respo.comp.space :refer [=<]]
            [respo-ui.core :as ui]
            [respo-ui.colors :as colors]))

(defcomp
 comp-widgets-page
 (states)
 (let [state (:data states)]
   (div
    {}
    (div
     {}
     (<> "Widgets")
     (=< 8 nil)
     (a
      {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/widgets_page.cljs",
       :target "_blank",
       :inner-text "Source"}))
    (div
     {}
     (<> span "Some text as description" ui/text-label)
     (=< nil 16)
     (<> span "link" ui/link))
    (=< nil 16)
    (div
     {}
     (button
      {:style (merge ui/button {:border-color colors/attractive, :color colors/attractive})}
      (<> "Yes"))
     (=< 16 nil)
     (button
      {:style (merge
               ui/button
               {:border-color colors/irreversible, :color colors/irreversible})}
      (<> "Yes"))
     (=< 16 nil))
    (=< nil 16)
    (div
     {}
     (input
      {:placeholder "Some short text",
       :value state,
       :style ui/input,
       :on {:input (fn [e dispatch! mutate!] (mutate! (:value e)))}})
     (=< 16 nil)
     (button {:style (merge ui/button)} (<> "Add"))
     (=< 16 nil)
     (<> span "nothing" ui/text-label))
    (=< nil 16)
    (div
     {}
     (select
      {:style ui/select}
      (option {:selected true, :inner-text "Haskell"})
      (option {:selected true, :inner-text "Clojure"})
      (option {:selected false, :inner-text "OCaml"})))
    (=< nil 16)
    (div
     {}
     (textarea {:placeholder "Some long text", :style ui/textarea})
     (=< 16 nil)
     (button {:style (merge ui/button)} (<> "Add"))))))
