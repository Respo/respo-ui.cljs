
(ns respo-ui.render
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [respo-ui.comp.container :refer [comp-container]]
            [respo-ui.schema :as schema]
            [respo-ui.router :as router]
            [respo-router.util.listener :refer [parse-address]]))

(def base-info {:title "Respo UI", :icon "http://cdn.tiye.me/logo/respo.png", :ssr nil})

(defn dev-page []
  (make-page
   ""
   (merge
    base-info
    {:styles ["http://localhost:8100/main.css"],
     :scripts ["/main.js" "/browser/lib.js" "/browser/main.js"]})))

(def preview? (= "preview" js/process.env.prod))

(defn prod-page [path]
  (let [webpack-info (.parse js/JSON (slurp "dist/webpack-manifest.json"))
        cljs-info (.parse js/JSON (slurp "dist/cljs-manifest.json"))
        cdn (if preview? "" "http://cdn.tiye.me/respo-ui/")
        prefix-cdn (fn [x] (str cdn x))
        page-options (merge
                      base-info
                      {:styles ["http://cdn.tiye.me/favored-fonts/main.css"
                                (prefix-cdn (aget webpack-info "main.css"))],
                       :scripts (map
                                 prefix-cdn
                                 [(-> cljs-info (aget 0) (aget "js-name"))
                                  (-> cljs-info (aget 1) (aget "js-name"))]),
                       :ssr nil})]
    (make-page
     (make-string
      (comp-container (assoc schema/store :router (parse-address path router/dict))))
     page-options)))

(def page-routes
  ["/index.html"
   "/widgets.html"
   "/colors.html"
   "/layouts.html"
   "/fonts.html"
   "/components.html"])

(defn main! []
  (if (= js/process.env.env "dev")
    (spit "target/index.html" (dev-page))
    (doseq [path page-routes] (spit (str "dist" path) (prod-page path)))))
