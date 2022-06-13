package ru.gb.shurupova.homework2_5;


public class Main {
    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }


    public static void firstMethod() {
        int size = 10_000_000;
        float[] array = new float[size];

        for (int i = 0; i < size; i++) {
            array[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        MyThread t = new MyThread("array", array);

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }


    private static void secondMethod() {
        int size = 10_000_000;
        int h = size / 2;
        float[] array = new float[size];

        for (int i = 0; i < size; i++) {
            array[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        float[] array1 = new float[h];
        float[] array2 = new float[h];

        System.arraycopy(array, 0, array1, 0, h);
        System.arraycopy(array, h, array2, 0, h);

        MyThread t1 = new MyThread("array1", array1);
        MyThread t2 = new MyThread("array2", array2);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] newArray = new float[size];

        System.arraycopy(array1, 0, newArray, 0, h);
        System.arraycopy(array2, 0, newArray, h, h);

        System.out.println("Two threads time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }
}


class MyThread extends Thread {

    private final float[] array;

    public MyThread(String name, float[] array) {
        super(name);
        this.array = array;
    }

    @Override
    public void run() {
        int arr = array.length;

        for (int i = 0; i < arr; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}



