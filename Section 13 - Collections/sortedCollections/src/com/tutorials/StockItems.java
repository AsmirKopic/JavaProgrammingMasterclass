package com.tutorials;

public class StockItems implements Comparable<StockItems> {
    private final String name;
    private double price;
    private int quantityStock = 0;  //can be initialized later

    public StockItems(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0){
            this.price = price;
        }
    }
}
