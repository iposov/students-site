package collections;

import java.util.HashMap;
import java.util.Map;

public class MapsExample {

    public static void main(String[] args) {
        /*
        В python
        a = {}
        a['cat'] = 10 // у нас есть 10 котов
        a['dog'] = 3
        a['apple'] = 40
        print(a['cat']) // можно узнать, сколько
        a['cat'] = a['cat'] + 1
        for something, count in a.items():
            print(f`we have {count} {something}`)
        // результат:
        we have 11 cat
        we have 3 dog
        we have 40 apples
         */

        //String ключи, Integer значения
        Map<String, Integer> a = new HashMap<>();
        //еще бывает LinkedHashMap, TreeMap. Разница полностью эквивалентна
        //различию HashSet, LinkedHashSet, TreeSet. Имеется в виду порядок ключей.

        a.put("cat", 10); // a["cat"] = 10, указваем ключ и новое значение
        a.put("dog", 3);
        a.put("apple", 40);
        System.out.println(a.get("cat")); // это тоже a["cat"] только чтобы узнать значение
        //a['cat'] = a['cat'] + 1
        // ... get put
        a.put("cat", a.get("get") + 1); // подумайте, где происходят авторазворачивания
                                        // и автозаворачивания

        // a.keySet - это множество всех ключей
        for (String something : a.keySet()) // перебор ключей
            System.out.println("We have " + a.get(something) + " " + something);

        //entry это пара из ключа и значения
        //три пары entry1 = (cat 11) entry2 = (dog 3) enter 3 = (apple 40)
        for (Map.Entry<String, Integer> e : a.entrySet())
            System.out.println("We have " + e.getValue() + " " + e.getKey());

        // еще есть a.values() это коллекция всех значений, т.е. 11, 3, 40.
        // ее можно только перечислить. А keySet и entrySet это множества.

        // var намного короче, чем тип Map.Entry
        for (var e : a.entrySet())
            System.out.println("We have " + e.getValue() + " " + e.getKey());

        // последний вариант. С лямбда выражениями.
        a.forEach((something, count) -> { // стрелочка это - >
            System.out.println("We have " + count + " " + something);
        }); //в фигурных скобках блок с операторами.
    }
}
