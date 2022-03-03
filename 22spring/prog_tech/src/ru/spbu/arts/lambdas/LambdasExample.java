package ru.spbu.arts.lambdas;

public class LambdasExample {
    public static void main(String[] args) {
        //1. Сделаем отдельный класс, функцию f(x) = x + 1

        Function f = new Plus1();
        System.out.println(f.evaluate(10));

        //2. Сделаем это же, но анонимным классом, g(x) = 2 * x

        Function g = new Function() {
            @Override
            public int evaluate(int x) {
                return 2 * x;
            }
        };

        System.out.println(g.evaluate(10));

        //3. Лямбда выражение, h(x) = 3*x + 1

        //убрали лишнее из описания абстрактного класса
        Function h = (int x) -> {
            return 3 * x + 1;
        };

        System.out.println(h.evaluate(10));

        // еще короче. Можно не писать тип переменной x (обычно)
        // если внутри {} одно действие, то {} не пишут, и return тоже
        Function hh = x -> 3 * x + 1;

        System.out.println(hh.evaluate(10));
    }
}
