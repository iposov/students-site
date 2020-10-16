package inheritance.overriding;

public class AnimalsTest {

    public static void main(String[] args) {
        Animal a1 = new Animal("Барсик");
        Animal a2 = new Animal("Бурёнка");

        System.out.println(a1.sound());
        a2.sayHello();

        Cat c1 = new Cat();
        Cat c2 = new Cat("Мурзик");

        c1.sayHello();
        c2.sayHello();

        Dog d1 = new Dog("Шарик");
        d1.sayHello();
        // d1 - это на самом деле Dog. Поэтому когда внутри
        // sayHello вызывается this.sound(), вызывается sound
        // именно объекта d1, а он в нем переопределен на woof

        c1.catchMouse();
        c1.catchMouse();

        //d1.catchMouse(); // не работает

        //Переменные с типом базового класса могут хранить
        //объекты потомки
        Animal a3 = new Cat("Бегемот");
        Animal a4 = new Dog("Шарик младший");

        a3.sayHello(); //здоровается как кот
        a4.sayHello(); //здоровается как собака

        // проблема есть такая a3 кот, но может ли он поймать мышь?
        //a3.catchMouse(); //не работает. До запуска программы
                           //известно, что a3 животное,
                           //но неизвестно, что это Cat

        // можно проверять тип:
        System.out.println(a3 instanceof Cat);
        System.out.println(a4 instanceof Cat);

        // Как вызвать catchMouse() ?
        // (Cat) a3 - это оператор приведения типа.
        // (double) x
        ((Cat) a3).catchMouse();
        // оператор приведения типа проверяет, что тип
        // действительно Cat и тип выражаения становится Cat.
        //((Cat) a4).catchMouse(); // будет ошибка во время работы
    }

}
