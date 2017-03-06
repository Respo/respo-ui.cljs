
(set-env!
  :asset-paths #{"assets/"}
  :source-paths #{"src"}
  :dependencies '[[org.clojure/clojure       "1.8.0"       :scope "test"]
                  [org.clojure/clojurescript "1.9.494"     :scope "test"]
                  [adzerk/boot-cljs          "1.7.228-1"   :scope "test"]
                  [adzerk/boot-reload        "0.4.13"      :scope "test"]
                  [cirru/boot-stack-server   "0.1.30"      :scope "test"]
                  [andare                    "0.4.0"       :scope "test"]
                  [cumulo/shallow-diff       "0.1.2"       :scope "test"]
                  [fipp                      "0.6.9"       :scope "test"]
                  [respo                     "0.3.38"      :scope "test"]
                  [respo/router              "0.2.2"       :scope "test"]
                  [mvc-works/hsl             "0.1.2"]])

(require '[adzerk.boot-cljs   :refer [cljs]]
         '[adzerk.boot-reload :refer [reload]])

(def +version+ "0.1.7")

(task-options!
  pom {:project     'respo/ui
       :version     +version+
       :description "Command styles for Respo apps"
       :url         "https://github.com/Respo/respo-ui"
       :scm         {:url "https://github.com/Respo/respo-ui"}
       :license     {"MIT" "http://opensource.org/licenses/mit-license.php"}})

(deftask dev []
  (comp
    (watch)
    (reload :on-jsload 'respo-ui.main/on-jsload!
            :cljs-asset-path ".")
    (cljs :compiler-options {:language-in :ecmascript5})
    (target :no-clean true)))

(deftask build-advanced []
  (comp
    (cljs :optimizations :advanced
          :compiler-options {:language-in :ecmascript5})
    (target :no-clean true)))

(deftask build []
  (comp
    (pom)
    (jar)
    (install)
    (target)))

(deftask deploy []
  (set-env!
    :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"}]))
  (comp
    (build)
    (push :repo "clojars" :gpg-sign (not (.endsWith +version+ "-SNAPSHOT")))))
