package ru.gb.shurupova.homework6_hw;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void run(int length);

    public abstract void swim(int length);


}
