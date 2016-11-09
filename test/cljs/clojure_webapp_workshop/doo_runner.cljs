(ns clojure-webapp-workshop.doo-runner
  (:require [doo.runner :refer-macros [doo-tests]]
            [clojure-webapp-workshop.core-test]))

(doo-tests 'clojure-webapp-workshop.core-test)
