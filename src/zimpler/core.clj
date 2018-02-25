(ns zimpler.core)

(defn process-file-lines
  "Receives a seq of all the lines in the exercise file, and processes them"
  [lines]
  ;;TODO
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

