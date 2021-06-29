package com.tutorials;

public class Main {

    public static void main(String[] args) {

       int pw = 674321;
       Password password = new Password(pw);
       password.storePassword();

       password.letMeIn(1234);
       password.letMeIn(3634636);
       password.letMeIn(124134);
       password.letMeIn(674321);









    }
}
