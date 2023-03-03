package OOP.hw7.factoryMethod;

import OOP.hw7.factoryMethod.AstroDroidFactory;
import OOP.hw7.factoryMethod.BattleDroidFactory;
import OOP.hw7.factoryMethod.DroidFactory;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Какого дроида построить?\n1 - астромеханик, 2 - боевой дроид");

        DroidFactory droidFactory = createSpecialDroid(scanner.nextLine());
        droidFactory.createDroid().makeNoise();

        scanner.close();
    }

    static DroidFactory createSpecialDroid(String request) {
        if (request.equals("1")) {
            return new AstroDroidFactory();
        } else if (request.equals("2")) {
            return new BattleDroidFactory();
        } else {
            throw new RuntimeException("Модель не существует");
        }
    }
}
