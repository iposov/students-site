package inheritance.interfaces2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdasExamples {

    public static void main(String[] args) {
        //сортировка
        Integer[] a = {10, 22, 44, 12, 53, 56, 23};

        //сортировка массива есть в классе Arrays.
        //если не указывать, как делать сортировку, то
        //используется естественный порядок объектов,
        //т.е. числа, например, сортируются по возрастанию:
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        //хочу отсортировать числа по увеличению последней цифры.
        //второй аргумент — компаратор. Сравниватель.

        //вариант реализации интерфейса анонимным классом:
        Arrays.sort(a, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //вычисляем последние цифры
                int d1 = o1 % 10;
                int d2 = o2 % 10;
                if (d1 < d2)
                    return -1; //отрицательное для меньше
                else if (d1 > d2)
                    return 1;
                else
                    return 0;

                //return d1 - d2; получится также
                //return Integer.compare(d1, d2)
            }
        });

        System.out.println(Arrays.toString(a));

        //лямбда выражением:
        Arrays.sort(a, (i1, i2) -> {
            int d1 = i1 % 10;
            int d2 = i2 % 10;
            return d1 - d2;
        });
        // или. Здесь можно убрать {}, если метод
        // состоит только из return
        Arrays.sort(a, (i1, i2) -> i1 % 10 - i2 % 10);

        System.out.println(Arrays.toString(a));

        //куда смотреть дальше: default методы в интерфейсах,
        //приватные методы в интерфейсах. Поля в интерфейсах.
    }

}
