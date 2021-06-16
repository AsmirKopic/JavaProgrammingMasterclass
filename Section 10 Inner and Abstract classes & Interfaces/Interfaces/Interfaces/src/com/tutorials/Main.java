package com.tutorials;

public class Main {

    public static void main(String[] args) {
	ITelephone timsPhone;
	timsPhone = new DeskPhone(12345);
	timsPhone.powerOn();
	timsPhone.callPhone(12345);
	timsPhone.answer();

	timsPhone = new MobilePhone(4566);
	timsPhone.powerOn();
	timsPhone.callPhone(4566);
	timsPhone.answer();



    }
}
