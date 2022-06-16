package ru.gb.shurupova.homework2_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket socket; // и клиент и сервер общаются по socket
    private DataInputStream in;  // DataInputStream для чтения сообщений
    private DataOutputStream out; // DataOutputStream для отсылки сообщений

    public static void main(String[] args) {
        new EchoClient().start();  // создаем нового клиента new EchoClient() и вызываем метод .start()
    }

    private void start() {
        try {
            openConnection();  // метод, кот. открое соедиенение с сервером
            Scanner scanner = new Scanner(System.in); // завели переменную сканер
            System.out.println("Введите сообщение:");
            while (true) {
                sendMessage(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // метод, который шлет сообщения введеные в консоль клиента
    private void sendMessage(String message) {
        try {
            out.writeUTF(message); // с помощью метода .writeUTF()
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openConnection() throws IOException {
        socket = new Socket("127.01.01.1", 8189); // инициализируем серверный сокет
        in = new DataInputStream(socket.getInputStream()); // инициализируем класс для чтения сообщений
        out = new DataOutputStream(socket.getOutputStream()); // инициализируем класс для записи сообщений

        new Thread(() -> {
            try {
                while (true) {
                    String message = in.readUTF(); // блокирующий метод .readUTF() ожидает сообщение от сервера
                    if ("/end".equalsIgnoreCase(message)) {
                        break;
                    }
                    System.out.println("Сообщение от сервера: " + message); // принимает эхо от сервера и выводит в свою консоль
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                closeConnection(); // закроет соединение, когда произойдет break
            }
        }).start(); // запуск Thread
    }

    private void closeConnection() {
        // закрываем потоки ввода
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // закрываем потоки вывода
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // закрываем socket
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
