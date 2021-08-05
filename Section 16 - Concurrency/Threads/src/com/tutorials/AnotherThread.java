package com.tutorials;

import static com.tutorials.ThreadColor.ANSI_PURPLE;

public class AnotherThread extends Thread{

    @Override
    public void run() {
        System.out.println(ANSI_PURPLE + "Hello from" + currentThread().getName());

        try{
            Thread.sleep(3000);
        } catch(InterruptedException e){
            System.out.println(ANSI_PURPLE + "Another thread woke me up");
            return;
    }
        System.out.println(ANSI_PURPLE + "Three secound passed and Im awake");
    }


}
