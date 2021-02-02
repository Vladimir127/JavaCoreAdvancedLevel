package lesson02.homework;

import lesson02.homework.exceptions.MySizeArrayException;

public class Main {
    public static void main(String[] args) {

        // Инициализируем массивы: массив с неправильным количеством столбцов
        String[][] array1 = {{"A", "B", "C"}, {"D", "E", "F"}, {"G", "H", "I"}, {"J", "K", "L"}};

        // Массив с неправильным количеством строк
        String[][] array2 = {{"47", "74", "52", "13"}, {"25", "36", "78", "91"}, {"77", "10", "98", "50"}};

        // Массив со словом вместо числа
        String[][] array3 = {{"1", "2", "3", "Четыре"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        // Правильный массив
        String[][] array4 = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "16"}};

        // Пытаемся обработать эти четыре массива
        printAndProcessArray(array1);
        printAndProcessArray(array2);
        printAndProcessArray(array3);
        printAndProcessArray(array4);
    }

    /**
     * Отображает массив в консоли и пытается вычислить его сумму, вызвав метод {@link #stringArraySum(String[][])}.
     * Вычисленную сумму выводит в консоль. Если это не удаётся, выводит в консоль сообщение об ошибке.
     * @param array Двумерный массив для обработки
     */
    private static void printAndProcessArray(String[][] array){
        System.out.println("Массив:");
        printMatrix(array);
        System.out.println("Обработка массива...");

        try {
            System.out.println("Сумма элементов равна " + stringArraySum(array));
        } catch (MySizeArrayException | MyArrayDataException e) {
            // Сообщение об ошибке выводим обычным способом, так как если вызвать метод e.printStackTrace(),
            // информация почему-то выводится не тогда, когда нужно, а вперемешку с остальными сообщениями.
            // Например, могут отобразиться все четыре матрицы, а затем - три исключения подряд.
            // А при отладке у меня вообще был случай, когда исключение выводилось посреди вывода следующей матрицы.

            //e.printStackTrace();
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            System.out.println();
        }
    }

    /**
     * Выводит на консоль двумерный массив
     * @param array Двумерный массив для вывода
     */
    private static void printMatrix(String[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // Используем форматированный вывод строки для красоты
                System.out.printf("%2s ", array[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Принимает на вход двумерный массив размера 4*4, содержащий числа в виде строк, и вычисляет сумму этих чисел.
     * @param matrix Двумерный массив размера 4*4, содержащий числа в виде строк
     * @return Сумма элементов двумерного массива
     * @throws MySizeArrayException Если размер массива отличается от размера 4*4
     * @throws MyArrayDataException Если не удалось преобразовать какой-либо элемент в число
     */
    private static int stringArraySum(String[][] matrix) throws MySizeArrayException, MyArrayDataException {
        if (matrix.length != 4){
            throw new MySizeArrayException("Неверно задан размер массива");
        }

        if (matrix[0].length != 4){
            throw new MySizeArrayException("Неверно задан размер массива");
        }

        int sum = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    int value = Integer.parseInt(matrix[i][j]);
                    sum += value;
                } catch (NumberFormatException e){
                    throw new MyArrayDataException("Неверный формат данных в ячейке [" + i + "][" + j + "]");
                }
            }
        }

        return sum;
    }
}
