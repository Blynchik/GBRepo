package jdk.hw2.server.server;

import jdk.hw2.server.client.Client;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static final String LOG_PATH = "src/jdk/hw2/server/server/log.txt";
    List<Client> clientList;
    ServerWindow serverWindow;
    boolean work;

    public Server(ServerWindow serverWindow) {
        clientList = new ArrayList<>();
        this.serverWindow = serverWindow;
    }

    public void start() {
        work = true;
    }

    public void stop() {
        work = false;
        for (Client c : clientList) {
            disconnectUser(c);
        }
    }

    public boolean connectUser(Client client) {
        if (!work) {
            return false;
        }
        clientList.add(client);
        return true;
    }

    public void disconnectUser(Client client) {
        clientList.remove(client);
        if (clientList != null) {
            client.disconnect();
        }
    }

    public String getHistory() {
        return readLog();
    }

    public void sendMessage(String text) {
        if (!work) {
            return;
        }
        answerAll(text);
        saveInLog(text);
        updateServerWindow(text);
    }

    public void answerAll(String text) {
        for (Client c : clientList) {
            c.serverAnswer(text);
        }
    }

    private void saveInLog(String text) {
        try (FileWriter writer = new FileWriter(LOG_PATH, true)) {
            writer.write(text);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readLog() {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(LOG_PATH);) {
            int c;
            while ((c = reader.read()) != -1) {
                stringBuilder.append((char) c);
            }
            stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
            return stringBuilder.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateServerWindow(String text) {
        if (!work) {
            return;
        }
//        text += "";
        if (text != null) {
            printText(text);
        }
    }

    private void printText(String text) {
        serverWindow.log.append(text + "\n");
    }
}
