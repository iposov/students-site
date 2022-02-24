package ru.spbu.arts.oop.books;

public class BookTester {
    public static void main(String[] args) {
        // создание объекта: new ИмяКласса(аргументы)
        Book book1 = new Book(); //тип = класс
        book1.title = "Harry Potter";
        book1.author = "Joan Rowling";
        book1.year = 1997;

        //оператор new создает объект
        Book book2 = new Book();
        book2.title = "Alice in Wonderland";
        book2.author = "Lewis Carrol";
        book2.year = 1200;

        //в первом print переменная this = book1
        book1.print();
        //во втором print переменная this = book2
        book2.print();

        //Статические элементы, обращаемся к классу
        Book.numBooks = 0;
        Book.addBook();
        Book.addBook();
        System.out.println("Теперь у нас книг: " + Book.numBooks);
    }
}
