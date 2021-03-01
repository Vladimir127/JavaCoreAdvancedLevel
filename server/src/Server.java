import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    /** Список клиентов, подключённых к серверу */
    private List<ClientHandler> clients;

    /** Номер клиента. AtomicInteger - это защищённый класс, который блокирует значение для записи, когда к нему обращается поток. Используется для того, чтобы клиенты не получсли одинаковые номера. */
    private AtomicInteger numero = new AtomicInteger(1);

    public Server() {
        // Инициализируем список клиентов
        this.clients = new ArrayList<>();

        // Создаём серверный сокет и ждём подключения клиентов
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Server is listening on 8189");

            // Поскольку количество клиентов не ограничено, цикл бесконечный
            while(true) {
                // Получили сокет, приняв клиента
                Socket socket = serverSocket.accept();
                new ClientHandler(numero.getAndIncrement(), this, socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Рассылает сообщение всем клиентам
     * @param message Сообщение
     */
    public void broadcastMessage(String message) {
        for(ClientHandler client: clients) {
            client.sendMessage(message);
        }
    }

    /**
     * Рассылает список клиентов
     */
    public void broadcastClientsList() {
        // Размер строки = примерная длина имени (15), умноженная на количество клиентов
        StringBuilder sb = new StringBuilder(15 * clients.size());

        // Первым делом добавляем к строке "служебное слово", чтобы программа-клиент понимала, что пришёл именно список клиентов, а не сообщение
        sb.append("/clients ");

        // Добавляем клиентов
        for(ClientHandler o: clients){
            sb.append(o.getNickname()).append(" ");
        }
        String out = sb.toString();

        // Рассылаем
        broadcastMessage(out);
    }

    /**
     * Добавляет клиента в список
     * @param client Клиент
     */
    public void subscribe(ClientHandler client) {
        clients.add(client);
        broadcastClientsList();
    }

    /**
     * Удаляет клиента из списка
     * @param client Клиент
     */
    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
        broadcastClientsList();
    }
}
