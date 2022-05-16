package ru.gb.shurupova.homework7;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean hungry;


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.hungry = false;
    }

    public String getName() {
        return name;
    }

    public boolean isHungry() {
        return hungry;
    }

    public void eat(Plate p) {
        if (appetite > p.getFood()) {
            System.out.println("Кот " + getName() + " слишком голодный, ему мало еды!");
        } else {
            p.decreaseFood(appetite);
            hungry = true;
            System.out.println("Кот " + getName() + " наелся");
        }
    }


}
