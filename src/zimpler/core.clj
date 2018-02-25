(ns zimpler.core)

(defn add
  "Process ADD command"
  [starting-value parameter]
  (+ starting-value parameter))

(defn sub
  "Process SUB command"
  [starting-value parameter]
  (- starting-value parameter))

(defn mul
  "Process MUL command"
  [starting-value parameter]
  (* starting-value parameter))

(defn div
  "Process DIV command"
  [starting-value parameter]
  (/ starting-value parameter))

(defn sqr
  "Process SQR command"
  [starting-value]
  (* starting-value starting-value))

(defn parse-int
  "Parses a string and returns number it contains, as a number"
  [s]
  (Integer/parseInt (re-find #"\A-?\d+" s)))

(defn process-single-line
  "Receives a single line of instructions and a starting value; returns the new value after processing."
  [starting-value line]
  {:pre  [(string? line) (number? starting-value)]
   :post [(number? starting-value)]}
  (let [[command string-parameter] (clojure.string/split line #" ")
        parameter                  (when string-parameter (parse-int string-parameter))]
    (case command
      "ADD" (add starting-value parameter)
      "SUB" (sub starting-value parameter)
      "MUL" (mul starting-value parameter)
      "DIV" (div starting-value parameter)
      "SQR" (sqr starting-value))))

(defn process-file-lines
  "Receives a seq of all the lines in the exercise file, and processes them"
  [lines]
  (println lines)
  )

(defn read-file-lines
  "Reads the file containing the exercise commands, and returns the contents as a seq of its lines"
  [file]
  (let [contents          (slurp file)
        contents-as-lines (clojure.string/split-lines contents)]
    contents-as-lines))

(defn -main
  "Entry point for running program from command line. Pass a file name which contains the exercise commands."
  [file]
  (println "Received file name:" file)
  (process-file-lines (read-file-lines file)))

