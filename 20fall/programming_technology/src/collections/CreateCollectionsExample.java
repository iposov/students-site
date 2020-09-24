package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateCollectionsExample {

    public static void main(String[] args) {
        List<String> list1 = List.of(); // пустой список
        List<String> list2 = List.of("abc", "xyz"); // из двух элементов
        // можно создавать список из любого количества элементов

        //из массива
        String[] list3array = {"aaa", "bbb", "ccc"};
        List<String> list3 = List.of(list3array);
        //это список из трех элементов. Как сделать список List<String[]> из одного?
        //подумать

        // создать массив и превратить в список. Это эквивалентно List.of("abc", "cba")
        List<String> list4 = List.of(new String[]{"abc", "cba"});

        // пример со звездочкой. Здесь как раз получился List<int[]> из одного эл-та
        List<int[]> ints = List.of(new int[]{10, 20});

        List<String> list5 = List.copyOf(list4); // копия любой коллекции в виде списка
        //изменения list4 не будут видны в list5

        //Важная особенность! Все созданные такими способами списки (!)неизменяемые(!)
        System.out.println(list3);
        //list3.add("zzz"); //ошбика UnsupportedOperationException, неподдерживаемая операция

        //чтобы создать изменяемый список, можно делать так:
        List<String> list6 = new ArrayList<>();
        list6.add("element 1");
        list6.add("element 2");
        list6.add("element 3");

        //или так
        List<String> list7 = new ArrayList<>(List.of("element 1", "element 2", "element 3"));
        // при создании ArrayList в конструкторе можно указать коллекцию, которую
        // он в себя скопирует

        // Аналогично можно создавать множества. Они тоже будут неизменяемые:
        Set<String> set1 = Set.of("abc", "xyz");

        //изменяемое множество:
        Set<String> set2 = new HashSet<>(Set.of("abc", "xyz"));
    }

}
