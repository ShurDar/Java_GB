package ru.gb.shurupova.homework2_2;

public class Main {
    public static void main(String[] args) {

        String[][] array = new String[][]{
                {"5", "4", "3", "2"},
                {"2", "3", "4", "5"},
                {"3", "2", "5", "4"},
                {"4", "5", "o", "3"}
        };


        try {
            System.out.println(toCheckSizeAndSum(array));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    public static int toCheckSizeAndSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sum;
    }
}







