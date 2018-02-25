
(ns respo-ui.main
  (:require [respo.core :refer [render! clear-cache! realize-ssr!]]
            [respo.cursor :refer [mutate]]
            [respo-ui.comp.container :refer [comp-container]]
            [respo-router.core :refer [render-url!]]
            [respo-router.listener :refer [listen!]]
            [respo-router.parser :refer [parse-address]]
            [respo-ui.router :as router]
            [cljs.reader :refer [read-string]]
            [respo-ui.schema :as schema]))

(defonce *store
  (atom
   (merge
    schema/store
    {:router (parse-address
              (str (.-pathname js/location) (.-search js/location))
              router/dict),
     :mobile? (< (.-innerWidth js/window) 600)})))

(defn updater [store op op-data]
  (case op
    :states (update store :states (mutate op-data))
    :router/nav (assoc store :router (parse-address op-data router/dict))
    store))

(defn dispatch! [op op-data]
  (println "Dispatch!" op op-data)
  (reset! *store (updater @*store op op-data)))

(def mount-target (.querySelector js/document ".app"))

(defn render-app! [renderer] (renderer mount-target (comp-container @*store) dispatch!))

(defn render-router! [] (render-url! (:router @*store) router/dict router/mode))

(def ssr? (some? (.querySelector js/document "meta.respo-ssr")))

(defn main! []
  (if ssr? (render-app! realize-ssr!))
  (render-app! render!)
  (add-watch *store :changes (fn [] (render-app! render!)))
  (render-router!)
  (listen! router/dict dispatch! router/mode)
  (add-watch *store :router-changes render-router!)
  (println "App started!"))

(defn reload! [] (clear-cache!) (render-app! render!) (println "Code updated!"))

(set! js/window.onload main!)
