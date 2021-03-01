import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.atomic.AtomicInteger;

/** Обработчик клиентов - класс, который содержит информацию о клиенте, необходимую серверу для работы с этим клиентом */
public class ClientHandler {
    private String nickname;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Server server;

    public ClientHandler(Integer numero, Server server, Socket socket) {
        try {
            // Поскольку этот обработчик работает на сервере и рассылает остальным клиентам то, что получил от одного из клиентов, здесь также необходима ссылка на сам сервер. то нужно для того, чтобы при получении сообщения от своего клиента этот объект обратился к серверу и попросил его разослать сообщение всем остальным клиентам.
            this.server = server;

            // Получаем сокет из входного параметра и на основании этого сокета инициализируем входящий и исходящий потоки
            this.socket = socket;
            this.in = new DataInputStream(socket.getInputStream());
            this.out = new DataOutputStream(socket.getOutputStream());
            this.nickname = "Client "+numero;
            new Thread(() -> {
                server.subscribe(this);

                // Начинаем читать сообщения
                boolean continueChat = true;
                while (continueChat) {
                    String msg = null;
                    try {
                        msg = in.readUTF();

                        // Если сообщение начинается со слеша, то это команда. В этом блоке будет обработка команд
                        if(msg.startsWith("/")) {
                            if(msg.equalsIgnoreCase("/end")) {
                                continueChat = false;
                            }
                        }
                        else {
                            // Рассылаем сообщение всем клиентам, вызывая метод broadcastMessage на сервере
                            server.broadcastMessage(nickname+" : "+msg);
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
                        disconnect();
                    }

                }
            }).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Отправляет сообщение данному клиенту
     * @param message Сообщению
     */
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNickname() {
        return nickname;
    }

    /**
     * Выполняет отключение клиента от сервера
     */
    public void disconnect() {
        // Удаляемся из списка клиентов сервера
        server.unsubscribe(this);

        // По отдельности закрываем потоки, чтобы в случае возникновения ошибки при закрытии одного потока можно было продолжить закрывать остальные.
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
