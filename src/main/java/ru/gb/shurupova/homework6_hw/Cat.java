package ru.gb.shurupova.homework6_hw;

public class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void run(int length) {
        if (length <= 200) {
            System.out.println(this + " бежит " + length + " м.");
        } else {
            System.out.println(this + " не способен пробежать " + length + " м.");
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("Кот не умеет плавать");

    }

    @Override
    public String toString() {
        return "Кот по имени " + getName();
    }
}
