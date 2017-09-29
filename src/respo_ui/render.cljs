
(ns respo-ui.render
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [respo-ui.comp.container :refer [comp-container]]
            [respo-ui.schema :as schema]
            [respo-ui.router :as router]
            [respo-router.util.listener :refer [parse-address]]))

(def base-info
  {:title "Respo UI",
   :icon "http://repo-cdn.b0.upaiyun.com/logo/respo.png",
   :ssr nil,
   :inline-html "<link rel=\"stylesheet\" href=\"http://repo-cdn.b0.upaiyun.com/favored-fonts/main.css\" />"})

(defn dev-page []
  (make-page
   ""
   (merge
    base-info
    {:styles [], :scripts ["/main.js" "/browser/lib.js" "/browser/main.js"]})))

(def preview? (= "preview" js/process.env.prod))

(defn prod-page [path]
  (let [manifest (.parse js/JSON (slurp "dist/assets-manifest.json"))
        cljs-manifest (.parse js/JSON (slurp "dist/manifest.json"))
        cdn (if preview? "" "http://repo-cdn.b0.upaiyun.com/respo-ui/")
        prefix-cdn (fn [x] (str cdn x))
        page-options (merge
                      base-info
                      {:styles [(prefix-cdn (aget manifest "main.css"))],
                       :scripts (map
                                 prefix-cdn
                                 [(aget manifest "main.js")
                                  (-> cljs-manifest (aget 0) (aget "js-name"))
                                  (-> cljs-manifest (aget 1) (aget "js-name"))]),
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
