package ru.gb.shurupova.homework2_1;

import java.util.Random;

public class MainHw {
    public static void main(String[] args) {
        Random random = new Random();

        Move[] moves = new Move[3];
        moves[0] = new Human("Первый");
        moves[1] = new Cat("Первый");
        moves[2] = new Robot("Первый");

        Hurdle[] hurdles = new Hurdle[6];

        for (int i = 0; i < hurdles.length; i++) {
            boolean isTreadmill = random.nextBoolean();
            int length = random.nextInt(50);
            int height = random.nextInt(50);
            if (isTreadmill) {
                hurdles[i] = new Treadmill("дорожка " + i, length);
            } else {
                hurdles[i] = new Wall("стена " + i, height);
            }
        }

        for (int i = 0; i < moves.length; i++) {
            boolean result = true;
            for (int j = 0; j < hurdles.length; j++) {
                result = hurdles[j].moves(moves[i]);

                if (!result) {
                    break;
                }
            }

            if (result) {
                System.out.println("Успешный успех!");
                System.out.println("");
            } else {
                System.out.println("Неудача");
                System.out.println("");
            }
        }
    }
}
