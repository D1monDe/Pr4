package org.example;

public class OrderProcessor<T extends Product> {
    private T product;

    public OrderProcessor(T product) {
        this.product = product;
    }
    public T getProduct() {
        return product;
    }

    public void process() {
        try {
            if (product == null) {
                throw new IllegalArgumentException("org.example.Product cannot be null");
            }
            System.out.println("Processing order for: " + product.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Error processing order: " + e.getMessage());
        }
    }

    public void startProcessing() {
        Runnable task = () -> {
            try {
                System.out.println("Processing product in thread: " + Thread.currentThread().getName());
                Thread.sleep(1000);
                System.out.println("Finished processing: " + product.getName());
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted: " + e.getMessage());
            }
        };
        new Thread(task).start();
    }
}
