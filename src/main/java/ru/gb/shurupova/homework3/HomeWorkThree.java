package ru.gb.shurupova.homework3;

public class HomeWorkThree {
    public static void main(String[] args) {


        // task 2
        int[] a = new int[100];
        for (int x = 0; x < a.length; x++) {
            a[x] = x + 1;
            System.out.print(a[x] + " ");
        }


        // task 1
        int[] b = new int[5];
        b[0] = 1;
        b[1] = 1;
        b[2] = 0;
        b[3] = 1;
        b[4] = 0;

        for (int y = 0; y < b.length; y++) {
            System.out.print(b[y] + " -> ");

            if (b[y] == 0) {
                b[y] = b[y] + 1;
            } else {
                b[y] = b[y] - 1;
            }

            System.out.print(b[y]);
            System.out.println();
        }
    }
}
