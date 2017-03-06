
(ns respo-ui.common )

(defn on-input [mutate!] (fn [e dispatch!] (mutate! (:value e))))

(defn update-input [state text] text)

(defn init-input [& args] "")
