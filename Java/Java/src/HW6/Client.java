package HW6;

import java.util.Scanner;
import java.util.stream.Collectors;

public class Client {

    public static void main(String[] args) {
        Config config = new Config();
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        config.setConfig();

        int c = client.askCriteria("Введите цифру, соответствующую необходимому критерию:\n" +
                        "1 - ОЗУ, 2 - Объем ЖД, 3 - Операционная система, 4 - Цвет, 5 - несколько параметров"
                , scanner);
        int min;

        switch (c) {
            case 1 -> {
                min = client.askCriteria("Введите минимальное значение:", scanner);

                System.out.println(config.getLaptops().stream()
                        .filter(n -> n.getRam() >= min)
                        .sorted((n1, n2) -> Integer.compare(n2.getRam(), n1.getRam()))
                        .collect(Collectors.toList()));
            }
            case 2 -> {
                min = client.askCriteria("Введите минимальное значение:", scanner);

                System.out.println(config.getLaptops().stream()
                        .filter(n -> n.getHdd() >= min)
                        .sorted((n1, n2) -> Integer.compare(n2.getHdd(), n1.getHdd()))
                        .collect(Collectors.toList()));
            }
            case 3 -> {
                min = client.askCriteria("Введите одно из значений:\n" +
                        config.getOsMap(), scanner);

                System.out.println(config.getLaptops().stream()
                        .filter(n -> n.getOs().equals(config.getOsMap().get(min)))
                        .sorted((n1, n2) -> Integer.compare(n2.getRam(), n1.getRam()))
                        .collect(Collectors.toList()));
            }
            case 4 -> {
                min = client.askCriteria("Введите одно из значений:\n" +
                        config.getColorMap(), scanner);

                System.out.println(config.getLaptops().stream()
                        .filter(n -> n.getColor().equals(config.getColorMap().get(min)))
                        .sorted((n1, n2) -> Integer.compare(n2.getRam(), n1.getRam()))
                        .collect(Collectors.toList()));
            }
            case 5 -> {
                int minRam = client.askCriteria("Введите минимальное значение для ОЗУ:", scanner);
                int minHDD = client.askCriteria("Введите минимальное значение для ЖД:", scanner);
                int minOs = client.askCriteria("Введите одно из значений:\n" +
                        config.getOsMap(), scanner);
                int minColor = client.askCriteria("Введите одно из значений:\n" +
                        config.getColorMap(), scanner);

                System.out.println(config.getLaptops().stream()
                        .filter(n -> n.getRam() >= minRam)
                        .filter(n -> n.getHdd() >= minHDD)
                        .filter(n -> n.getOs().equals(config.getOsMap().get(minOs)))
                        .filter(n -> n.getColor().equals(config.getColorMap().get(minColor)))
                        .sorted((n1, n2) -> Integer.compare(n2.getRam(), n1.getRam()))
                        .collect(Collectors.toList()));
            }
        }
    }

    int askCriteria(String str, Scanner scanner) {
        System.out.println(str);
        return scanner.nextInt();
    }
}
