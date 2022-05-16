package ru.gb.shurupova.homework7;

import java.util.Random;

public class HomeWorkSeven {

    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("������", 5),
                new Cat("������", 10),
                new Cat("�����", 15),
                new Cat("������", 9),
                new Cat("������", 12)
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
