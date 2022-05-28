package ru.gb.shurupova.homework2_1;

public class Robot implements Move {
    private String name;
    private int runDistance;
    private int jumpHeight;
    private static final int RUN_LIMIT = 30;
    private static final int JUMP_LIMIT = 5;

    public Robot(String name) {
        this.name = name;
        this.runDistance = RUN_LIMIT;
        this.jumpHeight = JUMP_LIMIT;
    }

    @Override
    public void run() {
        System.out.print(this.name + " робот ");
    }

    @Override
    public int GetRunDistance() {
        return this.runDistance;
    }

    @Override
    public void jump() {
        System.out.print(this.name + " робот ");
    }

    @Override
    public int GetJumpHeight() {
        return this.jumpHeight;
    }
}
