(ns todo-clj.core-test
  (:require [clojure.test :refer :all]
            [todo-clj.core :refer :all]))

(deftest sanity-check
  (testing "Alles gut"
    (is (= 1 1))))
