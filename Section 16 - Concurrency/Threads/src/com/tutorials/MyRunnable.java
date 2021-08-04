package com.tutorials;

import static com.tutorials.ThreadColor.ANSI_RED;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(ANSI_RED + "Hello from runnable method");
    }
}
