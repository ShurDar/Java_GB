package ru.gb.shurupova.homework4;

import java.util.Random;
import java.util.Scanner;

public class LessonFour {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 10;
    public static final int MINES_COUNT = 20;

    public static final int MINE = 1000;
    public static final int EMPTY = 0;
    public static final int CELL_CLOSE = 0;
    public static final int CELL_OPEN = 1;
    public static final int CELL_FLAG = -1;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";


    public static void main(String[] args) {
        // объевляем переменную, лоя реакции на результат
        boolean userWin = play();
        if (userWin) {
            System.out.println("Поздравляю! Вы выиграли");
        } else {
            System.out.println("Бабахх!");
        }
    }


    public static boolean play() {
        boolean win;
        boolean isPassMove;
        int[][] board = generateBoard();        // массив который хранит доску
        int[][] moves = new int[HEIGHT][WIDTH]; // массив который записывает ходы игрока
        // нужен еще один массив, который будет хранить конфигирацию игры и открывать ее

        // этим циклом проверяем:
        do {
            isPassMove = move(board, moves);
            win = isWin(moves);
            //пользователь сделал ход и еще не победил, то крутимся в этом цикле дальше

        } while (isPassMove && !win);
        // если пользователь открыл все поле, не наступив на мину, то в isPassMove вернем true - победа
        // если пользователь наступил на мину, то в isPassMove вернем false - проигрышь
        return isPassMove;

    }

    // этот метод проверяет выиграл пользователь или проиграл, в него передаем ходы
    private static boolean isWin(int[][] moves) {
        // пользователь выиграл, когда открыл все поле без мин
        // когда кол-во открытых ячеек без мин = 0

        // заводим переменную openCell, кот. считает кол-во открытых ячеек
        int openCell = 0;

        // вложенный цикл пробегает по всему полю
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                // если координата хода равны константе CELL_OPEN = 1
                if (moves[i][j] == CELL_OPEN) {
                    // то прибавляем к переменно openCell единицу
                    openCell++;
                }
            }
        }// если кол-во открытых ячеек + кол-во мин равно размеру поля
        // то вернется true, т.е пользователь победил
        return openCell + MINES_COUNT == HEIGHT * WIDTH;
        // в противном случае false и возвращаемся в цикл игры
    }


    // метод для ввода и расшифровки ходов от пользователя
    private static boolean move(int[][] board, int[][] moves) {

        // Scanner нужен для того, чтобы ввыодить ходы с консоли
        Scanner scanner = new Scanner(System.in);

        // печатаем игровое поле и записывает ходы
        printBoard(board, moves);
        int row, line;            // 2 переменные столбец и строка
        while (true) {            // бесконечный цикл для проверки и расшифровки ходов пользователя

            //запрашиваем координату
            System.out.print("Ваш ход (столбец, срока, например А1): ");
            String move = scanner.nextLine(); // получаем координату

            // рашифровываем, где эта координата на поле
            row = move.charAt(0) - 'A';
            line = move.charAt(1) - '0';

            // проверяем, попадает ли координата в поле
            if (row < WIDTH && row >= 0 && line < HEIGHT && line >= 0) {

                // если координата в поле - выходим из бесконечного цикла while
                break;

            } // в противном случае, просим ввести корректные координаты и возврщаемся в цикл while
            System.out.println("Введите координаты внутри игрового поля");
        }
        // проверка, что после хода не наткнулись на мину
        // если не мина
        if (board[line][row] != MINE) {
            // открываем ячейку
            moves[line][row] = CELL_OPEN;
            // и возвращаем true
            return true;
        } // в противном случае - подорвались, возвращаем false
        return false;
    }

    // метод для расчета поля
    public static int[][] generateBoard() {
        // создаем двумерный массив для отрисовки игровой доски с константами ш/в
        int[][] board = new int[HEIGHT][WIDTH];

        // раскидываем бомбы по полю рандомно
        Random random = new Random();

        // создаем перменную, кот. считает количество мин на поле
        int mines = MINES_COUNT; // 10
        int maxMines = HEIGHT * WIDTH; // 9

        if (mines > maxMines) {
            for (int i = 0; i < maxMines; i++) {
                int x, y;
                do { // которые генерируют случайные координаты на поле, куда поставить мину
                    x = random.nextInt(HEIGHT);
                    y = random.nextInt(WIDTH);

                    // цикл возвращается в do (генерит новые координаты) пока в ячейке встречаетчя мина
                } while (board[x][y] == MINE);

                // если в ячейке нет мины, она ставиться в сегенренные координаты
                board[x][y] = MINE;
            }
        } else {
            for (int i = 0; i < mines; i++) {
                int x, y;
                do { // которые генерируют случайные координаты на поле, куда поставить мину
                    x = random.nextInt(HEIGHT);
                    y = random.nextInt(WIDTH);

                    // цикл возвращается в do (генерит новые координаты) пока в ячейке встречаетчя мина
                } while (board[x][y] == MINE);

                // если в ячейке нет мины, она ставиться в сегенренные координаты
                board[x][y] = MINE;
            }
        }


// крутим цикл, пока кол-во бомб не станет = 0
//        while (mines > 0 ){
//            //задаем две переменные
//            int x, y;
//            do { // которые генерируют случайные координаты на поле, куда поставить мину
//                x = random.nextInt(HEIGHT);
//                y = random.nextInt(WIDTH);
//
//
//                // цикл возвращается в do (генерит новые координаты) пока в ячейке встречаетчя мина
//            } while (board[x][y] == MINE );
//
//            // если в ячейке нет мины, она ставиться в сегенренные координаты
//            board[x][y] = MINE;
//            mines--;
//        }

        // цикл пробегается по ячейкам и если в ячейке встречает мину, не останавливается
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (board[i][j] == MINE) {
                    continue;
                }
                // этот цикл раставляет числа на поле, сколько вокруг них мин
                // заводим вспомогательную переменную, от кот. считается количество мин
                int mCount = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k < 0 || k >= HEIGHT || l < 0 || l >= WIDTH) {
                            continue;
                        }
                        if (board[k][l] == MINE) {
                            mCount++;
                        }
                    }
                }
                board[i][j] = mCount;
            }
        }
        // возвращает готовое игровое поле
        return board;
    }

    // метод отрисовки поля
    public static void printBoard(int[][] board, int[][] moves) {
        // отрисовываем верхнюю шкалу из букв
        System.out.print("   ");
        for (char i = 'A'; i < 'A' + WIDTH; i++) {
            System.out.print(" " + i);
        }
        //переход на новую строку
        System.out.println();

        for (int i = 0; i < HEIGHT; i++) {
            //отрисовка левой шкалы поля
            System.out.printf("%3d", i);
            for (int j = 0; j < WIDTH; j++) {

                //закрываем поле скобочками
                if (moves[i][j] == CELL_CLOSE) {
                    System.out.print("[]");
                    continue;
                }
                if (moves[i][j] == CELL_FLAG) {
                    System.out.println(" P");
                    continue;
                }
                // вызываем метод для отрисовки цвета
                String colorCode = getColorCode(board[i][j]);
                // выводим цвет в консоль
                System.out.print(colorCode);

                // отрисовка поля
                // если ячейка пустая - точка
                if (board[i][j] == EMPTY) {
                    System.out.print(" .");

                    // если в ячейке мина (1000) - звездочка
                } else if (board[i][j] == MINE) {
                    System.out.print(" *");

                    // в противном случае пишем значение ячейки
                } else {
                    System.out.printf("%2d", board[i][j]);
                }
                // сбрасываем цвет
                System.out.print(ANSI_RESET);

            }// переход на новую строку в каждой итерации цикла
            System.out.println();
        }
    }

    // создаем метод, для отрисовки поля в цвете
    public static String getColorCode(int i) {
        switch (i) {
            case EMPTY:
                return ANSI_WHITE;
            case MINE:
                return ANSI_PURPLE;
            case 1:
                return ANSI_BLUE;
            case 2:
                return ANSI_GREEN;
            case 3:
                return ANSI_RED;
            case 4:
                return ANSI_CYAN;
            default:
                return ANSI_YELLOW;
        }
    }
}
