package ru.spbu.arts.multithreading;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class MonkeysWithSynchronization {

    public static int bananas = 1_000_000;
    public final static Object monitor = new Object();

    public static void main(String[] args) throws InterruptedException {
        List<Thread> monkeys = new ArrayList<>();
        for (int i = 1; i <= 3; i++)
            monkeys.add(new Thread(new Monkey(i)));

        for (Thread monkey : monkeys)
            monkey.start();

        for (Thread monkey : monkeys)
            monkey.join();
        System.out.println("Все обезьянки закончили");
    }
}

class Monkey implements Runnable {

    private int myBananas = 0;
    private final int number; // номер обезьянки

    public Monkey(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        while (MonkeysWithSynchronization.bananas > 0) {

            synchronized (MonkeysWithSynchronization.monitor) {
                if (MonkeysWithSynchronization.bananas > 0) {
                    MonkeysWithSynchronization.bananas--;
                    myBananas++;
                }
            }
        }

        System.out.println(
                "Обезъянка " + number + " съела бананов: " + myBananas
                + " а всего осталось бананов " + MonkeysWithSynchronization.bananas
        );
    }
}
