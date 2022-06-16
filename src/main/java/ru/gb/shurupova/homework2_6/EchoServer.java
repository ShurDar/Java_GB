package ru.gb.shurupova.homework2_6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {

        new Thread(() -> {

            try (ServerSocket serverSocket = new ServerSocket(8189)) { // слушаем порт
                System.out.println("Ждем подключения клиента...");
                Socket socket = serverSocket.accept(); // socket по которому будем общается, метод accept() блокирующий, он ждет, пока клиент подключится
                System.out.println("Клиент подключился");

                // стримы для ввода и вывода сообщений
                DataInputStream in = new DataInputStream(socket.getInputStream()); // спомощью него бдем читать входящие сообщения
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // с помощью него будем сообщения отсылать

                // читать сообщения будем бесконечным циклом
                while (true) {

                    String message = in.readUTF(); // чтобы прочитать сообщение, вызываем метод .readUTF(), это будет то сообщение, которое прислал клиент

                    // добавляем исключение для выхода из бесконечного цикла
                    if ("/end".equalsIgnoreCase(message)) { // если получим такое служебное сообщение
                        out.writeUTF("/end"); // отошлем его же клиенту
                        break;  // и выйдем из цикла
                    }

                    System.out.println("Сообщение от клиента: " + message); // дублирует сообщение клиента в свою консоль
                    out.writeUTF("[echo]" + message); // зеркалит сообщение клиента в консоль клиента


                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                    String messageConsole = console.readLine();
                    out.writeUTF(messageConsole);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}


