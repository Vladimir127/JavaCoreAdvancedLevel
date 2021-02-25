package lesson06.homework;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String ... args) {
        startTextServer();
    }

    private static void startTextServer() {

        // Создаём серверный сокет, определяем ему порт
        try(ServerSocket serverSocket = new ServerSocket(8180)){
            System.out.println("Server is listening");

            // Соединение с клиентом начинается после вызова метода accept(), который возвращает клиентский сокет
            try(Socket socket = serverSocket.accept();

                // Потоки для переписки клиента с сервером
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                Scanner sc = new Scanner(System.in)){

                // Выводим сообщение, что клиент подключился, а клиенту отправляем приветственное сообщение
                System.out.println("Client is connected");
                out.println("Hello client");
                out.flush();

                // Создаём и запускаем отдельный поток, который будет принимать сообщения от клиента и выводить их в консоль
                Thread clientReader = new Thread(() -> {
                    String clientMessage = "";
                    try {
                        while(!socket.isClosed()) {
                            clientMessage = in.readLine();
                            System.out.println(clientMessage);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
                clientReader.start();

                // Отправляем сообщения серверу до тех пор, пока введённое сообщение не будет словом "stop"
                String myMessage = "";
                while(true){
                    myMessage = sc.nextLine();
                    out.println(myMessage);
                    out.flush();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
