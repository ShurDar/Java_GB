package ru.gb.shurupova.homework2;

public class HomeWorkTwo {
    public static void main(String[] args) {
//        System.out.println(checkSum(19, 1));
//        numberType(0);
        System.out.println(checkNumber(-1));

    }


    public static boolean checkNumber(int a) {
        if (a < 0) {
            return true;
        }
        return false;
    }


    public static void numberType(int a) {
        if (a >= 0) {
            System.out.println("Положительное число");
        } else {
            System.out.println("Отрицательное число");
        }
    }

    public static boolean checkSum(int a, int b) {
        if ((a + b) > 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }
}
