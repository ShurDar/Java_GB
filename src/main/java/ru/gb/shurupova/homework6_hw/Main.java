package ru.gb.shurupova.homework6_hw;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("������"),
                new Cat("������"),
                new Cat("������"),
                new Dog("�����"),
                new Dog("�����"),
        };

        Random random = new Random();

        for (Animal animal : animals) {
            animal.run(random.nextInt(500));
            animal.swim(random.nextInt(50));
        }

    }
}
