(ns skatespider.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [compojure.handler]
            [ring.middleware.json]
            [ring.util.response :refer :all]
            [skatespider.ig-client :as ig]))

(defroutes app-routes
  (GET "/" [foo bar] (str foo " " bar))
  (GET "/auth_callback" [code] (ig/token-and-user-from-code code))
  (GET "/auth" [] (redirect ig/auth-url))
  (route/resources "/")
  (route/not-found "<h1>Not found</h1>"))

(def app
  (-> app-routes
      compojure.handler/api
      ring.middleware.json/wrap-json-response
      ring.middleware.json/wrap-json-params))
