
(ns respo-ui.main
  (:require [respo.core :refer [render! clear-cache! falsify-stage! render-element]]
            [respo-ui.comp.container :refer [comp-container]]
            [respo-router.core :refer [render-url!]]
            [respo-router.util.listener :refer [listen! parse-address]]
            [respo-ui.router :as router]
            [cljs.reader :refer [read-string]]))

(defn updater [store op op-data]
  (case op
    :router/route (assoc store :router op-data)
    :router/nav (assoc store :router (parse-address op-data router/dict))
    store))

(defonce store-ref
  (atom
   {:router (parse-address
             (str (.-pathname js/location) (.-search js/location))
             router/dict)}))

(defn dispatch! [op op-data]
  (println "Dispatch!" op op-data)
  (reset! store-ref (updater @store-ref op op-data)))

(defn render-router! [] (render-url! (:router @store-ref) router/dict router/mode))

(defonce states-ref (atom {}))

(defn render-app! []
  (let [target (.querySelector js/document "#app")]
    (render! (comp-container @store-ref) target dispatch! states-ref)))

(def ssr-stages
  (let [ssr-element (.querySelector js/document "#ssr-stages")
        ssr-markup (.getAttribute ssr-element "content")]
    (read-string ssr-markup)))

(defn -main! []
  (enable-console-print!)
  (if (not (empty? ssr-stages))
    (let [target (.querySelector js/document "#app")]
      (falsify-stage!
       target
       (render-element (comp-container @store-ref ssr-stages) states-ref)
       dispatch!)))
  (render-app!)
  (add-watch store-ref :changes render-app!)
  (add-watch states-ref :changes render-app!)
  (render-router!)
  (listen! router/dict dispatch! router/mode)
  (add-watch store-ref :router-changes render-router!)
  (println "App started!"))

(defn on-jsload! [] (clear-cache!) (render-app!) (println "Code updated!"))

(set! js/window.onload -main!)
