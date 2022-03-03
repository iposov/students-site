package ru.spbu.arts.oop.abstractanimals;

// Сделаем абстрактный класс и метод внутри getSound
public abstract class Animal {  // создаём в файле Animal.java

    private String name; // у всех животных есть имя

    public Animal(String name) {
        this.name = name;
    }

    public abstract String getSound();

    public void sayHello() {
        System.out.println("%s! I'm %s!".formatted(getSound(), name));
        //или this.getSound(), this.name
    }
}
