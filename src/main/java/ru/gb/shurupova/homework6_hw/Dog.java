package ru.gb.shurupova.homework6_hw;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void run(int length) {
        if (length <= 500) {
            System.out.println(this + " бежит " + length + " м.");
        } else {
            System.out.println(this + " не способна пробежать " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        if (length <= 10) {
            System.out.println(this + " плывет " + length + " м.");
        } else {
            System.out.println(this + " не способна проплыть " + length + " м.");
        }
    }

    @Override
    public String toString() {
        return "Собака по имени " + getName();
    }
}
