package org.storage;

import org.example.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessedStorage {
    private final List<Product> processedOrders = Collections.synchronizedList(new ArrayList<>());

    public void addProcessedOrder(Product product) {
        processedOrders.add(product);
        System.out.println("Order added to processed storage: " + product.getName());
    }

    public List<Product> getProcessedOrders() {
        return Collections.unmodifiableList(processedOrders);
    }
}