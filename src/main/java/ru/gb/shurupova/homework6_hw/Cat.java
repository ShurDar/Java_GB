package ru.gb.shurupova.homework6_hw;

public class Cat extends Animal {
    public Cat(String name) {
        super(name, 200, 0);
    }

    @Override
    public void swim(int length) {
        System.out.println("��� �� ����� �������");
    }

    @Override
    public String toString() {
        return "��� �� ����� " + getName();
    }
}
