import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Класс, отвечающий за взаимодействие клиента и сервера, симметричный классу ClientHandler на стороне сервера
 */
public class ClientNetwork {
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public void connect() {
        try {
            // Получаем сокет и потоки
            socket = new Socket("localhost", 8189);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            // Отдельный поток для чтения сообщений от сервера
            new Thread(() -> {
                boolean goOn = true;
                try {
                    while(goOn) {
                        String msg = in.readUTF();
                        if(msg.equalsIgnoreCase("/end")){
                            goOn = false;
                        }
                        else if(msg.startsWith("/clients ")) {
                            // rassilka imeyushihsya klientov
                        }
                        else {
                            // vivod soobsheniya
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Отправляет сообщение на сервер
     * @param msg Сообщение
     * @return Истина, если сообщение успешно отправлено, иначе - ложь
     */
    public boolean sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Закрывает соединение с сервером
     */
    public void closeConnection () {
        try {
            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
