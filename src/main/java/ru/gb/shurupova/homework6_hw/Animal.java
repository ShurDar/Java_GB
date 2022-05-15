package ru.gb.shurupova.homework6_hw;

public abstract class Animal {
    private String name;
    private int runLimit;
    private int swimLimit;
    private static int count;

    public Animal(String name, int runLimit, int swimLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        count++;
    }

    public String getName() {
        return name;
    }

    public static int getCount(){
        return count;
    }

    public void run(int length) {
        if (length <= runLimit) {
            System.out.println(this + " ����� " + length + " �.");
        } else {
            System.out.println(this + " �� �������� ��������� " + length + " �.");
        }
    }

    public void swim(int length) {
        if (length <= swimLimit) {
            System.out.println(this + " ������ " + length + " �.");
        } else {
            System.out.println(this + " �� �������� �������� " + length + " �.");
        }
    }


}
