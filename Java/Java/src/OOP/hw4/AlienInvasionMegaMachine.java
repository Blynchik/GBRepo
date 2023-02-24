package OOP.hw4;

import org.w3c.dom.ls.LSOutput;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class AlienInvasionMegaMachine {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(1234)) {
            System.out.println("Сканнер запущен, ожидаем соединение с планетой....");
            Socket socket = serverSocket.accept();
            EarthPlanet earthPlanet = new EarthPlanet();
            System.out.println("Планета соединена гиперпространственным туннелем!");
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            int exit = 0;

            while (exit == 0) {
                String clientRequest = dataInputStream.readUTF();

                switch (clientRequest) {
                    case "1" -> {
                        clientRequest = dataInputStream.readUTF();
                        dataOutputStream.writeUTF(earthPlanet.getHuman(Integer.parseInt(clientRequest)).toString());
                    }
                    case "2" -> {
                        if (dataInputStream.readUTF().equals("да")) {

                            int nameIndex = Integer.parseInt(dataInputStream.readUTF());
                            int surnameIndex = Integer.parseInt(dataInputStream.readUTF());
                            int professionIndex = Integer.parseInt(dataInputStream.readUTF());

                            Human human = new Human(
                                    Name.values()[nameIndex].toString(),
                                    Surname.values()[surnameIndex].toString(),
                                    (int) (Math.random() * 55 + 20),
                                    Profession.values()[professionIndex].toString());

                            earthPlanet.addHuman(human);
                            dataOutputStream.writeUTF(earthPlanet.getHuman(human.getId()).toString());
                        } else {
                            Human human = new Human(
                                    dataInputStream.readUTF(),
                                    dataInputStream.readUTF(),
                                    Integer.parseInt(dataInputStream.readUTF()),
                                    dataInputStream.readUTF());

                            earthPlanet.addHuman(human);
                            dataOutputStream.writeUTF(earthPlanet.getHuman(human.getId()).toString());
                        }
                    }

                    case "3" -> {
                        Human human = earthPlanet.getHuman(Integer.parseInt(dataInputStream.readUTF()));

                        human.setName(dataInputStream.readUTF());
                        human.setSurname(dataInputStream.readUTF());
                        human.setAge(Integer.parseInt(dataInputStream.readUTF()));
                        human.setProfession(dataInputStream.readUTF());

                        dataOutputStream.writeUTF(earthPlanet.getHuman(human.getId()).toString());
                    }

                    case "4" -> {
                        int id = Integer.parseInt(dataInputStream.readUTF());
                        dataOutputStream.writeUTF(earthPlanet.getHuman(id).toString());
                        earthPlanet.deleteHuman(id);
                    }

                    case "5" -> {
                        dataOutputStream.writeUTF(earthPlanet.getHumanity().toString());
                    }
                    case "6" -> {
                        System.out.println("Прощай бренный мир!");
                        exit = 1;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}