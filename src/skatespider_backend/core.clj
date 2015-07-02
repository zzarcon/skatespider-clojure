(ns skatespider-backend.core
  (:gen-class :main true)
  (:use compojure.core
        ring.middleware.json
        ring.util.response
        ring.adapter.jetty)
  (:require [compojure.route :as route]))

(defroutes my_routes
  (GET "/rest" [] (response {:foo "hector"}))
  (route/resources "/"))

(def app (wrap-json-response my_routes))

(defn -main [& args] (run-jetty app {:port 9001}))