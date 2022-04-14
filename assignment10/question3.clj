(ns library)
(defn tax [amountToBeTaxed, taxRate]
  (float (* (/ taxRate 100) amountToBeTaxed)))

(ns application)
(println "Tax on 117 at 17 is %n" (library/tax 117 17))
