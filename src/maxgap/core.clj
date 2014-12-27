(ns maxgap.core
  (:gen-class))

(defn read-seq []
  (loop [s []]
    (let [elem (read-string (read-line))]
      (if (>= elem 0)
        (recur (conj s elem))
        s))))


(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (let [s (read-seq)
        maxim (apply max s)
        minim (apply min s)
        st (map round (steps maxim (count s)))
        ]
))

;; (defn steps [minimum step]
;;  (loop [n 0 r [] tmp minimum]
;;    (if (< n 4) (recur (+ 1 n) (conj r tmp) (floor (+ tmp step)))
;;        r)))

(defn percentages
  ([max] (percentages 1 max))
  ([min max] (map #(/ % (inc (- max min)))
                  (range min (inc max)))))

(defn steps [max buckets]
  (map #(* max %) (percentages buckets)))

(defn round [x]
  (int x))
