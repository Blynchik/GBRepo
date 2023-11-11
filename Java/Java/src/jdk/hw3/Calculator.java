package jdk.hw3;

public class Calculator {
    /**
     * Написать класс Калькулятор (необобщенный), который содержит
     * обобщенные статические методы: sum(), multiply(), divide(),
     * subtract(). Параметры этих методов – два числа разного типа,
     * над которыми должна быть произведена операция.
     */
    public static <T extends Number> Double sum(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Number> Double multiply(T num1, T num2) {
        return num1.doubleValue() * num2.doubleValue();
    }

    public static <T extends Number> Double divide(T num1, T num2) {
        if (num2.doubleValue() == 0) {
            throw new IllegalArgumentException();
        }
        return num1.doubleValue() / num2.doubleValue();
    }

    public static <T extends Number> Double subtract(T num1, T num2) {
        return num1.doubleValue() - num2.doubleValue();
    }
}
