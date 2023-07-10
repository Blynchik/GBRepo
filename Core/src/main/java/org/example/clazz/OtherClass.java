package org.example.clazz;

/**
 * Другой полезный класс
 */
public class OtherClass {
    /**
     * Метод суммирует два целых числа
     *
     * @param a первое слагаемое
     * @param b второе слагаемое
     * @return сумма слагаемых, без проверки переполнения int
     */
    public static int add(int a, int b) {
        return a + b;
    }

    /**
     * Метод деления двух чисел
     *
     * @param a делимое
     * @param b делитель
     * @return частное без проверок
     */
    public static int div(int a, int b) {
        return a / b;
    }

    /**
     * Метод вычитания двух чисел
     *
     * @param a уменьшаемле
     * @param b вычитаемое
     * @return разность без проверки переполнения int
     */
    public static int sub(int a, int b) {
        return a - b;
    }

    /**
     * Функция умножения двух чисел
     *
     * @param a первый множитель
     * @param b второй множитель
     * @return произведение без проверки на переполнение int
     */
    public static int mul(int a, int b) {
        return a * b;
    }
}
