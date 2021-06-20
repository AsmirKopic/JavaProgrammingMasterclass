package com.tutorials;

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null){
            //The list was empty, so this item becomes the head of list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = newItem;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                // newItem is greater, move to right if possible
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert to end of the list
                    currentItem.setNext(newItem);
                    newItem.setPrevious(currentItem);
                    return true;
                }
            } else if (currentItem > 0) {
                // newItem is less, insert before  ..... code to be continue
                // code here !
                // ********
            }
        }

    }

    @Override
    public boolean removeItem(ListItem item) {
        return false;
    }

    @Override
    public void tranverse(ListItem root) {

    }
}
