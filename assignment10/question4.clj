(defn pattern[]
  (loop [n0 3 n1 2 cnt 0 result (transient[])] 
    (if (< cnt 12)
      (recur n1 (+ n0 n1) (inc cnt) (conj! result n1))
      (persistent! result))))

(pattern)
(use 'clojure.test)
;;4th element 
(def x1 4)
(is (= (drop (- x1 2) (take (- x1 1) (pattern)))) 7 )
;;7th element 
(def x1 7)
(is (= (drop (- x1 2) (take (- x1 1) (pattern)))) 7 )

