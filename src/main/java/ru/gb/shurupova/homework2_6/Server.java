package ru.gb.shurupova.homework2_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        ServiceServer service = new ServiceServer();
        service.start();

        new Thread(service::sendMessage).start();

        new Thread(service::writeToConsole).start();

    }
}

class ServiceServer {
    BufferedReader in;
    PrintWriter out;
    String STOP_WORD = "end";

    void start() {
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Ждем подключения клиента...");
            Socket socket = serverSocket.accept();
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            System.out.println("Клиент подключился");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void sendMessage() {
        while (true) {
            String message = null;
            try {
                message = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (STOP_WORD.equalsIgnoreCase(message)) {
                out.println(STOP_WORD);
                break;
            }
            System.out.println("Сообщение от клиента: " + message);
            out.println("echo: " + message);
        }
    }

    void writeToConsole() {
        while (true) {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String msg = null;

            try {
                msg = console.readLine();
                System.out.println("Сообщение от сервера: " + msg);
                out.println("Сообщение от сервера: " + msg);

            } catch (IOException e) {
                e.printStackTrace();
            }

            if (STOP_WORD.equalsIgnoreCase(msg)) {
                break;
            }
        }
    }
}


