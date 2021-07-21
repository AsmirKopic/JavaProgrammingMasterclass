package com.tutorials;

import java.util.HashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItems> list;

    public StockList() {
        this.list = new HashMap<>();
    }
}
