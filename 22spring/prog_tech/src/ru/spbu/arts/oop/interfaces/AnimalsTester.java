package ru.spbu.arts.oop.interfaces;

public class AnimalsTester {

    public static void main(String[] args) {
        Animal a1 = new Cat("Vaska");
        Animal a2 = new Dog(); // пустой конструктор
        //Animal a3 = new Animal(); // невозможно, Animal = интерфейс, абстрактный

        System.out.println(a1.getName());
        System.out.println(a2.getName());

        //sayHello, он у нас статический, его можно вызвать через имя класса/интерфейса
        Animal.sayHello(a1); //раньше было удобней, было a1.sayHello()
        Animal.sayHello(a2);

        a1.sayHelloVerII();
        a2.sayHelloVerII();

        Animal cow = new Animal() {
            //это тело класса, но у класса нет имени
            @Override
            public String getName() {
                return "Бурёнка";
            }

            @Override
            public String getSound() {
                return "moo";
            }
        };

        cow.sayHelloVerII();
    }
}
