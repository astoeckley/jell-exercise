(ns zimpler.core-test
  (:require [clojure.test :refer :all]
            [zimpler.core :refer :all]))

(deftest file-processing
  ;; With more time, I would have also individually tested the format of each line, rather than just test that it is a string.
  (testing "reading the file"
    (is (= 4 (count (read-file-lines "example.file"))))
    (is (every? string? (read-file-lines "example.file")))))

(deftest commands
  ;; With more time, I would have fleshed out this section to cover all commands.
  (testing "add"
    (is (= 2 (add 1 1)))
    (is (= 0 (add 1 -1)))
    (is (= 1 (add 1 0))))
  (testing "sub"
    (is (= 0 (sub 1 1)))
    (is (= 2 (sub 1 -1)))
    (is (= 1 (sub 1 0)))))

(deftest process-single-command
  (testing "add"
    (is (= 5 (process-single-line 2 "ADD 3")))
    (is (= -13 (process-single-line -10 "ADD -3"))))
  (testing "sub"
    (is (= 5 (process-single-line 2 "SUB -3")))
    (is (= -13 (process-single-line -10 "SUB 3"))))
  (testing "mul"
    (is (= 50 (process-single-line 2 "MUL 25")))
    (is (= 10 (process-single-line -10 "MUL -1"))))
  (testing "div"
    (is (= 5 (process-single-line 20 "DIV 4"))))
  (testing "sqr"
    (is (= 9 (process-single-line 3 "SQR")))
    (is (= 100 (process-single-line -10 "SQR")))))
