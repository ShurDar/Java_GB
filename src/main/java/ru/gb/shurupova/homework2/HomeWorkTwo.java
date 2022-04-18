package ru.gb.shurupova.homework2;

public class HomeWorkTwo {
    public static void main(String[] args) {
        checkSum(1, 1);

    }

    public static int checkSum(int a, int b) {
        if ((a + b) > 10 && (a + b) <= 20) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        return a + b;
    }
}
