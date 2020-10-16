package inheritance.constructors;

public class AnimalsTest {

    public static void main(String[] args) {
        Animal a1 = new Animal("Барсик");
        Animal a2 = new Animal("Бурёнка");

        System.out.println(a1.sound());
        a2.sayHello();

        // Cat тоже животное. Значит, у него тоже есть имя ...
        // получается, нельзя просто так создать объект, непонятно,
        // откуда возьмется имя.
        Cat c1 = new Cat();
        Cat c2 = new Cat("Мурзик");

        c1.sayHello();
        c2.sayHello();
    }

}
