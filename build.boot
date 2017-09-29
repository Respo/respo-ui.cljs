
(def +version+ "0.2.0")

(set-env!
  :resource-paths #{"src"}
  :dependencies '[])

(deftask build []
  (comp
    (pom :project     'respo/ui
         :version     +version+
         :description "Workflow"
         :url         "https://github.com/Respo/respo-ui"
         :scm         {:url "https://github.com/Respo/respo-ui"}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (install)
    (target)))

(deftask deploy []
  (set-env!
    :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"}]))
  (comp
    (build)
    (push :repo "clojars" :gpg-sign (not (.endsWith +version+ "-SNAPSHOT")))))
