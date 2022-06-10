package ru.spbu.arts.multithreading;

public class Println100Times {

    public static void main(String[] args) {
        //поток (нить) Thread
        //аргумент конструктора — это Runnable, интерфейс с
        //единственным методом void run(), можно реализовать
        //через лямбда выражение
        Thread thread1 = new Thread(() -> {
            for (int i = 1; i <= 100; i++)
                System.out.println("Hello from thread 1: " + i);
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 1; i <= 100; i++)
                System.out.println("Hello from thread 2: " + i);
        });

        //запуск потока, выполняет метод run, который указан в
        //Runnable, в новом потоке
        thread1.start();
        thread2.start();
    }

}
