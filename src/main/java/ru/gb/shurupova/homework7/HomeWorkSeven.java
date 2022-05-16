package ru.gb.shurupova.homework7;

import java.util.Random;

public class HomeWorkSeven {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Барсик", 5),
                new Cat("Васька", 10),
                new Cat("Пушок", 15),
                new Cat("Кузька", 9),
                new Cat("Моська", 12)
        };

        Random random = new Random();
        Plate plate = new Plate(random.nextInt(50));

        plate.info();

        for (Cat cat : cats) {
            cat.eat(plate);
            plate.info();
            plate.addFood(random.nextInt(5));
        }
    }
}
