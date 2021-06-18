package com.tutorials;

public class Main {

    public static void main(String[] args) {
	Dog dog = new Dog("Yorkie");
	dog.eat();
	dog.breathe();

	Parrot parrot = new Parrot("RedNeck");
	parrot.breathe();
	parrot.eat();
	parrot.fly();
	Penguin penguin = new Penguin("Penguino");
	penguin.fly();



    }
}
