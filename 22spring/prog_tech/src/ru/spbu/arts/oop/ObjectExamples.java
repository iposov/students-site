package ru.spbu.arts.oop;

import ru.spbu.arts.oop.books.Book;

public class ObjectExamples {

    public static void main(String[] args) {
        // можно создать чистый объект
        Object o = new Object();

        // Любой объект можно преобразовать в строку
        //o.toString();
        System.out.println(o.toString());
        System.out.println((new Object()).toString());

        //toString() есть у всего:
        System.out.println(new Book().toString());

        //если toString() есть у всего, этим может пользоваться
        //метод println(), он будет вызывать toString() сам:
        //см. str() в python

        System.out.println(new Book());

        // equals
        // метод equals позволяет сравнить два объекта по содержимому.
        String s1 = "abc";
        String s2 = "xabc".substring(1); // "abc"
        System.out.println(s1 == s2); // false !! разные объекты
        System.out.println(s1.equals(s2)); // но содержимое одинаковое
    }

}

class Point {
    private int x;
    private int y;

    /*@Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        //Заодно надо проверить, что это не наследник Point
        if (!(obj instanceof Point))
            return false;
        Point that = (Point) obj;
        return x == that.x && y == that.y;
    }
     */

    //Как IDEA напишет для нас equals
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
