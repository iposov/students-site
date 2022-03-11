package ru.spbu.arts.lambdas;

import java.util.*;

class SortExamples {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>(
                List.of(40, 10, 30, 50, 24)
        ); // создаём ArrayList на основе другого списка

        list1.sort((i1, i2) -> {
            if (i1 < i2)
                return -1;
            if (i1 > i2)
                return 1;
            return 0; // i1 == i2
        });

        System.out.println("Отсортированный список: " + list1);

        //несколько способов сделать ровно то же самое
        //(не обязательно понимать все версии исправления)
        list1.sort((i1, i2) -> i1.compareTo(i2));
        list1.sort((i1, i2) -> Integer.compare(i1, i2)); //
        list1.sort(Integer::compareTo); //
        list1.sort(Integer::compare); //
        //естественный порядок для чисел — по возврастанию
        list1.sort(Comparator.naturalOrder());

        //класс Collections есть много полезных вспомогательных функций
        //для работы с коллекциями:
        Collections.sort(list1); //естественный порядок
        //с укзанием компаратора
        Collections.sort(list1, (i1, i2) -> {
            if (i1 < i2)
                return -1;
            if (i1 > i2)
                return 1;
            return 0; // i1 == i2
        });

        Collections.sort(list1, (i1, i2) -> i1 - i2);

        //аналогично с массивами
        int[] a = {10, 50, 40, 20, 60, 15};
        Arrays.sort(a); //естественный порядок
        //компаратор только для массивов объектов. Надо Integer[]
        /*Arrays.sort(a, (i1, i2) -> {
            if (i1 < i2)
                return -1;
            if (i1 > i2)
                return 1;
            return 0; // i1 == i2
        });*/

        //Как все-таки отсортировать строки по длине:

        List<String> words = new ArrayList<>(
                List.of("cat", "ha", "banana", "house")
        );
        //естественный порядок
        Collections.sort(words);
        System.out.println(words);

        words.sort((s1, s2) -> {
            if (s1.length() > s2.length())
                return 1;
            if (s1.length() < s2.length())
                return -1;
            return 0;
        });
        words.sort((s1, s2) -> s1.length() - s2.length());
        //хитро. Используйте только если понимаете:
        words.sort(Comparator.comparingInt(String::length));

        System.out.println(words);
    }
}
