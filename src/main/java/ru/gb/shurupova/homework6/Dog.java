package ru.gb.shurupova.homework6;

public class Dog extends Animals {
    public Dog(String name, int run, int swim) {
        super(name, run, swim);
    }

    @Override
    public int getRun() {
        return super.getRun();
    }

    @Override
    public void setRun(int run) {
        if (run <= 500) {
            super.setRun(run);
        }
    }

    @Override
    public int getSwim() {
        return super.getSwim();
    }

    @Override
    public void setSwim(int swim) {
        if (swim <= 10) {
            super.setSwim(swim);
        }

    }

}
