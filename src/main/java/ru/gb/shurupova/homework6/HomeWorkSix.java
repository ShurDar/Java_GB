package ru.gb.shurupova.homework6;

public class HomeWorkSix {
    public static void main(String[] args) {
        Cat cat = new Cat("������",200,5 );
        Dog dog = new Dog("�����", 100, 10);

        System.out.println(cat.getName() + " ��������: " + cat.getRun() + "�. � �������: " + cat.getSwim() + "�.");
        System.out.println(dog.getName() + " ��������: " + dog.getRun() + "�. � �������: " + dog.getSwim() + "�.");

        }
    }


