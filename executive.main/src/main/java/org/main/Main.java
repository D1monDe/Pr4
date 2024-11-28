package org.main;

import com.github.javafaker.Faker;
import org.example.Clothing;
import org.example.Electronics;
import org.example.OrderProcessor;
import org.storage.ProcessedStorage;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
       /* org.example.OrderProcessor<org.example.Electronics> electronicsOrder = new org.example.OrderProcessor<>(new org.example.Electronics("Mobile phone"));
        org.example.OrderProcessor<org.example.Clothing> clothingOrder = new org.example.OrderProcessor<>(new org.example.Clothing("Trousers"));
        electronicsOrder.process();
        electronicsOrder.startProcessing();
        clothingOrder.process();
        clothingOrder.startProcessing();*/
        var faker = new Faker();

        ProcessedStorage processedStorage = new ProcessedStorage();

        var clothingList = IntStream.range(0, 5)
                .mapToObj(i -> Clothing.builder()
                        .name(faker.commerce().productName())
                        .price(Double.parseDouble(faker.commerce().price().replace(",", ".")))
                        .description(faker.lebowski().quote())
                        .build())
                .toList();

        clothingList.forEach(clothing -> {
            OrderProcessor<Clothing> clothingOrder = new OrderProcessor<>(clothing);
            clothingOrder.process();
            clothingOrder.startProcessing();
            processedStorage.addProcessedOrder(clothingOrder.getProduct());
        });
        /*
        var electronicsList = IntStream.range(0, 5)
                .mapToObj(i -> new Electronics(
                        faker.commerce().material() + " " + faker.company().name() + " Device",
                        Double.parseDouble(faker.commerce().price(100, 1000).replace(",", ".")),
                        faker.lorem().sentence()))
                .toList();
        */
        var electronicsList = IntStream.range(0, 5)
                .mapToObj(i -> Electronics.builder()
                        .name(faker.commerce().material() + " " + faker.company().name() + " Device")
                        .price(Double.parseDouble(faker.commerce().price(100, 1000).replace(",", ".")))
                        .description(faker.lorem().sentence())
                        .build())
                .toList();

        electronicsList.forEach(electronics -> {
            OrderProcessor<Electronics> electronicsOrder = new OrderProcessor<>(electronics);
            electronicsOrder.process();
            electronicsOrder.startProcessing();
            processedStorage.addProcessedOrder(electronicsOrder.getProduct());
        });

        System.out.println("\nProcessed Orders:");
        processedStorage.getProcessedOrders().forEach(product -> {
            System.out.println("- " + product.getName() + " ($" + product.getPrice() + ")");
        });
    }
}
