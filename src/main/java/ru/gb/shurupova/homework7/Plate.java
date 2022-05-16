package ru.gb.shurupova.homework7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }

    public void addFood(int a) {
        food += a;
    }

    public void info() {
        System.out.println("В тарелке: " + food);
    }

    public int getFood() {
        return food;
    }

}
