package ru.spbu.arts.collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapsExamples {

    public static void main(String[] args) {
        Map<String, Integer> love = Map.of("cat", 100, "dog", 100, "coffee", 10, "tea", 40);

        System.out.println(love);

        Map<String, Integer> love1 = new HashMap<>();
        Map<String, Integer> love2 = new LinkedHashMap<>();
        Map<String, Integer> love3 = new TreeMap<>();

        love1.put("cat", 100);
        love1.put("dog", 100);
        love1.put("coffee", 10);
        love1.put("tee", 40);

        System.out.println(love1);

        System.out.println(love1.get("cat")); // ? 100
        System.out.println(love1.get("aardvark")); // ? null

        // получить значение по ключу, или значение по умолчанию, если ключа нет
        System.out.println(love1.getOrDefault("dog", 0));  // 100
        System.out.println(love1.getOrDefault("aardvark", 0));  // 0

        love1.remove("dog"); // убрать ключ собака
        System.out.println(love1);

        // способ 1, перебираем ключи
        for (String key : love.keySet())
            System.out.println(key + " -> " + love.get(key));

        // способ 2, перебираем записи (ключ, значение)
        for (Map.Entry<String, Integer> entry : love.entrySet())
            //entry.getKey() и entry.getValue() - ключ и значение
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        // вспоминаем, что в java локальные переменные можно вводить через var

        for (var entry : love.entrySet())
            //entry.getKey() и entry.getValue() - ключ и значение
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        //способ 3
        love.forEach((key, value) -> {
            // в фигурных скобках пишем, как будто у нас функция с аргументами
            // (String key, int value)
            System.out.println(key + " -> " + value);
        });

        // если в фигурных скобках одно действие, их можно опустить:
        love.forEach((key, value) -> System.out.println(key + " -> " + value));
    }

}
