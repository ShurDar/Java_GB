package ru.gb.shurupova.homework2_2;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        super("Неправильное значение массива. Ошибка в ячейке: " + i + "x" + j);
        this.i = i;
        this.j = j;
    }
}
