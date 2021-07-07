package core.basesyntax.strategy;

import core.basesyntax.dto.Transaction;
import core.basesyntax.model.Fruit;
import core.basesyntax.storage.Storage;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int apply(Transaction transaction) {
        Fruit fruit = new Fruit(transaction.getName());
        int currentQuantity = Storage.fruitStorage.get(fruit) - transaction.getQuantitiy();
        if (currentQuantity < 0) {
            throw new RuntimeException("Not enough fruit`s Bro");
        }
        Storage.fruitStorage.put(fruit, currentQuantity);
        return currentQuantity;
    }
}