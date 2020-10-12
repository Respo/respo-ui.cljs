
(ns respo-ui.lay-out
  (:require [respo.core :refer [<> list-> div]]
            [respo.comp.space :refer [=<]]
            [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [lilac.core
             :refer
             [dev-check
              number+
              record+
              string+
              keyword+
              or+
              vector+
              any+
              map+
              enum+
              tuple+
              is+
              optional+]]))

(declare render-layout-flex)

(declare lay-out)

(defn add-gap
  ([f xs] (add-gap [] 0 f xs))
  ([acc n f xs]
   (if (empty? xs)
     acc
     (add-gap
      (if (empty? acc) [(first xs)] (conj acc (f n) (first xs)))
      (inc n)
      f
      (rest xs)))))

(defn gen-gap-fn [rule]
  (fn [idx]
    [(str idx "-gap")
     (cond
       (contains? #{:row :row-parted :row-middle :row-center} (:layout rule))
         (=< (:gap rule) nil)
       (= :flow (:layout rule))
         (=<
          (let [gap (:gap rule)]
            (cond (vector? gap) (first gap) (number? gap) gap :else nil))
          nil)
       (contains? #{:column :column-parted :center} (:layout rule)) (=< nil (:gap rule))
       :else (div {:style {:background-color :red, :width 4, :height 4}}))]))

(def style-no-match {:outline (str "1px solid red")})

(defn get-layout-style [layout-name]
  (case layout-name
    :row ui/row
    :column ui/column
    :center ui/center
    :row-middle ui/row-middle
    :row-center ui/row-center
    :row-parted ui/row-parted
    :column-parted ui/column-parted
    :flow {}
    style-no-match))

(def lilac-gap (optional+ (or+ [(number+) (tuple+ [(number+) (number+)])])))

(def lilac-layout-names
  (optional+
   (enum+ #{:column :row :row-parted :column-parted :center :row-center :row-middle :flow})))

(def lilac-style (optional+ (map+ (keyword+) (any+))))

(def lilac-flex-rule
  (record+
   {:type (is+ :flex),
    :layout lilac-layout-names,
    :style lilac-style,
    :gap lilac-gap,
    :items (vector+
            (or+
             [(record+ {:type (is+ :item), :style lilac-style, :fill (any+)})
              (record+ {:type (is+ :flex)})])
            {:allow-seq? true})}
   {:check-keys? true}))

(def lilac-item-rule
  (record+
   {:type (is+ :item), :style lilac-style, :fill (optional+ (any+))}
   {:check-keys? true}))

(def lilac-list-rule
  (record+
   {:type (is+ :list),
    :layout lilac-layout-names,
    :style lilac-style,
    :size (number+),
    :gap lilac-gap}))

(def style-todo {:color (hsl 0 80 80), :border (str "1px solid " (hsl 0 0 94))})

(defn render-fill-item [rule child-map options]
  (dev-check rule lilac-item-rule)
  (let [item (get child-map (:fill rule))]
    (cond
      (nil? item) (<> (str "nothing to fill: " (pr-str rule)) style-todo)
      (fn? item) (item (merge ui/flex (:style item)) options)
      (some? (:item item)) (:item item)
      (fn? (:render item)) ((:render item) (merge ui/flex (:style item)) options)
      :else (<> (str "Unknown case: " (pr-str item)) style-todo))))

(defn render-layout-list [rule item-renderer options]
  (dev-check rule lilac-list-rule)
  (list->
   {:style (merge (get-layout-style (:layout rule)) (:style rule))}
   (->> (range (:size rule))
        (map-indexed
         (fn [idx]
           [(str idx)
            (let [custom-style (if (= :flow (:layout rule))
                                 {:margin-bottom (last (:gap rule))}
                                 ui/flex)]
              (item-renderer idx custom-style options))]))
        (add-gap (gen-gap-fn rule)))))

(defn render-layout-flex [rule child-map options]
  (dev-check rule lilac-flex-rule)
  (list->
   {:style (merge (get-layout-style (:layout rule)) (:style rule))}
   (->> (:items rule)
        (map-indexed
         (fn [idx item]
           [(str idx)
            (let [custom-style (if (= :flow (:layout rule))
                                 {:margin-bottom (last (:gap rule))}
                                 ui/flex)]
              (lay-out (assoc item :style custom-style) child-map options))]))
        (add-gap (gen-gap-fn rule)))))

(defn lay-out
  ([rule child-map] (lay-out rule child-map {}))
  ([rule child-map options]
   (case (:type rule)
     :flex (render-layout-flex rule child-map options)
     :list (render-layout-list rule child-map options)
     :grid (<> "TODO grid" style-todo)
     :item (render-fill-item rule child-map options)
     (<> (str "Unknown rule: " (pr-str rule)) style-todo))))

(def lilac-number-pair (optional+ (tuple+ [(number+) (number+)])))

(def lilac-grid-rule
  (record+
   {:type (is+ :grid),
    :style lilac-style,
    :size lilac-number-pair,
    :gap lilac-gap,
    :items (vector+
            (record+
             {:from lilac-number-pair,
              :size lilac-number-pair,
              :item (record+ {:type (enum+ #{:item}), :fill (any+)})}))}))
