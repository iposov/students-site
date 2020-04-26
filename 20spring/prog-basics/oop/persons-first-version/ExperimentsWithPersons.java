public class ExperimentsWithPersons {

    public static void main(String[] args) {
        Person p = new Person("Илья", 1910);
        p.sayHello();

        System.out.println("Имя p: " + p.getName());
        System.out.println("Год рождения p: " + p.getYearOfBirth());
        System.out.println("Возраст p: " + p.getAge());

        if (p.isAdult())
            System.out.println("p — совершеннолетний");
        else
            System.out.println("p — не совершеннолетний");

        p.setName("Ваня");
        p.sayHello();
    }
}
