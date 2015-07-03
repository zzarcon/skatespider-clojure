(ns skatespider.core
  (:gen-class :main true)
  (:use ring.adapter.jetty)
  (:require [skatespider.crawler :as crawler]))

(defn -main [& args] (run-jetty app {:port 9001}))