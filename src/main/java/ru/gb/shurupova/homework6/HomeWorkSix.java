package ru.gb.shurupova.homework6;

public class HomeWorkSix {
    public static void main(String[] args) {
        Animals[] animals = new Animals[7];
        animals[0] = new Cat("Мурзик", 200, 7);
        animals[1] = new Cat("Барсик", 150, 10);
        animals[2] = new Cat("Васька", 110, 6);
        animals[3] = new Cat("Пушок", 200, 0);
        animals[4] = new Dog("Шарик", 250, 5);
        animals[5] = new Dog("Бобик", 500, 7);
        animals[6] = new Dog("Тор", 450, 9);

        for (Animals anml : animals) {
            anml.setNumber();
            System.out.println(anml.getNumber() + " зверь по имени " + anml.getName() + " пробежал: " + anml.getRun() + " м. и проплыл: " + anml.getSwim() + " м.");
            int n = Animals.getNextNumber();
            System.out.println("Следующий зверь номером " + n);
            System.out.println();
        }

//        Cat cat = new Cat("Мурзик", 200, 5);
//        Dog dog = new Dog("Шарик", 100, 10);
//
//        System.out.println(cat.getName() + " пробежал: " + cat.getRun() + " м. и проплыл: "+ cat.getSwim() + "м.");
//        System.out.println(dog.getName() + " пробежал: " + dog.getRun() + "м. и проплыл: " + dog.getSwim() + "м.");

    }
}


