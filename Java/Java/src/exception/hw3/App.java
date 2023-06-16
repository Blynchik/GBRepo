package exception.hw3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    private final Scanner scanner;

    public App() {
        this.scanner = new Scanner(System.in);
    }

    public String askData() {
        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения(dd.mm.yyyy) номертелефона(6-11 цифр без знаков) пол(f или m)");
        String data = scanner.nextLine();
        scanner.close();
        return data;
    }

    public String[] checkData(String data) {
        String[] parts = data.split(" ");
        if (parts.length < 6) {
            throw new RuntimeException("Недостаточно данных");
        } else if (parts.length > 6) {
            throw new RuntimeException("Лишние данные");
        }

        return parts;
    }

    public void validateData(String[] data) {
        validateName(data[0]);
        validateName(data[1]);
        validateName(data[2]);
        validateDoB(data[3]);
        validatePhoneNum(data[4]);
        validateSex(data[5]);
    }

    private void validateName(String name) {
        if (!name.matches("[а-яА-ЯёЁ]*")) {
            throw new IllegalStateException("Имя/Отчетсво/Фамилия должно состоять из кириллических букв");

        }
    }

    private void validateDoB(String dOb) {
        if (!dOb.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new IllegalStateException("Проверьте соответсиве шаблону dd.mm.yyyy");
        }
    }

    private void validatePhoneNum(String number) {
        if (!number.matches("\\b\\d{6,11}\\b(?:\\s+\\d{6,11}\\b){0,5}")) {
            throw new IllegalStateException("Проверьте правильность номера телефона");
        }
    }

    private void validateSex(String sex) {
        if (!sex.matches("[fm]")) {
            throw new IllegalStateException("Пол должен соответствовать f или m");
        }
    }

    public void writeDataToFile(String[] data, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            for (String s : data) {
                fileWriter.write("<" + s + ">");
            }
            fileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
