
(ns respo-ui.comp.lay-out-page
  (:require [respo.core :refer [defcomp div <>]]
            [respo-ui.core :as ui]
            [hsl.core :refer [hsl]]
            [respo.comp.space :refer [=<]]
            [respo-ui.lay-out :refer [lay-out]]))

(defcomp
 comp-lay-out-page
 ()
 (div
  {}
  (div {} (<> "Rows"))
  (lay-out
   {:type :flex,
    :layout :row,
    :style ui/row-middle,
    :gap 10,
    :items [{:type :item, :fill :a} {:type :item, :fill :b} {:type :item, :fill :c}]}
   {:a {:item (<> "TODO")}, :c {:render (fn [styles props] (div {:style styles}))}})
  (lay-out
   {:type :list,
    :layout :column,
    :style ui/row-middle,
    :size (count []),
    :gap 0,
    :item-template {:type :item, :fill 'idx}}
   {})
  (lay-out
   {:type :grid,
    :size [6 6],
    :gap [10 10],
    :items [{:from [1 1], :size [4 2], :item {:type :item, :fill :a}}]}
   {})
  (div {} (<> "Columns"))
  (div {} (<> "Mixed"))
  (div {} (<> "Listed"))))
