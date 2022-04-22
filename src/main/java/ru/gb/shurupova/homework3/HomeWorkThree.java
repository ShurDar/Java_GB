package ru.gb.shurupova.homework3;


import java.util.Random;

public class HomeWorkThree {
    public static void main(String[] args) {
        array(5, 7);


        // task 5
        int[] value = new int[10];
        for (int u = 0; u < value.length; u++) {
            value[u] = new Random().nextInt(100);
            System.out.print(value[u] + " ");
        }

        // min value
        int min = value[0];
        for (int i = 0; i < value.length; i++) {
            if (min > value[i]) {
                min = value[i];
            }
        }
        System.out.println();
        System.out.print("Min value = " + min);

        // max value
        int max = value[0];
        for (int j = 0; j < value.length; j++) {
            if (max < value[j]) {
                max = value[j];
            }
        }
        System.out.println();
        System.out.print("Max value = " + max);


        // task 4
        int[][] d = new int[5][5];
        for (int v = 0; v < d.length; v++) {
            for (int w = 0; w < d[v].length; w++) {
                if ((v == w)) {
                    d[v][w] = 1;
                }
                if ((v + w) == 4) {
                    d[v][w] = 1;
                }
                System.out.print(d[v][w] + " ");
            }
            System.out.println();
        }


        // task 3
        int[] c = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int z = 0; z < c.length; z++) {
            System.out.print(c[z] + " -> ");
            if (c[z] < 6) {
                c[z] = c[z] * 2;
            } else {
                c[z] = c[z];
            }
            System.out.print(c[z]);
            System.out.println();
        }


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


    // task 5
    public static void array(int len, int initialValue) {
        int[] o = new int[len];
        for (int i = 0; i < o.length; i++) {
            o[i] = initialValue;
            System.out.print(o[i] + " ");
        }
    }
}
