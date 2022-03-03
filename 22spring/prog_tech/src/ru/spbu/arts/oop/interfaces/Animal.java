package ru.spbu.arts.oop.interfaces;

// вместо class пишем interface
public interface Animal {

    //поля в интерфейсе недопустимы

    String getName(); // можно узнать Имя
    String getSound(); // можно узнать звук, который произносит животное

    //public abstract подразумевается

    //можно делать статический метод
    static void sayHello(Animal a) {
        System.out.println("%s! I'm %s!".formatted(a.getSound(), a.getName()));
        //или this.getSound(), this.name
    }

    //еще есть способ решить проблему метода sayHello
    //В последних версиях Java появилась возможность создавать методы
    //с реализацией по-умолчанию (ключевое слово default)
    //Эта реализация будет использоваться, если она не переопределена
    default void sayHelloVerII() {
        System.out.println("%s! I'm %s!".formatted(getSound(), getName()));
    }

    //поле, если введено, тоже автоматически статическое
    String name = "Animal";
}
