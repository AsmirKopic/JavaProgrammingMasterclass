package com.tutorials;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>();
    }

    public int addStock(StockItem item){
        if (item != null){
            // check if already have quantities in stock
            StockItem inStock = list.getOrDefault(item.getName(), item);
            // if there are already stocks on this item, adjust the quantity
            if (inStock != item){
                item.adjustStock(inStock.avilableQuantity());
            }
            list.put(item.getName(), item);
            return item.avilableQuantity();
        }
        return 0;
    }

    public int sellStock(String item, int quantity){
        StockItem inStock = list.get(item);

        if ((inStock != null) && (quantity > 0)){
            return inStock.finaliseStock(quantity);
        }
        return 0;

//        StockItem inStock = list.getOrDefault(item, null);
//        if ((inStock != null) && (inStock.avilableQuantity() > quantity) && (quantity > 0)) {
//            inStock.adjustStock(-quantity);
//            return quantity;
//        }
//        return 0;
    }

    public int reserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)){
            return inStock.reserveStock(quantity);
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity){
        StockItem inStock = list.get(item);
        if ((inStock != null) && (quantity > 0)){
            return inStock.unreserveStock(quantity);
        }
        return 0;
    }

    public StockItem get(String key){
        return list.get(key);
    }
    public Map<String, StockItem> items(){
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nStock list\n";
        double totalCost = 0.0;
        for (Map.Entry<String,StockItem> item : list.entrySet()){
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.avilableQuantity();

            s = s + stockItem + " There are " + stockItem.avilableQuantity() + " in stock. Value of items: ";
            s = s + String.format("%.2f",itemValue) + "\n";
            totalCost += itemValue;
            item.getValue();
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}
