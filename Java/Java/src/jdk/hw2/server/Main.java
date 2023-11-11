package jdk.hw2.server;


import jdk.hw2.server.client.ClientGUI;
import jdk.hw2.server.client.ClientView;
import jdk.hw2.server.server.ServerView;
import jdk.hw2.server.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerView serverWindow = new ServerWindow();
        ClientView view1 = new ClientGUI(serverWindow.getServer());
        ClientView view2 = new ClientGUI(serverWindow.getServer());
    }
}
