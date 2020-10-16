package inheritance.interfaces2;

public class GrowableExample {

    public static void main(String[] args) {
        Dino d = new Dino(); //Growable d = new Dino();
        Plant p = new Plant();

        doGrow(p);
        doGrow(d);

        p.print();
        d.print();

        //анонимный класс
        Growable g1 = new Growable() {
            @Override
            public void grow(int t) {
                System.out.println("Я вырастаю на " + t);
            }
        };
        doGrow(g1);

        //(!!!!) Лямбда выражения
        //ситуация, что нужно реализовать интерфейс
        //с ровно одним методом очень частая. Для этой
        //ситуации есть намного более короткий синтаксис,
        //чем анонимный класс:
        Growable g2 = (int t) -> {
            System.out.println("Я вырастаю на " + t);
        };
        //можно не писать типы аргументов и можно не ставить
        //скобки, если один аргумент.
        //Если тело метода состоит из одного действия, то
        // {} тоже можно не писать.
        Growable g3 = t -> System.out.println("Я вырастаю на " + t);

        doGrow(g3);
        //или даже
        doGrow(t -> System.out.println("Я вырастаю на " + t));

        //это и есть лямбда выражение, в других языках есть
        //аналогичные конструкции, по смыслу это безымянные
        //функции.
    }

    private static void doGrow(Growable g) {
        //заставляем наш объект вырасти на 0, потом на 1,
        //потом на 2 и т.д. до 10
        for (int i = 0; i < 10; i++)
            g.grow(i);
        //g.print() невозможен, потому что print нет в Growable
    }

}
