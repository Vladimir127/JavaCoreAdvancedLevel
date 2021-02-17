package lesson05.homework;

public class Main {
    static final int size = 10000000;
    static final int h = size / 2;

    public static void main(String[] args) {
        System.out.println("Метод 1 (последовательное вычисление)");
        method1();
        System.out.println("Метод 2 (разбиение на два массива и вычисление в двух потоках)");
        method2();
    }

    /**
     * Обрабатывает массив последовательно, без многопоточности
     */
    public static void method1(){
        // Заполняем массив и инициализируем его единицами
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        // Фиксируем время начала
        long a = System.currentTimeMillis();

        // Вычисляем новое значение для каждой ячейки массива
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        // Фиксируем время окончания
        long b = System.currentTimeMillis();
        long time = b - a;
        System.out.println("Время выполнения: " + time + " мс");
    }

    /**
     * Обрабатывает массив, разбивая его на два массива, с помощью двух потоков
     */
    public static void method2(){
        // Заполняем массив и инициализируем его единицами
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        // Фиксируем время начала
        long a = System.currentTimeMillis();

        // Разделяем исходный массив на два массива a1 и a2
        float[] a1 = new float[h], a2 = new float[h];
        System.arraycopy(arr, 0, a1, 0, h);
        System.arraycopy(arr, h, a2, 0, h);

        // Для вычисления значений элементов в двух потоках используем два объекта Thread,
        // куда в качестве объекта Runnable передаём лямбда-выражение
        Thread thread1 = new Thread(() -> {
            // Вычисляем новое значение для каждой ячейки массива a1
            for (int i = 0; i < h; i++) {
                a1[i] = (float)(a1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        thread1.start();

        int offset = h;
        Thread thread2 = new Thread(() -> {
            // Вычисляем новое значение для каждой ячейки массива a2
            for (int i = 0; i < h; i++) {
                a2[i] = (float) (a2[i] * Math.sin(0.2f + (i + offset) / 5) * Math.cos(0.2f + (i + offset) / 5) * Math.cos(0.4f + (i + offset) / 2));
            }
        });
        thread2.start();

        try {
            // Дожидаемся, пока оба потока завершатся
            thread1.join();
            thread2.join();

            // Склеиваем массивы обратно
            System.arraycopy(a1, 0, arr, 0, h);
            System.arraycopy(a2, 0, arr, h, h);

            // Фиксируем время окончания
            long b = System.currentTimeMillis();
            long time = b - a;
            System.out.println("Время выполнения: " + time + " мс");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
