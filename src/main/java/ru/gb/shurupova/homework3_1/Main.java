package ru.gb.shurupova.homework3_1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Task 1
        Integer array1[] = {1, 2, 3, 4, 5};
        String array2[] = {"a", "b", "c", "d", "e"};
        change(array1, 2, 4);
        change(array2, 0, 3);

        // Task 2
        Integer[] arrayInt = {1, 2, 3, 4, 5};
        String[] arrayString = {"a", "b", "c", "d", "e"};
        asList(arrayInt);
        asList(arrayString);

        //Task 3
        boxTest();
    }

    // Task 1
    // Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа)
    public static void change(Object[] array, int fPlace, int sPlace) {
        System.out.println("Task 1");
        System.out.println("The initial array: " + Arrays.toString(array));
        Object obj = array[fPlace];
        array[fPlace] = array[sPlace];
        array[sPlace] = obj;
        System.out.println("The array after change: " + Arrays.toString(array));
        System.out.println();

    }

    // Task 2
    // Написать метод, который преобразует массив в ArrayList
    public static <T> void asList(T[] array) {
        ArrayList<T> aList = new ArrayList<>(Arrays.asList(array));
        System.out.println("Task 2");
        System.out.println("The result: " + aList);
        System.out.println();

    }

    // Task 3
    public static void boxTest() {
        Box<Orange> o1 = new Box<>();
        Box<Orange> o2 = new Box<>();

        Box<Apple> a1 = new Box<>();
        Box<Apple> a2 = new Box<>();

        System.out.println("Task 3");
        System.out.println("Add fruits");

        o1.addFruit(new Orange(), 10);
        o2.addFruit(new Orange(), 15);

        a1.addFruit(new Apple(), 5);
        a2.addFruit(new Apple(), 20);

        System.out.println("OrBox 1: " + o1.getWeight());
        System.out.println("OrBox 2: " + o2.getWeight());
        System.out.println("ApBox 3: " + a1.getWeight());
        System.out.println("ApBox 4: " + a2.getWeight());
        System.out.println();

        System.out.println("Compare fruits");
        System.out.println("From Box 1 to Box 3: " + o1.compare(a1));
        System.out.println("From Box 2 to Box 4: " + o2.compare(a2));
        System.out.println();

        System.out.println("Pour fruits");
        o1.pour(o2);
        a1.pour(a2);
        System.out.println();

        System.out.println("Get weight fruits");
        System.out.println("Box 1: " + o1.getWeight());
        System.out.println("Box 2: " + o2.getWeight());
        System.out.println("Box 3: " + a1.getWeight());
        System.out.println("Box 4: " + a2.getWeight());

    }
}

