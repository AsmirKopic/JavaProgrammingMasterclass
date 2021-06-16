package com.tutorials;

public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    boolean isRinging();
    void answer();
    boolean callPhone(int phoneNumber);
}
