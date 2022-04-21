package ru.gb.shurupova.homework3;

public class HomeWorkThree {
    public static void main(String[] args) {

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
