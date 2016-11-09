(ns clojure-webapp-workshop.prod
  (:require [clojure-webapp-workshop.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
