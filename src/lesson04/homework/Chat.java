package lesson04.homework;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Главное окно чата */
public class Chat extends JFrame {

    // Эти элементы вынесены в отдельные поля, чтобы к ним был доступ у обработчика
    // отправки сообщения, который реализован в виде отдельного класса
    /** Поле ввода сообщения */
    private final JTextField messageTextField;

    /** Многострочное текстовое поле, в котором будет выводиться чат */
    private final JTextArea chatTextArea;

    /**
     * Конструктор класса
     */
    public Chat() {
        // Настраиваем содержимое окна. Компоновщик оставлен по умолчанию -
        // BorderLayout, чтобы элементы заполнили всё окно
        this.setTitle("Сетевой чат");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создаём многострочное текстовое поле для чата и панель с полосами прокрутки
        chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(
                chatTextArea,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.add(scrollPane);

        // Для поля ввода и кнопки создаём отдельную панель, которой также назначаем компоновщик BorderLayout
        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BorderLayout());

        // Создаём поле ввода, устанавливаем ему обработчик нажатия клавиши Enter
        // и добавляем на панель (добавится в центр и растянется по ширине)
        messageTextField = new JTextField();
        messageTextField.addActionListener(new SendMessageListener());
        messagePanel.add(messageTextField);

        // Создаём кнопку, устанавливаем ей обработчик нажатия и добавляем
        // на панель - на восток, чтобы она прилипала к правому краю.
        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new SendMessageListener());
        messagePanel.add(sendButton, BorderLayout.EAST);

        // Саму эту панель добавляем в южную часть формы,
        // чтобы она прилипала к нижнему краю.
        this.add(messagePanel, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    /**
     * Точка входа в программу
     * @param args Аргументы командной строки
     */
    public static void main(String[] args) {
        new Chat();
    }

    /**
     * Обработчик отправки сообщения - нажатия кнопки
     * "Отправить" или клавиши Enter в текстовом поле
     */
    class SendMessageListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            chatTextArea.append(messageTextField.getText() + "\n");
            messageTextField.setText("");
        }
    }
}
