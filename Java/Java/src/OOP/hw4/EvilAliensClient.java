package OOP.hw4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EvilAliensClient {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try (Socket socket = new Socket("localhost", 1234)) {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            int exit = 0;

            while (exit == 0) {

                System.out.println("""
                        Вас приветствует персональный менеджер планирования вторжений.
                        Чем займемся сегодня?
                        =====================
                        1 - следить за человеком (read)
                        2 - внедрить шпиона (create)
                        3 - редактировать ДНК человека (update)
                        4 - транклюкировать человека (delete)
                        5 - режим "Большой брат" (read)
                        6 - самоуничтожение""");

                String request = scanner.nextLine();
                dataOutputStream.writeUTF(request);

                switch (request) {
                    case "1" -> {
                        System.out.println("Введите id человека: ");
                        request = scanner.nextLine();
                        System.out.println("Слежка за объектом....");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        System.out.println("Сбор информации....");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                        dataOutputStream.writeUTF(request);
                        System.out.println("Получили сообщение от менеджера:" + dataInputStream.readUTF()
                                + "\n=====================");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    case "2" -> {
                        System.out.println("Создать автоматически?\nда/нет");
                        request = scanner.nextLine();
                        dataOutputStream.writeUTF(request);

                        if (request.equals("да")) {

                            System.out.println("Подготавливаем агента....");
                            request = String.valueOf((int) (Math.random() * Name.values().length));
                            dataOutputStream.writeUTF(request);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            request = String.valueOf((int) (Math.random() * Surname.values().length));
                            dataOutputStream.writeUTF(request);
                            System.out.println("Делаем пластическую операцию....");

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                            request = String.valueOf((int) (Math.random() * Profession.values().length));
                            dataOutputStream.writeUTF(request);
                            System.out.println("Придумываем легенду для шпиона....");
                            System.out.println("Получили сообщение от менеджера:" + dataInputStream.readUTF() + " успешно внедрен"
                                    + "\n=====================");

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            askLore(scanner, dataOutputStream);

                            System.out.println("Получили сообщение от менеджера:" + dataInputStream.readUTF() + " успешно внедрен"
                                    + "\n=====================");

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }

                    case "3" -> {
                        System.out.println("Введите id человека: ");
                        request = scanner.nextLine();
                        dataOutputStream.writeUTF(request);

                        askLore(scanner, dataOutputStream);
                        System.out.println("Получили сообщение от менеджера:" + dataInputStream.readUTF() + " геном успешно изменен"
                                + "\n=====================");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    case "4" -> {
                        System.out.println("Введите id человека: ");
                        request = scanner.nextLine();
                        dataOutputStream.writeUTF(request);

                        System.out.println("Получили сообщение от менеджера:" + dataInputStream.readUTF() + " свидетель успешно устранен"
                                + "\n=====================");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                    case "5" -> {
                        System.out.println("Получили сообщение от менеджера:\nРежим \"Большой брат\" успешно активирован." + dataInputStream.readUTF()
                                + "\n=====================");
                    }

                    case "6" -> {
                        System.out.println("Бегите, глупцы!\nСамоуничтожение через:");

                        for (int i = 3; i >= 0; i--) {
                            System.out.println(i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }

                        System.out.println("Бум!");
                        scanner.close();
                        exit = 1;
                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void askLore(Scanner scanner, DataOutputStream dataOutputStream) throws IOException {
        System.out.println("Введите имя:");
        dataOutputStream.writeUTF(scanner.nextLine());

        System.out.println("Введите фамилию:");
        dataOutputStream.writeUTF(scanner.nextLine());

        System.out.println("Введите возраст:");
        dataOutputStream.writeUTF(scanner.nextLine());

        System.out.println("Введите профессию:");
        dataOutputStream.writeUTF(scanner.nextLine());
    }
}
