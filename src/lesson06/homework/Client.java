package lesson06.homework;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        startTextClient();
        //startObjectClient();
    }

    private static void startTextClient() {

        // Создаём сокет для подключения к серверу, указываем адрес и порт
        try (Socket socket  = new Socket("localhost", 8180);

             // Потоки для переписки клиента с сервером
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream());
             Scanner sc = new Scanner(System.in)){

            // Создаём и запускаем отдельный поток, который будет принимать сообщения от сервера и выводить их в консоль
            Thread serverReader = new Thread(() -> {
                String serverMessage = "";
                try {
                    while(!socket.isClosed()) {
                        serverMessage = in.readLine();
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            serverReader.start();

            // Отправляем сообщения серверу до тех пор, пока введённое сообщение не будет словом "stop"
            String myMessage = "";
            do{
                //serverMessage = in.readLine();
                //System.out.println(serverMessage);
                myMessage = sc.nextLine();
                out.println(myMessage);
                out.flush();
            }while(!myMessage.equalsIgnoreCase("stop"));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
