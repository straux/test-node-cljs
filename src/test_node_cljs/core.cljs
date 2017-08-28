(ns test-node-cljs.core
  (:require [clojure.string :as str]
            [functions.entry-points]
            [cljs.nodejs :as nodejs]))

;; see https://cloud.google.com/functions/docs/writing/

(nodejs/enable-util-print!)
(. (nodejs/require "source-map-support") (install #js {:environment "node"})) 

(defn ^:export helloWorld 
  [req res]
  (let [msg (.. req -body -message)]
     (when (= msg "fail")
       (throw (new js/Error "failed")))
     (. res (send "hello World !"))))

(defn -main [& args]
   (when (= (first args) "fail")
     (throw (new js/Error "test"))) 
   (println args))

(set! *main-cli-fn* -main)

