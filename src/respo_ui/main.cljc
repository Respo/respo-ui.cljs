
(ns respo-ui.main
  (:require [respo.core :refer [render! clear-cache!]]
            [respo-ui.comp.container :refer [comp-container]]
            [cljs.reader :refer [read-string]]
            [respo-router.core :refer [render-url!]]
            [respo-router.util.listener :refer [listen! parse-address]]
            [respo-router.core :refer [render-url!]]
            [respo-router.util.listener :refer [listen! parse-address]]))

(def dict {"" [], "widgets.html" [], "dev.html" [], "index.html" [], "colors.html" []})

(defn updater [store op op-data]
  (case op
    :router/route (assoc store :router op-data)
    :router/nav (assoc store :router (parse-address op-data dict))
    store))

(defonce store-ref
  (atom {:router (parse-address (str (.-pathname js/location) (.-search js/location)) dict)}))

(defn dispatch! [op op-data]
  (println "dispatch!" op op-data)
  (reset! store-ref (updater @store-ref op op-data))
  (reset! store-ref (updater @store-ref op op-data)))

(defonce states-ref (atom {}))

(defn render-app! []
  (let [target (.querySelector js/document "#app")]
    (render! (comp-container @store-ref) target dispatch! states-ref)))

(defn on-jsload [] (clear-cache!) (render-app!) (println "code updated."))

(def router-mode :history)

(defn render-router! [] (render-url! (:router @store-ref) dict router-mode))

(defn -main []
  (enable-console-print!)
  (render-app!)
  (add-watch store-ref :changes render-app!)
  (add-watch states-ref :changes render-app!)
  (render-router!)
  (listen! dict dispatch! router-mode)
  (add-watch store-ref :router-changes render-router!)
  (render-router!)
  (listen! dict dispatch! router-mode)
  (add-watch store-ref :router-changes render-router!)
  (println "app started!"))

(set! js/window.onload -main)
