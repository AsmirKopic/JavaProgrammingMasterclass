package com.tutorials;

import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new HashMap<>();
    }

    public int addStock(StockItem item){
        if (item != null){
            // check if already have quantities in stock
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if there are already stocks on this item, adjust the quantity
            if (inStock != item){
                item.adjustStock(inStock.getQuantityStock());
            }
            list.put(item.getName(), item);
            return item.getQuantityStock();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){

        // continue here !!
    }
}
