package ru.gb.shurupova.homework2_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
    }

    public static void task1() {
        String[] words = {
                "one", "man", "two", "dog", "pig",
                "sun", "run", "gym", "cat", "leg",
                "pen", "leg", "pig", "cup", "one",
                "lot", "man", "cat", "rat", "gym"
        };

        HashSet<String> unique = new HashSet<>(Arrays.asList(words));
        System.out.println("Список уникальных слов: \n" + unique + "\n");

        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println("Подсчет слов: \n" + map + "\n");
    }

    public static void task2() {
        PhoneBook book = new PhoneBook();

        book.add("Ivanov", "8-903-555-22-99");
        book.add("Petrov", "8-906-444-77-88");
        book.add("Sidorov", "8-905-444-22-11");
        book.add("Ivanov", "8-495-123-55-44");

        System.out.println(book.get("Ivanov"));

    }
}
