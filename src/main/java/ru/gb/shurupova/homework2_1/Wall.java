package ru.gb.shurupova.homework2_1;

public class Wall implements Hurdle {
    private String name;
    private int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public boolean moves(Move move) {
        System.out.println(this.name + " высотой: " + this.height + " см.");
        move.jump();

        if (this.height <= move.GetJumpHeight()) {
            System.out.println("перепрыгнул успешно");
            return true;
        } else {
            System.out.println("перепрыгнуть не смог");
            return false;
        }
    }
}
