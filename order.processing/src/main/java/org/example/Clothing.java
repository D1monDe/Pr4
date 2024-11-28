package org.example;

import lombok.Builder;

//@Builder
public class Clothing extends Product {
    @Builder
    public Clothing(String name, double price, String description) {
        super(name, price, description);
    }
}
