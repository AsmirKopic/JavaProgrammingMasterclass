package com.tutorials;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private final String name;
    private Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new HashMap<>();
    }

    public int addToBasket(StockItem item, int quantity){
        // continue here ...

    }
}
