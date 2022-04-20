(defn filterForMult [m]
  (println (keys (take 1 (select-keys m (for [[k v] m :when (> v 1)] k))))))

(defn doubleLet [word] 
  (def x (frequencies word))
  (filterForMult x))

(doubleLet "primrose")
(doubleLet "primose")
