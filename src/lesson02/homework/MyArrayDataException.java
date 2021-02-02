package lesson02.homework;

/** Исключение, возникающее, если не удалось преобразовать какой-либо элемент массива в целое число */
public class MyArrayDataException extends Exception {

    /**
     * Инициализирует экземпляр класса
     * @param message Сообщение об ошибке
     */
    public MyArrayDataException(String message) {
        super(message);
    }
}
