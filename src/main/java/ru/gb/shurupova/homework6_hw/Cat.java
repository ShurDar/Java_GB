package ru.gb.shurupova.homework6_hw;

public class Cat extends Animal {
    private static final int RUN_LIMIT = 200;
    private static final int SWIM_LIMIT = 0;
    private static int count;

    public Cat(String name) {
        super(name, RUN_LIMIT, SWIM_LIMIT);
        count++;
    }

    @Override
    public void swim(int length) {
        System.out.println("��� �� ����� �������");
    }

    @Override
    public String toString() {
        return "��� �� ����� " + getName();
    }

    public static int getCount() {
        return count;
    }
}
