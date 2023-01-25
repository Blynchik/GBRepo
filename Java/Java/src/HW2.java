import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class HW2 {
    public static Logger logger;
    public static FileHandler handler;

    public static void main(String[] args) {

        //Дана json строка { { "фамилия":"Иванов","оценка":"5",
        // "предмет":"Математика"},{"фамилия":"Петрова","оценка":
        // "4","предмет":"Информатика"},{"фамилия":"Краснов",
        // "оценка":"5","предмет":"Физика"}}
        // Задача написать метод(ы), который распарсить строку и выдаст ответ вида:
        // Студент Иванов получил 5 по предмету Математика.
        // Студент Петрова получил 4 по предмету Информатика.
        // Студент Краснов получил 5 по предмету Физика.
        // Используйте StringBuilder для подготовки ответа

        //Создать метод, который запишет результат работы в файл.
        // Обработайте исключения и запишите ошибки в лог файл

        String str = "{{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"},{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"},{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"},{\"фамилия\":\"Ершова\",\"оценка\":\"3\",\"предмет\":\"Химия\"}}";

        HW2 hw2 = new HW2();
        logger = Logger.getLogger(HW2.class.getName());


        try {
            handler = new FileHandler("log.xml");
            logger.addHandler(handler);
            XMLFormatter xml = new XMLFormatter();
            handler.setFormatter(xml);
        } catch (IOException e) {
            e.getStackTrace();
        }

        hw2.writeToFile(hw2.getStringBuilder(str));
    }

    public StringBuilder getStringBuilder(String str) {
        logger.log(Level.INFO, "Получаем строку для записи");
        List<StringBuilder> strings = Arrays.stream(str.substring(2, str.length() - 1).split(",\\{"))
                .map(StringBuilder::new)
                .toList();
        StringBuilder stringBuilder = new StringBuilder();

        for (StringBuilder string : strings) {
            stringBuilder.append("Студент ")
                    .append(string, string.indexOf("фамилия\":\"") + 10, string.indexOf("\","))
                    .append(" получил ")
                    .append(string.charAt(string.indexOf("оценка\":\"") + 9))
                    .append(" по предмету ")
                    .append(string, string.indexOf("предмет\":\"") + 10, string.indexOf("\"}"))
                    .append("\n");
        }
        logger.log(Level.INFO, "Получили строку для записи");
        return stringBuilder;
    }

    public void writeToFile(StringBuilder stringBuilder) {
        logger.log(Level.INFO, "Начинаем запись в файл");
        try (FileWriter fileWriter = new FileWriter("AAA.txt", false)) {
            fileWriter.write(stringBuilder.toString());
        } catch (Exception e) {
            logger.log(Level.INFO, "Ошибка записи");;
        }
        logger.log(Level.INFO, "Запись завершена");
    }
}
