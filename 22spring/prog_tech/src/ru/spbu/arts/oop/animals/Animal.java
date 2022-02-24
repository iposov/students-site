package ru.spbu.arts.oop.animals;

public class Animal {  // создаём в файле Animal.java

    private String name; // у всех животных есть имя

    public Animal(String name) {
        this.name = name;
    }

    public String getSound() {
        return "wrrrrrrrrrrrrrrrrr"; //усреднённый звук всех животных
    }

    public void sayHello() {
        System.out.println("%s! I'm %s!".formatted(getSound(), name));
        //или this.getSound(), this.name
    }
}
