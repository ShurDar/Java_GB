package ru.gb.shurupova.homework6_hw;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Мурзик"),
                new Cat("Барсик"),
                new Cat("Васька"),
                new Dog("Шарик"),
                new Dog("Бобик"),
        };

        Random random = new Random();
        System.out.println("Всего животных: " + Animal.getCount() + " шт.");
        System.out.println("Количество кошек: " + Cat.getCount() + " шт.");
        System.out.println("Количество собак: " + Dog.getCount() + " шт.");
        for (Animal animal : animals) {
            animal.run(random.nextInt(500));
            animal.swim(random.nextInt(50));
        }

    }
}
