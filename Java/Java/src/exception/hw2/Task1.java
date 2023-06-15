package exception.hw2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        //Реализуйте метод, который запрашивает у пользователя
        // ввод дробного числа (типа float), и возвращает введенное
        // значение. Ввод текста вместо числа не должно приводить
        // к падению приложения, вместо этого, необходимо повторно
        // запросить у пользователя ввод данных.
        System.out.println(askFloatNum());


    }

    public static float askFloatNum() {
        Scanner scanner = new Scanner(System.in);
        Float num = null;
        try {
            num = scanner.nextFloat();
        } catch (InputMismatchException e){
            System.out.println("Not float, try again");
        }

        if(num == null){
            num = askFloatNum();
        }
        return num;
    }
}
