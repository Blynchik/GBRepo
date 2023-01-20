import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {

        //Вычислить n-ое треугольного число(сумма чисел от 1 до n)
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int num = scanner.nextInt();
        System.out.printf("Сумма чисел от 1 до %d: %d\n", num, num * (num + 1) / 2);

        //Вычислить n! (произведение чисел от 1 до n)
        long mult = 1;
        for (int i = 1; i <= num; i++) {
            mult *= i;
        }
        System.out.printf("Произведение чисел от 1 до %d: %d\n", num, mult);

        // Вывести все простые числа от 1 до 1000 (простые числа - это числа которые
        // делятся только на себя и на единицу без остатка. Чтобы найти остаток
        // от деления используйте оператор % , например 10%3 будет равно единице)
        System.out.println("Простые числа от 1 до 1000:");
        for (int i = 2; i <= 1000; i++) {
            boolean simple = true;

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                    break;
                }
            }
            if (simple) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");

        // Реализовать простой калькулятор
        // ("введите первое число"... "Введите второе число"...
        // "укажите операцию, которую надо выполнить с этими числами"...
        // "ответ: ...")
        System.out.println("Введите число 1:");
        int num1 = scanner.nextInt();

        System.out.println("Введите число 2: ");
        int num2 = scanner.nextInt();

        System.out.println("Введите операцию(+,-,*,/):");
        Scanner keyboard = new Scanner(System.in);
        String operation = keyboard.nextLine();

        switch (operation) {
            case "+" -> System.out.println(num1 + num2);
            case "-" -> System.out.println(num1 - num2);
            case "*" -> System.out.println(num1 * num2);
            case "/" -> System.out.println(num1 / num2);
        }

        scanner.close();
        keyboard.close();
    }
}
