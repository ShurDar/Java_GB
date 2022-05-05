package ru.gb.shurupova.homework6;

public class Animals {
    private String name;
    private int run;
    private int swim;

    public Animals(String name, int run, int swim) {
        this.name = name;
        setRun(run);
        setSwim(swim);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRun() {
        return run;
    }

    public void setRun(int run) {
        this.run = run;
    }

    public int getSwim() {
        return swim;
    }

    public void setSwim(int swim) {
        this.swim = swim;
    }

}
