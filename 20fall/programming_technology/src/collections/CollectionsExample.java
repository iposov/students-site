package collections;

import java.util.*;

public class CollectionsExample {

    public static void main(String[] args) {
        // создадим список
        List<String> a = new ArrayList<>();
        a.add("aaa10");
        a.add("bbb20");
        a.add("ccc30");
        System.out.println(a);
        a.remove("aaa10");
        System.out.println(a);
        a.remove("aaa10"); // Ctrl + Q quick help
        System.out.println(a);
        a.remove(1); // индексы всегда с 0
        System.out.println(a);

        Set<String> s1 = new HashSet<>();
        s1.add("abc");
        s1.add("xyz");
        s1.add("pqr");
        System.out.println(s1); //pqr, abc, xyz

        Set<String> s2 = new LinkedHashSet<>();
        s2.add("abc");
        s2.add("xyz");
        s2.add("pqr");
        System.out.println(s2); //abc, xyz, pqr

        Set<String> s3 = new TreeSet<>();
        s3.add("abc");
        s3.add("xyz");
        s3.add("pqr");
        System.out.println(s3); //abc, pqr, xyz

        //пример перебора элементов множества
        for (String word : s3) // постоянно использовали с массивами
            System.out.println(word);

        List<Integer> ints = new ArrayList<>();
        ints.add(10); //в add надо бы писать тип Integer, а у нас int
        ints.add(20); //10, 20 и 30 автоматически заворачиваются в Integer
        ints.add(30);

        int x = ints.get(2); //значение по второму индексу имеет тип Integer
                             //но происходит автоматическое разворачивание.
        System.out.println("x = " + x);

        //Единственный пример (!) когда не может сработать авторазворачивание
        Integer ii = null; //любой объектный тип имеет значение null. "нет числа"
        int y = ii; //возникнет NullPointerException
        System.out.println("y = " + y);
    }
}
