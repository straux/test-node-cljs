(defproject test-node-cljs "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha15"]
                 [org.clojure/clojurescript "1.9.521"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :cljsbuild {:builds [
                       {:id "functions"
                        :source-paths ["src"]
                        :compiler {:main test-node-cljs.core
                                   :output-to "target/index.js"
                                   :target :nodejs
                                   :output-dir "target"
                                   :externs ["externs.js"]
                                   :foreign-libs [{:file "entry_points.js"
                                                   :provides ["functions.entry-points"]}]
                                   :optimizations :advanced
                                   :parallel-build true
                                   :source-map "target/index.js.map"}}]})
