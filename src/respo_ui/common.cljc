
(ns respo-ui.common )

(defn on-input [mutate!] (fn [e dispatch!] (mutate! (:value e))))

(defn init-input [& args] "")

(defn update-input [state text] text)
