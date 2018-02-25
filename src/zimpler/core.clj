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

