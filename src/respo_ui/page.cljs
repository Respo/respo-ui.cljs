
(ns respo-ui.page
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [respo-ui.comp.container :refer [comp-container]]
            [respo-ui.schema :as schema]
            [respo-ui.router :as router]
            [respo-router.parser :refer [parse-address]]
            [cljs.reader :refer [read-string]]
            [respo-ui.config :as config]
            [cumulo-util.build :refer [get-ip!]])
  (:require-macros [clojure.core.strint :refer [<<]]))

(def base-info
  {:title (:title config/site), :icon (:icon config/site), :ssr nil, :inline-html nil})

(defn dev-page []
  (make-page
   ""
   (merge
    base-info
    {:styles [(<< "http://~(get-ip!):8100/main.css") "/entry/main.css"],
     :scripts [{:src "/client.js", :defer? true}],
     :inline-styles []})))

(def page-routes
  ["/index.html" "/widgets.html" "/layouts.html" "/fonts.html" "/components.html"])

(defn prod-page [path]
  (let [html-content (make-string
                      (comp-container
                       (assoc schema/store :router (parse-address path router/dict))))
        assets (read-string (slurp "dist/assets.edn"))
        cdn (if config/cdn? (:cdn-url config/site) "")
        prefix-cdn (fn [x] (str cdn x))]
    (make-page
     html-content
     (merge
      base-info
      {:styles [(:release-ui config/site)],
       :scripts (map #({:src (-> % :output-name prefix-cdn), :defer? true}) assets),
       :ssr "respo-ssr",
       :inline-styles [(slurp "./entry/main.css")]}))))

(defn main! []
  (println "Running mode:" (if config/dev? "dev" "release"))
  (if config/dev?
    (spit "target/index.html" (dev-page))
    (doseq [path page-routes] (spit (str "dist" path) (prod-page path)))))
