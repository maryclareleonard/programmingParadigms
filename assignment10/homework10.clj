;;number 1 - display 10 to 20
(take 11 (drop 10 (range 0 100)))

;;number 2 - display squares
(map #(* % %) (range 1 11))
;;number 2 - sum using reduce
(reduce + (map #(* % %) (range 1 11)))