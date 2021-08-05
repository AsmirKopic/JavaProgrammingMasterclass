package com.tutorials;

import static com.tutorials.ThreadColor.ANSI_BLUE;
import static com.tutorials.ThreadColor.ANSI_GREEN;

public class Main {

    public static void main(String[] args) {
        System.out.println(ANSI_GREEN +"This is main thread");

        Thread anotherThread = new AnotherThread();
        anotherThread.setName(" = Another Thread = ");
        anotherThread.start();

        new Thread(){
            public void run(){
                System.out.println(ANSI_BLUE +"Hello from anonymous class");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        anotherThread.interrupt();

        System.out.println("Hello from main thread again");

    }
}
