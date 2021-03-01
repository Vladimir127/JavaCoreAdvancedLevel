/**
 * Класс, отвечающий за пользовательский интерфейс клиента
 */
public class ClientGUI {
    public ClientGUI() {
        ClientNetwork clientNetwork = new ClientNetwork();
        clientNetwork.connect();
    }
}
