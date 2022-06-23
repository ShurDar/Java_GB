package ru.gb.shurupova.homework2_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
        ServiceClient serviceClient = new ServiceClient();
        System.out.println("Введите сообщение:");

        new Thread(() -> {
            try {
                serviceClient.readMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                serviceClient.sendMessage();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class ServiceClient {
    private final Socket socket;
    private final BufferedReader in;
    private final PrintWriter out;
    private final BufferedReader console;
    private String userMessage, serverMassage;
    String STOP_WORD = "end";

    ServiceClient() throws IOException {
        socket = new Socket("127.01.01.1", 8189);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        console = new BufferedReader(new InputStreamReader(System.in));
    }

    void sendMessage() throws IOException {
        do {
            if ((userMessage = console.readLine()) != null) {
                out.println(userMessage);
            }
            assert userMessage != null;
        } while (!userMessage.equalsIgnoreCase(STOP_WORD));
    }

    void readMessage() throws IOException {
        do {
            if ((serverMassage = in.readLine()) != null) {
                System.out.println(serverMassage);
            }
        } while (!userMessage.equalsIgnoreCase(STOP_WORD));
    }
}