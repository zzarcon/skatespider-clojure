(ns skatespider.handler
  (:use compojure.core
        ring.middleware.json
        ring.util.response)
  (:require [compojure.route :as route]))

(defroutes app-routes
  (GET "/rest" [] (response {:foo "hector"}))
  (route/resources "/"))

(def app (wrap-json-response app-routes))