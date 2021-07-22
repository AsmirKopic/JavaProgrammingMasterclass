package com.tutorials;

public class Main {

    private static StockList stockList = new StockList();
    public static void main(String[] args) {

        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);
        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);
        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);
        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);
        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);
        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);
        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);
        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);
        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);
        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        for (String s: stockList.items().keySet()){
            System.out.println(s);
        }

        Basket myBasket = new Basket("Asmir");
        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        System.out.println(myBasket);

        sellItem(myBasket, "car", 1);
        sellItem(myBasket, "spanner", 4);
        System.out.println(myBasket);

        sellItem(myBasket, "juice", 4);
        sellItem(myBasket, "cup", 45);
        sellItem(myBasket, "bread", 2);
        System.out.println(myBasket);
        System.out.println(stockList);



    }
    public static int sellItem(Basket basket, String item, int quantity){
        // retrieve item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null){
            System.out.println("We don't sell " + item);
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0){
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        return 0;
    }


}
