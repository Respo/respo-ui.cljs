
(ns ssr-stages.boot
  (:require
    [respo.alias :refer [html head title script style meta' div link body]]
    [respo.render.html :refer [make-html make-string]]
    [respo-ui.comp.container :refer [comp-container]]
    [respo-ui.router :as router]
    [respo-router.util.listener :refer [parse-address]]))

(def pages
  ["/index.html"
   "/widgets.html"
   "/colors.html"
   "/layouts.html"
   "/fonts.html"
   "/components.html"])

(def fs (js/require "fs"))

(defn slurp [file-name]
  (fs.readFileSync file-name "utf-8"))

(defn html-dsl [data html-content ssr-stages]
  (make-html
    (html {}
      (head {}
        (title {:attrs {:innerHTML "Respo UI"}})
        (link {:attrs {:rel "icon" :type "image/png" :href "http://logo.respo.site/respo.png"}})
        (link {:attrs {:rel "stylesheet" :type "text/css" :href "style.css"}})
        (link (:attrs {:rel "manifest" :href "manifest.json"}))
        (meta' {:attrs {:charset "utf-8"}})
        (meta' {:attrs {:name "viewport" :content "width=device-width, initial-scale=1"}})
        (meta' {:attrs {:id "ssr-stages" :content (pr-str ssr-stages)}})
        (style {:attrs {:innerHTML "body {margin: 0;}"}})
        (style {:attrs {:innerHTML "body * {box-sizing: border-box;}"}})
        (script {:attrs {:innerHTML (slurp "html/ga.js")}})
        (script {:attrs {:id "config" :type "text/edn" :innerHTML (pr-str data)}}))
      (body {}
        (div {:attrs {:id "app" :innerHTML html-content}})
        (script {:attrs {:src "main.js"}})))))

(defn generate-html [store]
  (let [ tree (comp-container store #{:shell})
         html-content (make-string tree)]
    (html-dsl {:build? true} html-content #{:shell})))

(defn generate-empty-html []
  (html-dsl {:build? true} "" {}))

(defn spit [file-name content]
  (let [fs (js/require "fs")]
    (.writeFileSync fs file-name content)))

(defn -main []
  (if (= js/process.env.env "dev")
    (spit "target/dev.html" (generate-empty-html))
    (doseq [page pages]
      (spit (str "target" page) (generate-html {:router (parse-address page router/dict)})))))

(-main)
