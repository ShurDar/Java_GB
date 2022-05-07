package ru.gb.shurupova.homework6;

public class Animals {
    private static int nextNumber = 1;

    private String name;
    private int run;
    private int swim;
    private int number;

    public Animals(String name, int run, int swim) {
        this.name = name;
        setRun(run);
        setSwim(swim);

    }

    public int getNumber(){
        return number;
    }

    public void setNumber(){
        number = nextNumber;
        nextNumber++;
    }

    public static int getNextNumber(){
        return nextNumber;
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
