
(defn read-password [guide]
  (String/valueOf (.readPassword (System/console) guide nil)))

(set-env!
  :resource-paths #{"src"}
  :dependencies '[]
  :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"
                                     :username "jiyinyiyong"
                                     :password (read-password "Clojars password: ")}]))

(def +version+ "0.2.3")

(deftask deploy []
  (comp
    (pom :project     'respo/ui
         :version     +version+
         :description "Tiny collection of styles used in Respo"
         :url         "https://github.com/Respo/respo-ui"
         :scm         {:url "https://github.com/Respo/respo-ui"}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (push :repo "clojars" :gpg-sign false)))
