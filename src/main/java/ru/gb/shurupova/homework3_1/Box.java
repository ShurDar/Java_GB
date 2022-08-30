package ru.gb.shurupova.homework3_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    @SafeVarargs
    public Box(T... fruits) {
        this.box = new ArrayList<>(Arrays.asList(fruits));
    }

    public float getWeight() {
        float weight = 0.0f;

        for (T o : box) {
            weight += o.getWeight();
        }
        return weight;
    }

    public void pour(Box<T> anotherBox) {
        anotherBox.box.addAll(box);
        box.clear();
    }

    public void addFruit(T fruit, int amount) {
        for (int i = 0; i < amount; i++) {
            box.add(fruit);
        }
    }

    public boolean compare(Box<?> anotherBox) {
        if (getWeight() == anotherBox.getWeight())
            return true;
        return false;
    }
}

