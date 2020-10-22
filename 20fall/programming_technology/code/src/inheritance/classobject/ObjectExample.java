package inheritance.classobject;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ObjectExample {

    public static void main(String[] args) {
        //Класс Object
        //Вершина иерархии наследования всех классов в Java. Любой класс
        //прямо или косвенно унаследован от Object.
        // public class C {  эквивалентно public class C extends Object {
        //Зачем. 1. Переменная типа Object может хранить значение любого типа
        //(кроме 8 базовых: int, double, ...)
        Object o1 = new Scanner("hello world");
        Object o2 = List.of("anbc", "dasfd");
        Object o3 = "abc"; //тип String extends Object
        Object o4 = new int[]{10, 20, 30}; // массивы тоже объекты
        Object o5 = null; //это значение подходит для любого объектного (не базового) типа

        //Получается, что List<Object> или Object[] могут хранить всё что угодно.
        //В старых Java так и было, т.е. List это аналогично List<Object>

        //Зачем 2. В Object есть некоторое количество методов. Получается, что эти
        //методы есть вообще у всех объектов в Java.

        Object o = new Object(); // просто пустой объект
        //toString() это текстовое описание содержимого объекта.
        //в первую очередь нужно только для отладки, очень редко
        //нужно показывать текст из toString() пользователю.
        //По умолчанию пишется имя класса, @, потом хэш код объекта
        //но это можно переопределить, например, это переопределено у списков.
        System.out.println(o.toString());
        System.out.println(List.of("abc", "xyz").toString());
        //println и конкатенация строк вызывают toString по умолчанию
        System.out.println(List.of("abc", "xyz")); //аналогично
        System.out.println("list = " + List.of("abc", "xyz")); // + вызвал toString

        // Когда вы делаете свой класс, удобно переопределить toString(), чтобы
        // было проще отлаживать программу, объекты вашего класса можно будет
        // выводить на экран.

        //o1.notify и o1.wait это для многопоточного программирования. Один поток
        //ждет, другой уведомляет о завершении операции.

        //o1.getClass() см. позже, рефлексия, получаем доступ к классу объекта.
        System.out.println("abc".getClass()); //class java.lang.String

        //объект.equals(другой объект) сравнение содержимого объектов
        //строки можно сравнивать только через equals
        String s1 = "abc";
        String s2 = "xabc".substring(1); //тоже "abc"
        System.out.println(s1.equals(s2)); //true, содержимое одинаково
        System.out.println(s1 == s2);

        // наш класс, см. ниже
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);

        System.out.println("p1 = " + p1);

        // false это два разных объекта
        System.out.println("сравниваем точки через == " + (p1 == p2));
        // хочется true, потому что обе точки (10, 20)
        System.out.println("сравниваем точки через equals " + p1.equals(p2));

        // int h = o.hashCode Хэш объекта.
        // Это целое число, "шифрующее" содержимое объекта.
        // Даже для больших объектов, содержащих много данных, хэш это всего лишь
        // одно число.
        // одинаковые объекты (в смысле equals) должны иметь одинаковый хэш
        // а разные объекты, даже те, которые только чуть-чуть различаются,
        // желательно должны иметь разный хэш.

        // Зачем. Принцип. Если вы увидели, что хэши разные у двух объектов,
        // значит объекты точно разные. Если одинаковые, то почти наверняка
        // объекты тоже одинаковые.
        // hash важен для HashMap: в нем
        // a.put("abc", "qqqq")          a["abc"] = "qqqq"
        // "abc" превращается в число, например, 4564
        // внутри HashMap есть массив, допустим, из 16 элементов.
        // записываем "qqqq" в ячейку 4564 % 16.
    }
}

class Point {
    private int x; // координаты
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    //переопределим equals. Это не очень просто, потому что нужно многое учесть
    //Alt + Ins


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}

class C {
    int x;
    int y;
    String s;
    double d;
    boolean f;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        C c = (C) o;

        if (x != c.x) return false;
        if (y != c.y) return false;
        if (Double.compare(c.d, d) != 0) return false;
        if (f != c.f) return false;
        return s != null ? s.equals(c.s) : c.s == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = x;
        result = 31 * result + y;
        result = 31 * result + (s != null ? s.hashCode() : 0);
        temp = Double.doubleToLongBits(d);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (f ? 1 : 0);
        return result;
    }
}
