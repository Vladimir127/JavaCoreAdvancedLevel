package lesson03.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

/** Телефонный справочник */
public class PhoneBook {
    private TreeMap<String, ArrayList<String>> treeMap;

    public PhoneBook() {
        treeMap = new TreeMap<>();
    }

    /**
     * Добавляет запись в телефонный справочник
     * @param surname Фамилия
     * @param number Телефонный номер
     */
    public void add(String surname, String number){
        if (treeMap.containsKey(surname)){
            treeMap.get(surname).add(number);
        } else {
            treeMap.put(surname, new ArrayList<String>(Arrays.asList(number)));
        }
    }

    /**
     * Возвращает номера телефонов по фамилии
     * @param surname Фамилия
     * @return Список телефонных номеров, найденных по этой фамилии
     */
    public ArrayList<String> get(String surname){
        return treeMap.get(surname);
    }
}
