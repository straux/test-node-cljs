(ns venice.core
  (:require [clojure.string :as str]
            [functions.entry-points]
            [cljs.nodejs :as nodejs]))

(nodejs/enable-util-print!)
(. (nodejs/require "source-map-support") (install #js {:environment "node"})) 

(defn ^:export helloWorld 
  [req res]
  (. res (send "hello World !")))

(defn -main [& args]
   (when (= (first args) "fail")
     (throw (new js/Error "test"))) 
   (println args))

(set! *main-cli-fn* -main)

