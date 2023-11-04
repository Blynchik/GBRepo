package jdk.hw1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Timer;
import java.util.TimerTask;

import static java.awt.BorderLayout.*;

public class ClientGUI extends JFrame {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIpAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("ivan_igorevich");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelButton = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");

    private boolean connected;

    private ClientGUI() {
        connected = false;
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkServer()) {
                    connected = true;
                    String messageToSave = tfLogin.getText() + " присоединился\n";
                    log.append(messageToSave);
                    saveMsg(messageToSave);
                } else {
                    log.append("Подключение не удалось\n");
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (checkServer()) {
                    String messageToSave = tfLogin.getText() + ": " + tfMessage.getText() + "\n";
                    log.append(messageToSave);
                    saveMsg(messageToSave);
                } else {
                    log.append("Не удалось\n");
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                connected = false;
            }
        });

        setLocationRelativeTo(null);
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");

        panelTop.add(tfIpAddress);
        panelTop.add(tfPort);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, NORTH);

        panelButton.add(tfMessage, CENTER);
        panelButton.add(btnSend, EAST);
        add(panelButton, SOUTH);

        log.setEditable(false);
        JScrollPane scrollLog = new JScrollPane(log);
        add(scrollLog);

        setVisible(true);
        updateLogPeriodically();
    }

    public static void main(String[] args) {
        new ClientGUI();
    }

    private boolean checkServer() {
        try {
            File file = new File("D:\\нужное\\GB Education\\Java\\Java\\src\\jdk\\hw1\\serverStatus");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            reader.close();
            if (line.equals("server_condition=true")) {
                return true;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void saveMsg(String message) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\нужное\\GB Education\\Java\\Java\\src\\jdk\\hw1\\repo", true));
            writer.append(message);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateLogPeriodically() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                updateLog();
            }
        }, 0, 100);
    }

    private void updateLog() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:\\нужное\\GB Education\\Java\\Java\\src\\jdk\\hw1\\repo"));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    log.setText(sb.toString());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
