
(ns ssr-stages.boot
  (:require
    [respo.alias :refer [html head title script style meta' div link body]]
    [respo.render.html :refer [make-html make-string]]
    [respo-ui.comp.container :refer [comp-container]]
    [respo-ui.router :as router]
    [planck.core :refer [spit slurp]]
    [respo-router.util.listener :refer [parse-address]]))

(defn use-text [x] {:attrs {:innerHTML x}})
(defn html-dsl [data html-content ssr-stages]
  (make-html
    (html {}
      (head {}
        (title (use-text (str "Respo UI")))
        (link {:attrs {:rel "icon" :type "image/png" :href "http://logo.respo.site/respo.png"}})
        (link {:attrs {:rel "stylesheet" :href "style.css"}})
        (meta' {:attrs {:charset "utf-8"}})
        (meta' {:attrs {:name "viewport" :content "width=device-width, initial-scale=1"}})
        (meta' {:attrs {:id "ssr-stages" :content (pr-str ssr-stages)}})
        (style (use-text "body {margin: 0;}"))
        (style (use-text "body * {box-sizing: border-box;}"))
        (script {:attrs {:innerHTML (slurp "html/ga.js")}})
        (script {:attrs {:id "config" :type "text/edn" :innerHTML (pr-str data)}}))
      (body {}
        (div {:attrs {:id "app" :innerHTML html-content}})
        (script {:attrs {:src "main.js"}})))))

(defn generate-html [router ssr-stages]
  (let [ tree (comp-container {:router router} ssr-stages)
         html-content (make-string tree)]
    (html-dsl {:build? true} html-content ssr-stages)))

(def pages
  ["/index.html"
   "/widgets.html"
   "/colors.html"
   "/layouts.html"
   "/fonts.html"
   "/components.html"])

(defn -main []
  (doseq [page pages]
    (spit (str "target" page) (generate-html (parse-address page router/dict) #{:shell}))))

(-main)
