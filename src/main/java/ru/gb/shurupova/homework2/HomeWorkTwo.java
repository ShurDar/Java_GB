package ru.gb.shurupova.homework2;

public class HomeWorkTwo {
    public static void main(String[] args) {
        System.out.println(checkSum(10, 1));
    }

    public static boolean checkSum(int a, int b) {
        if ((a + b) > 10 && (a + b) <= 20) {
            return true;
        } else {
            return false;
        }
    }
}
