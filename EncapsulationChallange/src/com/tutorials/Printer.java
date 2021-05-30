package com.tutorials;

public class Printer {
    private int tonerLevel;
    private int printedPages;
    private boolean duplex;

    public Printer(int tonerLevel, int printedPages, boolean duplex) {
        if (tonerLevel >= 0 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        }
        this.printedPages = printedPages;
        this.duplex = duplex;
    }

    public void fillToner(int filledAmount) {
        int newTonerLevel = this.tonerLevel + filledAmount;
        if (newTonerLevel <= 100 ){
            this.tonerLevel = newTonerLevel;
            System.out.println(" New toner level " + newTonerLevel);
        } else {
            System.out.println(" Cant overfill !!!");
        }

    }

    public void print(){
        System.out.println("Printing pages");
        this.printedPages += 1;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPrintedPages() {
        return printedPages;
    }
}
