package ru.gb.shurupova.homework2_1;

public class Treadmill implements Hurdle {
    private String name;
    private int length;

    public Treadmill(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public boolean moves(Move move) {
        System.out.println(this.name + " длинной: " + this.length + " м.");
        move.run();

        if (this.length <= move.GetRunDistance()) {
            System.out.println("пробежал успешно");
            return true;
        } else {
            System.out.println("пробежать не смог");
            return false;
        }
    }
}
