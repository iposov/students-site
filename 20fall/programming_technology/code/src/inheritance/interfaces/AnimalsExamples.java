package inheritance.interfaces;

public class AnimalsExamples {

    public static void main(String[] args) {
//        Animal a = new Animal(); //нельзя, интерфейс не создать
        Animal c = new Cat("Барсик");
        Animal d = new Dog();

        System.out.println(c.getName());
        System.out.println(c.sound());
        System.out.println(d.getName());
        System.out.println(d.sound());

        sayHello(c);
        sayHello(d);

        //работают анонимные классы, как и раньше
        sayHello(new Animal() {
            @Override
            public String sound() {
                return "moo";
            }

            @Override
            public String getName() {
                return "Мурёнка";
            }
        });
    }

    //раньше sayHello был внутри класса. Но теперь мы не можем
    //написать его в Интерфейсе, потому что в Интерфейсе нельзя
    //задавать тело у метода.
    private static void sayHello(Animal a) {
        System.out.println("Привет, меня зовут " +
                a.getName() +
                ", " +
                a.sound()
        );
    }

}
