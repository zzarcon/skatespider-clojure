(defproject skatespider "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main ^:skip-aot skatespider.core
  :plugins [[lein-ring "0.8.7"]]
  :ring {:handler skatespider.handler/app
         :auto-reload? true
         :auto-refresh? false}
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :dependencies [[org.clojure/clojure "1.6.0"]
                [ring/ring "1.3.2"]
                [ring/ring-json "0.3.1"]
                [compojure "1.3.4"]
                [clojuregram "0.1.2"]])
