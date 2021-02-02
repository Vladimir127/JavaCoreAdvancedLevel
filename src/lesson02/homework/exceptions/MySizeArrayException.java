package lesson02.homework.exceptions;

/** Исключение, возникающее при неверно заданном размере массива */
public class MySizeArrayException extends Exception {

    /**
     * Инициализирует экземпляр класса
     * @param message Сообщение об ошибке
     */
    public MySizeArrayException(String message) {
        super(message);
    }
}
