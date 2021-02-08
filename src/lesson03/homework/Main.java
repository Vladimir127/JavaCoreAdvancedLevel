package lesson03.homework;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1. Набор слов");

        // Создаём список слов, среди которых есть повторяющиеся.
        // В список входят все существительные из текста домашнего задания
        String[] words = {"массив", "набор", "слово", "список", "слово", "массив", "раз",
                "слово", "класс", "справочник", "список", "фамилия", "номер", "справочник",
                "метод", "запись", "метод", "номер", "телефон", "фамилия", "запрос"};

        // Создаём на его основе arrayList и выводим его на экран
        ArrayList<String> arrayListWords = new ArrayList<>(Arrays.asList(words));
        System.out.println("Исходный список слов: " + arrayListWords);

        // Создаём список уникальных слов, отсортированных по алфавиту
        Set<String> treeSet = new TreeSet<>(arrayListWords);
        System.out.println("Список уникальных слов: " + treeSet);

        // Создаём TreeMap для подсчёта количества вхождений каждого слова
        Map<String, Integer> treeMap = new TreeMap<>();
        for (String word: arrayListWords){
            if (treeMap.containsKey(word)){
                int value = treeMap.get(word);
                treeMap.put(word, ++value);
            } else {
                treeMap.put(word, 1);
            }
        }

        System.out.println("Количество вхождений каждого слова: ");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

        System.out.println("\nЗадание 2. Телефонный справочник");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "8-956-741-23-56");
        phoneBook.add("Петров", "8-917-961-456-16");
        phoneBook.add("Петров", "8-917-961-456-17");
        phoneBook.add("Сидоров", "8-928-841-14-75");
        phoneBook.add("Сидоров", "8-928-841-14-76");
        phoneBook.add("Сидоров", "8-928-841-14-77");

        System.out.println("Поиск по телефонному справочнику");
        String surname = "Иванов";
        System.out.println(surname + ": " + phoneBook.get(surname));

        surname = "Петров";
        System.out.println(surname + ": " + phoneBook.get(surname));

        surname = "Степанов";
        System.out.println(surname + ": " + phoneBook.get(surname));
    }
}
