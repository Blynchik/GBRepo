package core5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Random;

public class Program {


    private static final Random random = new Random();

    private static final int CHAR_BOUND_L = 65;
    private static final int CHAR_BOUND_H = 90;

    private static final String TO_SEARCH = "GeekBrains";
    private static final String BACKUP_DIR = "./backup";

    /**
     * 1.  Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
     * 2.  Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
     * 3.* Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
     * 4.* Написать метод, проверяющий, есть ли указанное слово в папке
     */

    public static void main(String[] args) throws IOException {

        int a = 1;
        int b = 2;

        int c = a + b;

        System.out.println(generateSymbols(25));

        writeFileContents("sample01.txt", 25, 3);
        writeFileContents("sample02.txt", 25, 5);

        concatenate("sample01.txt", "sample02.txt", "sample.res.txt");

        System.out.printf("Файл sample.res.txt %s\n",
                searchInFile("sample.res.txt", TO_SEARCH) ?
                        String.format("содержит искомое слово \"%s\".", TO_SEARCH) : "не содержит искомого слова.");

        String[] fileNames = new String[10];
        for (int i = 0; i < fileNames.length; i++) {
            fileNames[i] = "file_" + i + ".txt";
            writeFileContents(fileNames[i], 100, 4);
            System.out.printf("Файл %s создан.\n", fileNames[i]);
        }

        makeBackupFiles();

        Tree.print(new File("."), "", true);

        File rootDir = new File(".");
        File[] files = rootDir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.printf("Файл %s %s\n",
                        files[i].getName(),
                        searchInFile(files[i].getName(), TO_SEARCH) ?
                                String.format("содержит искомое слово \"%s\".", TO_SEARCH) : "не содержит искомого слова.");

            }
        }
    }

    /**
     * Метод генерации некоторой последовательности символов
     *
     * @param size кол-во символов
     * @return последовательность символов
     */
    private static String generateSymbols(int size) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append((char) random.nextInt(CHAR_BOUND_L, CHAR_BOUND_H + 1));
        }
        return stringBuilder.toString();
    }

    /**
     * Записать последовательность символов в файл
     *
     * @param fileName
     * @param size
     * @throws IOException
     */
    private static void writeFileContents(String fileName, int size) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            fileOutputStream.write(generateSymbols(size).getBytes());
        }
    }

    private static void writeFileContents(String fileName, int size, int words) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
            for (int i = 0; i < words; i++) {
                if (random.nextInt(8) == 0) {
                    fileOutputStream.write(TO_SEARCH.getBytes());
                } else {
                    fileOutputStream.write(generateSymbols(size).getBytes());
                }
            }
        }
    }

    private static void makeBackupFiles() {
        File[] files = new File(".").listFiles();
        for (File file : files) {
            try {
                if (file.isFile()) {
                    Files.copy(file.toPath(), new File(BACKUP_DIR + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void concatenate(String fileIn1, String fileIn2, String fileOut) throws IOException {

        // Поток на запись
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileOut)) {

            // Поток на чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn1)) {
                int c;
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }

            // Поток на чтение
            try (FileInputStream fileInputStream = new FileInputStream(fileIn2)) {
                int c;
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }

    private static boolean searchInFile(String fileName, String search) throws IOException {
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            byte[] searchData = search.getBytes();
            int i = 0;
            int c;
            while ((c = fileInputStream.read()) != -1) {
                if (c == searchData[i]) {
                    i++;
                } else {
                    i = 0;
                    if (c == searchData[i])
                        i++;
                    continue;
                }
                if (i == searchData.length) {
                    return true;
                }
            }
            return false;
        }
    }


}
