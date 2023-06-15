package exception.hw2;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        //Разработайте программу, которая выбросит Exception,
        // когда пользователь вводит пустую строку.
        // Пользователю должно показаться сообщение, что
        // пустые строки вводить нельзя.
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (s.isBlank()) {
            throw new RuntimeException("Should not be empty");
        }
    }
}

