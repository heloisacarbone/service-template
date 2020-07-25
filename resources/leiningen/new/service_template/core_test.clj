(ns {{name}}.core-test
  (:require [clojure.test :refer :all]
            [{{name}}.core :as core]))

(deftest add-test
  (testing "1+2=3"
    (is (= 3
           (core/add 1 2)))))