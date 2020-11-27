package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Lambdas {

    public static void main(String[] args) {
        //Функции для обработки коллекций, которые принимают лямбда выражения

        List<Integer> l1 = new ArrayList<>(List.of(10, 20, 30, 40, 50));

        //Удалить, если выполнено условие
        l1.removeIf(x -> x > 30); //убрать элемент, если подходит под условие

        System.out.println(l1);

        Predicate<Integer> greaterThan30 = x -> x > 30;
        l1.removeIf(greaterThan30);

        l1.forEach(x -> System.out.println(x)); //для каждого элемента выполнить.
        List<Integer> l2 = new ArrayList<>();
        l1.forEach(x -> l2.add(x)); //добавить все элементы в список l2
        System.out.println("l2 = " + l2);

        Map<String, String> m = Map.of("cat", "кот", "dog", "собака");
        m.forEach((key, value) -> System.out.println(
                "слово " + key + "переводится как " + value
        ));
        // перебор ассоциативного массива удобен через forEach
        // а как было бы с циклом?
        for (var e : m.entrySet())
            System.out.println(
                    "слово " + e.getKey() + "переводится как " + e.getValue()
            );

        //разбор задачи про то, как превратить строку "abcaab" в
        Map<Character, List<Integer>> ind = new HashMap<>();

        // a -> [0, 3, 4]
        // b -> [1, 5]
        // c -> 2
        String text = "abcaab";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // getOrDefault берет значение по ключу c, но если значения
            // нет, возвращает второй аргумент, здесь — пустой список
            List<Integer> cInd = ind.getOrDefault(c, new ArrayList<>());
            cInd.add(i); // добавляем индекс в список
            ind.put(c, cInd); //указываем, что это список индексов для c
        }
        System.out.println(ind);

        // недостатки. Новый пустой список создается всегда, даже если он не
        // понадобится.
        // Второй недостаток — ind.put нужна не всегда, только если
        // был создан новый пустой список.
        ind.clear();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // computeIfAbsent берет значение по ключу c, но если значения
            // нет, вычислияет второй аргумент и записывает результат вычисления
            // как новое значение для c.
            List<Integer> cInd = ind.computeIfAbsent(c, key -> new ArrayList<>());
            cInd.add(i);
        }
        System.out.println(ind);
        // оба недостатка исчезли. Теперь функция (лямбда выражение), вычисляется
        // только если по ключу нет значения. Нет лишних пустых списков.
        // Теперь не нужно делать .put(cInd)
    }
}
