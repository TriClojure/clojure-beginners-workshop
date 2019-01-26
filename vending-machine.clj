(defn vending-machine
  []
  {:slots {"A1" {:item "Cool Ranch Doritos" :quantity 10 :price 1.25}
           "A2" {:item "BBQ Fritos" :quantity 7 :price 0.75}
           "A3" {:item "Cinnamon rolls" :quantity 0 :price 2.00}}
   :paid  0.00})

(defn pay
  [vm amount]
  (update vm :paid + amount))

(defn press
  [{:keys [slots paid] :as vm} slot-id]
  (let [{:keys [item quantity price] :as slot} (get slots slot-id)]
    (cond
      (not slot)
      (do (println "No such slot!") vm)

      (zero? quantity)
      (do (println "Sorry, no" item "left.") vm)

      (zero? paid)
      (do (println (format "%s cost $%.2f." item price)) vm)

      (> price paid)
      (do (println (format "%s cost $%.2f, but you've only paid $%.2f."
                           item
                           price
                           paid))
          vm)

      :else
      (do
        (println (format "Dispensing %s." item))
        (println (format "Please take your change: $%.2f" (- paid price)))
        (-> vm
            (update-in [:slots slot-id :quantity] dec)
            (assoc :paid 0.00))))))
