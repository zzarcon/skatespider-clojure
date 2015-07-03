(ns skatespider.ig-client
  (:require [clojuregram.core :as clojuregram]
            [skatespider.ig-client :as ig]))

(def instagram-credentials
  {:client_id "2e0d3d5bad9343dd9ea1dd770ae24bee"
   :client_secret "5e1171845f4f4d87be089c8affa585d9"
   :client_ips (clojure.string/trim-newline
                 ((clj-http.client/get "http://checkip.amazonaws.com") :body))
   :scope "likes comments relationships"
   :redirect-uri "http://localhost:3000/auth_callback"})

(def auth-url (clojuregram/access-token-url instagram-credentials))

(defn token-and-user-from-code [code]
  (clojuregram/get-access-token instagram-credentials code)
  ((ig/get-user {:user_id "923432"}) :data))