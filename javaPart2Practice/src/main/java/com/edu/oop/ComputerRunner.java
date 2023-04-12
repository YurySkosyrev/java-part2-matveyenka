package com.edu.oop;

public class ComputerRunner {
    public static void main(String[] args) {
        Computer laptop = new Laptop();
        Computer mobile = new Mobile();
        Computer personalComputer = new PersonalComputer();

        printComputers(laptop, mobile, personalComputer);
    }

    public static void printComputers(Computer ... computers) {
        for (Computer computer : computers) {
            computer.print();
        }
    }
}
