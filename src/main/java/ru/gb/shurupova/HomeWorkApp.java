package ru.gb.shurupova;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    public static void main(String[] args) {
//        System.out.println(fibb(5));
        System.out.println(fibbTail(50));
    }

    public static long fibbTail(int n){
        return fibbTail(n, 0, 1);
    }
    public static long fibbTail(int n, long a, long b){
        if (n == 0){
            return a;
        }
        if (n == 1){
            return b;
        }
        return fibbTail(n - 1, b, a + b);
    }


    private static long fibb(int n) { // передаем порядковый номер числа
        if (n < 3) {
            return 1;
        }
        return fibb(n - 1) + fibb(n - 2);
    }

    private static long fibb1(int n) {
        if (n < 3) {
            return 1;
        }
        long first = 1, second = 1, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}





