package ru.gb.shurupova.homework2_1;

public class Human implements Move {
    private String name;
    private int runDistance;
    private int jumpHeight;
    private static final int RUN_LIMIT = 40;
    private static final int JUMP_LIMIT = 10;

    public Human(String name) {
        this.name = name;
        this.runDistance = RUN_LIMIT;
        this.jumpHeight = JUMP_LIMIT;
    }

    @Override
    public void run() {
        System.out.print(this.name + " человек ");
    }

    @Override
    public int GetRunDistance() {
        return this.runDistance;
    }

    @Override
    public void jump() {
        System.out.print(this.name + " человек ");
    }

    @Override
    public int GetJumpHeight() {
        return this.jumpHeight;
    }
}
