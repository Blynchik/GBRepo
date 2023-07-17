package core2;

import java.util.Random;
import java.util.Scanner;

public class Program {

    /**
     * TODO: ЗАДАЧА1: Переписать программу самостоятельно.
     */

    private static final int WIN_COUNT = 4;
    private static final char DOT_HUMAN = 'X';
    private static final char DOT_AI = 'O';
    private static final char DOT_EMPTY = '*';
    private static Scanner scanner;
    private static char[][] field;
    private static int fieldSizeX;
    private static int fieldSizeY;
    private static Random random = new Random();

    private static Scanner getScanner() {
        if (scanner == null)
            scanner = new Scanner(System.in);
        return scanner;
    }

    public static void main(String[] args) {
        while (true) {
            initialize();
            while (true) {
                printField();
                humanTurn();
                printField();
                if (gameCheck(DOT_HUMAN, "Вы победили!!!"))
                    break;
                aiTurn();
                printField();
                if (gameCheck(DOT_AI, "Победил компьютер!"))
                    break;
            }
            System.out.println("Желаете сыграть еще раз ? (Y - да)");
            if (!getScanner().next().equalsIgnoreCase("Y"))
                break;
        }

    }

    /**
     * TODO: Возможно, поправить отрисовку игрового поля
     * Инициализация игрового поля
     */
    private static void initialize() {
        fieldSizeX = 5;
        fieldSizeY = 5;

        field = new char[fieldSizeX][fieldSizeY];
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                field[x][y] = DOT_EMPTY;
            }
        }
    }

    /**
     * Отрисовка игрового поля
     */
    private static void printField() {

        System.out.print("+");
        for (int i = 0; i < fieldSizeX * 2 + 1; i++) {
            System.out.print(i % 2 == 0 ? "-" : i / 2 + 1);
        }
        System.out.println();
        for (int x = 0; x < fieldSizeX; x++) {

            System.out.print(x + 1 + "|");
            for (int y = 0; y < fieldSizeY; y++) {
                System.out.print(field[x][y] + "|");
            }

            System.out.println();
        }
        for (int i = 0; i < fieldSizeX * 2 + 2; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    /**
     * Метод проверки состояния игры
     *
     * @param c   фишка игрока
     * @param str победный слоган
     * @return состояние игры (true - игра завершена!)
     */
    static boolean gameCheck(char c, String str) {
        if (checkWin(c)) {
            System.out.println(str);
            return true;
        }
        if (checkDraw()) {
            System.out.println("Ничья!");
            return true;
        }
        return false; // Игра продолжается
    }

    /**
     * Проверка победы
     * TODO: 2 ЗАДАЧА: Переработать метод проверки победы в домашнем задании, необходимо использовать
     *  вспомогательыне методы и циклы (например for)
     *
     * @param c фишка игрока
     * @return результат проверки
     */
    static boolean checkWin(char c) {
        return checkDiagonal(c) || checkVertical(c) || checkHorizontal(c);
    }


    /**
     * Проверка на ничью
     *
     * @return результат проверки
     */
    private static boolean checkDraw() {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (isCellEmpty(x, y)) return false;
            }
        }
        return true;
    }


    /**
     * Обработка хода игрока
     */
    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координаты хода X и Y (от 1 до 3) через пробел >>>");
            x = getScanner().nextInt() - 1;
            y = getScanner().nextInt() - 1;
        }
        while (!isCellValid(x, y) || !isCellEmpty(x, y));
        field[x][y] = DOT_HUMAN;
    }

    /**
     * TODO: Задача 3: Компьютер должен помешать игроку победить
     * Ход компьютера
     */
    private static void aiTurn() {
        int x, y;
        int points = 0;
        int[] random = randomTurn();
        x = random[0];
        y = random[1];

        //points in horizon
        for (int i = 0; i < fieldSizeX; i++) {
            points = 0;
            for (int j = 0; j < fieldSizeY; j++) {
                if (field[i][j] == DOT_HUMAN) {
                    points++;
                    if (points == WIN_COUNT - 1) {
                        x = i;
                        if (isCellEmpty(i, 0) && isCellEmpty(i, fieldSizeY - 1)) {
                            y = Math.random() > 0.5 ? 0 : fieldSizeY - 1;
                        } else {
                            for (int k = 1; k < fieldSizeY - 2; k++) {
                                if (isCellEmpty(i, k)) {
                                    y = k;
                                }
                            }
                        }

                    }
                }
            }
        }

        if (!isCellEmpty(x, y)) {
            random = randomTurn();
            x = random[0];
            y = random[1];
        }

        if(points < WIN_COUNT-1) {
            points = 0;
            //points on column
            for (int j = 0; j < fieldSizeY; j++) {
                for (int i = 0; i < fieldSizeX; i++) {
                    if (field[i][j] == DOT_HUMAN) {
                        points++;
                        if (points == WIN_COUNT - 1) {
                            y = j;
                            if (isCellEmpty(0, j) && isCellEmpty(i, fieldSizeX - 1)) {
                                y = Math.random() > 0.5 ? 0 : fieldSizeX - 1;
                            } else {
                                for (int k = 1; k < fieldSizeY - 2; k++) {
                                    if (isCellEmpty(k, j)) {
                                        x = k;
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }


        if (!isCellEmpty(x, y)) {
            random = randomTurn();
            x = random[0];
            y = random[1];
        }

        field[x][y] = DOT_AI;
    }

    /**
     * Проверка, является ли ячейка пустой
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    private static boolean isCellEmpty(int x, int y) {
        return field[x][y] == DOT_EMPTY;
    }

    /**
     * Проверка корректности ввода
     * (координаты хода не должны превышать размерность массива игрового поля)
     *
     * @param x координата
     * @param y координата
     * @return результат проверки
     */
    private static boolean isCellValid(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean checkVertical(char c) {
        // Проверка горизонталей
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    int winPoint = 0;
                    for (int i = 0; i < WIN_COUNT; i++) {
                        if (x + i < fieldSizeX && field[x + i][y] == c) {
                            winPoint++;
                            if (winPoint == WIN_COUNT) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    private static boolean checkHorizontal(char c) {
        //Проверка вертикалей
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[x][y] == c) {
                    int winPoint = 0;
                    for (int i = 0; i < WIN_COUNT; i++) {
                        if (y + i < fieldSizeY && field[x][y + i] == c) {
                            winPoint++;
                            if (winPoint == WIN_COUNT) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }


    private static boolean checkDiagonal(char c) {
        for (int x = 0; x < fieldSizeX; x++) {
            for (int y = 0; y < fieldSizeY; y++) {
                if (field[x][y] == c) {
                    int winPoint1 = 0;
                    int winPoint2 = 0;
                    for (int i = 0; i < WIN_COUNT; i++) {
                        if (x + i < fieldSizeX && y + i < fieldSizeY && field[x + i][y + i] == c) {
                            winPoint1++;
                            if (winPoint1 == WIN_COUNT) {
                                return true;
                            }

                        } else {
                            winPoint1 = 0;
                        }
                        if (x - i >= 0 && y + i < fieldSizeY && field[x - i][y + i] == c) {
                            winPoint2++;
                            if (winPoint2 == WIN_COUNT) {
                                return true;
                            }
                        } else {
                            winPoint2 = 0;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static int[] randomTurn() {
        int x, y;
        do {
            x = random.nextInt(fieldSizeX);
            y = random.nextInt(fieldSizeY);
        }
        while (!isCellEmpty(x, y));
        return new int[]{x, y};
    }
}
