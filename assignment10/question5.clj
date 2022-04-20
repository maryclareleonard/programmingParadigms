(defn lucas [n] 
  (loop [a 2 b 1 result (transient [2])]
    (if (> b n)
      (persistent! result)
      (recur b (+ a b) (conj! result b)))))

(use 'clojure.test)
(is (= (lucas 50) [2 1 3 4 7 11 18 29 47] ))
(is (= (lucas 100) [2 1 3 4 7 11 18 29 47 76] ))
(is (= (lucas 200) [2 1 3 4 7 11 18 29 47 76 123 199] ))
