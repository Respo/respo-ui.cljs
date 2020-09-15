
(ns respo-ui.lay-out (:require [respo.core :refer [<> list-> div]] [hsl.core :refer [hsl]]))

(defn render-layout-flex [rule child-map options]
  (list-> {} (->> (:items rule) (map-indexed (fn [idx] [idx (div {} (<> "TODO"))])))))

(defn lay-out
  ([rule child-map] (lay-out rule {} child-map))
  ([rule child-map options]
   (case (:type rule)
     :flex (render-layout-flex rule child-map options)
     :list (<> "TODO list...")
     :flow (<> "TODO flow......")
     :grid (<> "TODO grid")
     :item
       (let [item (get child-map (:fill rule))]
         (cond
           (nil? item) (<> (str "nothing to fill: " (pr-str rule)) {:color (hsl 0 80 80)})
           (some? (:item item)) (:item item)
           (fn? (:render item)) ((:render item) nil nil)
           :else (<> (str "Unknown case: " (pr-str item)) {:color (hsl 0 80 80)})))
     (<> (str "Unknown rule: " (pr-str rule)) {:color (hsl 0 80 80)}))))
