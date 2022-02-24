package ru.spbu.arts.oop.animals;

public class Dog extends Animal { // в файле Dog.java

    public Dog(String name) {
        super(name); // вызов конструктора базового класса
    }

    @Override
    public String getSound() {
        return "woof"; //звук кошек
    }
}
