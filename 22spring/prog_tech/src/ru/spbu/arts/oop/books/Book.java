package ru.spbu.arts.oop.books;

public class Book { // в файле Book.java

    // статические элементы класса
    static int numBooks; // сколько всего книг в библиотеке
    static void addBook() {
        Book.numBooks += 1;
    }

    // элементы класса
    // поля, хранят данные
    String title;
    String author;
    int year;

    // методы, совершают действия
    // [тип результата] [имя функции]([аргументы]) {
    // }
    // this — аналог self в Python, только в отличие от Python его не нужно писать явно
    void print() {
        System.out.println(this.author + ", " + this.title + " (" + this.year + ")");
    }
}
