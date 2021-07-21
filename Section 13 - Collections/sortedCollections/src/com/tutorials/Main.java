package com.tutorials;

public class Main {

    public static void main(String[] args) {

        StockList list = new StockList();

        StockItem kruska = new StockItem("Kruska", 40, 10);

        list.addStock(kruska);
        System.out.println(" Item kruska create with name " + kruska.toString() + " and quantitiy " + kruska.getQuantityStock());


        list.sellStock("Kruska", 6);

        System.out.println(" After sale " + kruska.toString() + " new quant.. " + kruska.getQuantityStock());







    }
}
