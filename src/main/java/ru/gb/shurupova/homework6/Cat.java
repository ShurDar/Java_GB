package ru.gb.shurupova.homework6;

public class Cat extends Animals {
    public Cat(String name, int run, int swim) {
        super(name, run, swim);
    }


    @Override
    public void setRun(int run) {
        if (run <= 200) {
            super.setRun(run);
        }
    }

    @Override
    public int getRun() {
        return super.getRun();
    }

    @Override
    public int getSwim() {
        return super.getSwim();
    }

    @Override
    public void setSwim(int swim) {
        if (swim < 0) {
            super.setSwim(swim);
        }
    }
}

