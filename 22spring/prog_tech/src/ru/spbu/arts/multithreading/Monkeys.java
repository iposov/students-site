package ru.spbu.arts.multithreading;

public class Monkeys {

    //В корзине лежат 100 бананов
    private static int bananas = 1_000_000;

    public static void main(String[] args) {
        // Мы создадим 10 обезьян, которые будут одновременно
        // забирать себе по банану, пока бананы не кончатся

        Thread monkey1 = new Thread(() -> {
            //код одной из обезъян
            int myBananas = 0;

            while (bananas > 0) {
                bananas--; // x <- bananas, x <- x + 1, x -> bananas
                myBananas++;
            }

            System.out.println(
                    "Я обезьнка 1, съела бананов: " + myBananas
            );
        });

        Thread monkey2 = new Thread(() -> {
            //код одной из обезъян
            int myBananas = 0;

            while (bananas > 0) {
                bananas--;
                myBananas++;
            }

            System.out.println(
                    "Я обезьнка 2, съела бананов: " + myBananas
            );
        });

        monkey1.start();
        monkey2.start();

        //обезъяны съедают в сумме больше, чем 1млн бананов. Иногда даже
        //одна съедает больше миллиона. Потому что вычитание 1 из внешней
        //переменной — не атомарная операция, она может прерваться.

        //Обезьянок нужно синхронизировать.
    }

}
