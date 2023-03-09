package oop;

public class ComputerRunner {
    public static void main(String[] args) {
        Computer laptop = new Laptop();
        Computer mobile = new Mobile();
        Computer PC = new PersonalComputer();

        printComputers(laptop, mobile, PC);
    }

    public static void printComputers(Computer ... computers) {
        for (Computer computer : computers) {
            computer.print();
        }
    }
}
