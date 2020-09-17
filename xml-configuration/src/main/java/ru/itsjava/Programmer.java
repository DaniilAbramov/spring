package ru.itsjava;

public class Programmer {
    private Computer computer;

    public Programmer(Computer computer) {
        this.computer = computer;
    }

    public Programmer(){
        System.out.println("Programmer empty constructor");
    }

    public void setComputer(Computer copmuter) {
        this.computer = copmuter;
    }

    public String HelloWorld(){
        return computer.getBrand() + "Hello world";
    }
}
