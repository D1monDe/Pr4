package org.example;

import lombok.Builder;

public class Electronics extends Product{
@Builder
    public Electronics(String name, double price, String description) {
        super(name, price, description);
    }
}

