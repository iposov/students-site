package inheritance.abstractclasses;

public class AnimalsTest {

    // вводим абстрактный класс.
    // сказали, что Animal абстрактный и метод sound()
    // в нем абстрактный. После этого просто нельзя
    // создавать объекты этого класса, и всё.

    public static void main(String[] args) {
        //нельзя создавать (вызывать конструктор)
        //у абстрактных классов
//        Animal a1 = new Animal("Барсик");
//        Animal a2 = new Animal("Бурёнка");

        Cat c1 = new Cat();
        Cat c2 = new Cat("Мурзик");

        c1.sayHello();
        c2.sayHello();

        Dog d1 = new Dog("Шарик");
        d1.sayHello();

        c1.catchMouse();
        c1.catchMouse();

        Animal a3 = new Cat("Бегемот");
        Animal a4 = new Dog("Шарик младший");

        a3.sayHello();
        a4.sayHello();

        //Анонимные классы
        //Можно реализовать наследника другого класса
        //не создавая для этого отдельный файл с классом внутри
        // наследник без имени
        //Animal a5 = new Animal("Мурёнка"); //нельзя,
        //абстрактно

        Animal a5 = new Animal("Мурёнка") {
            //в фигурных скобках после конструктора можно
            //указать тело класса. Класс внутри класса.
            //пишем методы, поля и т.п.
            @Override
            public String sound() {
                return "moooo";
            }
        };
        //эквивалентно class ???? extends Animal {
        //}

        a5.sayHello();
    }
}
