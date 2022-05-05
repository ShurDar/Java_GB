package ru.gb.shurupova.homework6;

public class HomeWorkSix {
    public static void main(String[] args) {
        Cat cat = new Cat("Мурзик",200,5 );
        Dog dog = new Dog("Шарик", 100, 10);

        System.out.println(cat.getName() + " пробежал: " + cat.getRun() + "м. и проплыл: " + cat.getSwim() + "м.");
        System.out.println(dog.getName() + " пробежал: " + dog.getRun() + "м. и проплыл: " + dog.getSwim() + "м.");

        }
    }


