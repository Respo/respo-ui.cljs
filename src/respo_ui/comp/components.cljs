
(ns respo-ui.comp.components
  (:require [respo.core :refer [defcomp >> div a <> pre code]]
            [respo.comp.space :refer [=<]]
            [respo-ui.comp :refer [comp-tabs comp-placeholder comp-snippet]]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]))

(def style-title
  {:margin-top 40, :font-size 18, :font-family ui/font-fancy, :color (hsl 0 0 70)})

(defcomp
 comp-demo-placeholder
 ()
 (div
  {:style style-title}
  (div {} (<> "Placeholder demo"))
  (comp-placeholder "This is a demo")
  (comp-placeholder "中文 Demo")
  (comp-snippet
   "respo-ui.comp/comp-placeholder\n\n(comp-placeholder \"demo\")\n(comp-placeholder \"中文\")"
   {})))

(defcomp
 comp-demo-tabs
 (states)
 (let [cursor (:cursor states)
       state (or (:data states) {:selected nil})
       en-tabs [{:name :book, :title "Book"}
                {:name :card, :title "Card"}
                {:name :pl, :title "Programming language"}]]
   (div
    {}
    (div {:style style-title} (<> "Tabs demo"))
    (comp-tabs
     {:selected (:selected state)}
     en-tabs
     (fn [info d!]
       (println "selected" info)
       (d! cursor (assoc state :selected (:name info)))))
    (comp-tabs
     {:selected (:selected state)}
     [{:name :book, :title "书本"} {:name :card, :title "纸牌"} {:name :pl, :title "编程语言"}]
     (fn [info d!]
       (println "selected" info)
       (d! cursor (assoc state :selected (:name info)))))
    (comp-tabs
     {:selected (:selected state), :style {:border-bottom (str "1px solid " (hsl 0 0 90))}}
     en-tabs
     (fn [info d!]
       (println "selected" info)
       (d! cursor (assoc state :selected (:name info)))))
    (=< nil 8)
    (comp-snippet
     "respo-ui.comp/comp-tabs\n\n(comp-tabs\n {:selected (:selected state) :style {}}\n [{:name :book, :title \"Book\"}\n  {:name :card, :title \"Card\"}\n  {:name :pl, :title \"Programming language\"}]\n (fn [info d!]\n   (println \"selected\" info)\n   (d! cursor (assoc state :selected (:name info)))))"
     {})
    (comp-tabs
     {:selected (:selected state), :vertical? true, :width 200, :style {}}
     en-tabs
     (fn [info d!]
       (println "selected" info)
       (d! cursor (assoc state :selected (:name info)))))
    (comp-snippet
     "respo-ui.comp/comp-tabs\n\n(comp-tabs\n {:selected (:selected state) :style {}, :vertical? true, :width 200}\n tabs (fn [info d!]))"
     {}))))

(defn render-entry [url title] (div {} (a {:href url, :inner-text title})))

(defcomp
 comp-components-page
 (states)
 (let [state (or (:data states) false)]
   (div
    {:style {:padding-bottom "50vh"}}
    (div
     {}
     (<> "There are also components follow the guidelines of Respo UI:")
     (render-entry "https://github.com/Respo/alerts" "alerts")
     (render-entry "https://github.com/Respo/respo-feather" "respo-feather")
     (render-entry "https://github.com/Respo/respo-message" "respo-message")
     (render-entry "https://github.com/Respo/respo-markdown" "respo-markdown")
     (render-entry "https://github.com/Respo/notifier" "notifier"))
    (=< nil 32)
    (div
     {}
     (<> "Built-in Components")
     (=< 8 nil)
     (a
      {:href "https://github.com/Respo/respo-ui/blob/master/src/respo_ui/comp/components.cljs",
       :target "_blank",
       :inner-text "Source"}))
    (comp-demo-placeholder)
    (comp-demo-tabs (>> states :tabs)))))
