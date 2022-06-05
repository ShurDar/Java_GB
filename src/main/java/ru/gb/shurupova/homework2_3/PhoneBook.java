package ru.gb.shurupova.homework2_3;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private HashMap<String, HashSet<String>> map;

    public PhoneBook() {
        this.map = new HashMap<>();
    }

    public void add(String name, String phone) {
        HashSet<String> number;

        if (map.containsKey(name)) {
            number = map.get(name);
        } else {
            number = new HashSet<>();
        }
        number.add(phone);
        map.put(name, number);
    }

    HashSet<String> get(String name) {
        System.out.print(name + ": ");
        return map.get(name);
    }
}
