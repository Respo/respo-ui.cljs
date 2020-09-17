
(ns respo-ui.comp.lay-out-page
  (:require [respo.core :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]
            [respo.comp.space :refer [=<]]
            [respo-ui.lay-out :refer [lay-out]]))

(def style-title
  {:font-size 24,
   :font-family ui/font-fancy,
   :font-weight 300,
   :color (hsl 0 0 80),
   :margin "16px 0",
   :display :inline-block})

(defcomp
 comp-lay-out-page
 ()
 (div
  {}
  (<> "Flex layout" style-title)
  (lay-out
   {:type :flex,
    :style {:border (str "1px solid " (hsl 0 0 80))},
    :layout :row,
    :gap 10,
    :items [{:type :flex,
             :layout :column,
             :gap 4,
             :items [{:type :item, :fill :a} {:type :item, :fill :a}]}
            {:type :item, :fill :b}
            {:type :item, :fill :c}]}
   {:a #(div {:style %} (<> "TODO A")),
    :b #(div {:style %} (<> "TODO BB")),
    :c #(div {:style %} (<> "TODO CCC"))})
  (<> "Flex flow layout" style-title)
  (lay-out
   {:type :flex,
    :style {:border (str "1px solid " (hsl 0 0 80))},
    :layout :flow,
    :gap [4 4],
    :items [{:type :item, :fill :a} {:type :item, :fill :b} {:type :item, :fill :c}]}
   {:a #(div {:style %} (<> "TODO A")),
    :b #(div {:style %} (<> "TODO BB")),
    :c #(div {:style %} (<> "TODO CCC"))})
  (<> "Flex layout" style-title)
  (lay-out
   {:type :list,
    :style {:border (str "1px solid " (hsl 0 0 80))},
    :layout :column,
    :size 4,
    :gap 10}
   (fn [idx styles] (div {:style styles} (<> "TODO list"))))
  (<> "Flex list layout" style-title)
  (lay-out
   {:type :list,
    :style {:border (str "1px solid " (hsl 0 0 80))},
    :layout :flow,
    :size 4,
    :gap [4 4]}
   (fn [idx styles] (div {:style (merge styles {:display :inline-block})} (<> "TODO list"))))))
