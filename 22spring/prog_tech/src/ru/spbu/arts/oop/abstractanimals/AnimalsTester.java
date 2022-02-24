package ru.spbu.arts.oop.abstractanimals;

public class AnimalsTester { // в файле AnimalsTester.java
    public static void main(String[] args) {
        // создать объект Animal больше нельзя
//        var a1 = new Animal("Barsik");
//        var a2 = new Animal("Tuzik");

        Cat c1 = new Cat("Murzik"); // нужен конструктор!!
        Cat c2 = new Cat(); //имя будет Vaska

        Dog d1 = new Dog("Sharik");

        c1.sayHello(); // "mew, I'm Murzik"
        c2.sayHello(); // "mew, I'm Vaska"
        d1.sayHello(); // "woof, I'm Sharik"

        c1.catchMouse(); //можно
        //d1.catchMouse(); //нельзя

        // переменные могут иметь тип Animal
//        Animal b1 = new Animal("Burenka");
        Animal b2 = new Cat("Barsik");
        Animal b3 = new Dog("Tuzik");

        //потом можно переделать, a3 = new Cat(...)

//        System.out.println(b1.getSound()); // "mrrrrrrrrr"
        System.out.println(b2.getSound()); // "mew" по реальному содержимому a2
        System.out.println(b3.getSound()); // "woof" по реальному содержимому
        //нельзя сделать так:
        //b2.catchMouse(); // потому что b2 — Animal, в нём нет этого метода
        //но можно, если очень надо, привести тип, см. прошлый семестр
        ((Cat)b2).catchMouse(); // можно после приведения типа вызвать метод
        // можно даже проверить тип объекта в переменной:
        System.out.println(b2 instanceof Cat); // true
        System.out.println(b3 instanceof Cat); // false
        System.out.println(b2 instanceof Animal); // true

        // или
        Animal[] animals = {b2, b3, new Cat()};
        for (Animal a : animals) {
            System.out.println(a.getSound());
            a.sayHello();
        }
    }
}
