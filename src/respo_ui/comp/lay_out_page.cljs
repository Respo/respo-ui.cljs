
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
    :layout :row,
    :gap 10,
    :items [{:type :item, :fill :a} {:type :item, :fill :b} {:type :item, :fill :c}]}
   {:a (fn [] (<> "TODO A")),
    :b (fn [] (<> "TODO BB")),
    :c (fn [styles] (div {:style styles} (<> "TODO CCC")))})
  (<> "Flex flow layout" style-title)
  (lay-out
   {:type :flex,
    :layout :flow,
    :gap [4 4],
    :items [{:type :item, :fill :a} {:type :item, :fill :b} {:type :item, :fill :c}]}
   {:a (fn [] (<> "TODO A")),
    :b (fn [] (<> "TODO BB")),
    :c (fn [styles] (div {:style styles} (<> "TODO CCC")))})
  (<> "Flex layout" style-title)
  (lay-out
   {:type :list, :layout :column, :size 4, :gap 10}
   (fn [idx styles] (<> "TODO list")))
  (<> "Flex list layout" style-title)
  (lay-out
   {:type :list, :layout :flow, :size 4, :gap [4 4]}
   (fn [idx styles] (<> "TODO list")))))
