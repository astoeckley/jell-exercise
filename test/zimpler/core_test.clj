(ns zimpler.core-test
  (:require [clojure.test :refer :all]
            [zimpler.core :refer :all]))

(deftest file-processing
  (testing "reading the file"
    (is (= 4 (count (read-file-lines "example.file"))))
    (is (every? string? (read-file-lines "example.file")))))
