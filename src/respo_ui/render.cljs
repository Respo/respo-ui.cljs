
(ns respo-ui.render
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [respo-ui.comp.container :refer [comp-container]]
            [respo-ui.schema :as schema]
            [respo-ui.router :as router]
            [respo-router.parser :refer [parse-address]]
            [cljs.reader :refer [read-string]]))

(def base-info {:title "Respo UI", :icon "http://cdn.tiye.me/logo/respo.png", :ssr nil})

(defn dev-page []
  (make-page
   ""
   (merge
    base-info
    {:styles ["http://localhost:8100/main.css"],
     :scripts ["/browser/lib.js" "/browser/main.js"]})))

(def page-routes
  ["/index.html"
   "/widgets.html"
   "/colors.html"
   "/layouts.html"
   "/fonts.html"
   "/components.html"])

(def preview? (= "preview" js/process.env.prod))

(defn prod-page [path]
  (let [assets (read-string (slurp "dist/assets.edn"))
        cdn (if preview? "" "http://cdn.tiye.me/respo-ui/")
        prefix-cdn (fn [x] (str cdn x))
        page-options (merge
                      base-info
                      {:styles ["http://cdn.tiye.me/favored-fonts/main.css"],
                       :scripts (map #(-> % :output-name prefix-cdn) assets),
                       :ssr nil})]
    (make-page
     (make-string
      (comp-container (assoc schema/store :router (parse-address path router/dict))))
     page-options)))

(defn main! []
  (if (= js/process.env.env "dev")
    (spit "target/index.html" (dev-page))
    (doseq [path page-routes] (spit (str "dist" path) (prod-page path)))))
