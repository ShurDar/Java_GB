package ru.gb.shurupova.homework6_hw;

public class Dog extends Animal {
    public Dog(String name) {
        super(name, 500, 10);
    }

    @Override
    public String toString() {
        return "Собака по имени " + getName();
    }
}
