package ru.gb.shurupova.homework6;

public class HomeWorkSix {
    public static void main(String[] args) {
        Animals[] animals = new Animals[7];
        animals[0] = new Cat("������", 200, 7);
        animals[1] = new Cat("������", 150, 10);
        animals[2] = new Cat("������", 110, 6);
        animals[3] = new Cat("�����", 200, 0);
        animals[4] = new Dog("�����", 250, 5);
        animals[5] = new Dog("�����", 500, 7);
        animals[6] = new Dog("���", 450, 9);

        for (Animals anml : animals) {
            anml.setNumber();
            System.out.println(anml.getNumber() + " ����� �� ����� " + anml.getName() + " ��������: " + anml.getRun() + " �. � �������: " + anml.getSwim() + " �.");
            int n = Animals.getNextNumber();
            System.out.println("��������� ����� ������� " + n);
            System.out.println();
        }

//        Cat cat = new Cat("������", 200, 5);
//        Dog dog = new Dog("�����", 100, 10);
//
//        System.out.println(cat.getName() + " ��������: " + cat.getRun() + " �. � �������: "+ cat.getSwim() + "�.");
//        System.out.println(dog.getName() + " ��������: " + dog.getRun() + "�. � �������: " + dog.getSwim() + "�.");

    }
}


