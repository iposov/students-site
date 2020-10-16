package inheritance.abstractclasses;

//если есть внутри абстрактные методы, класс
//тоже должен быть абстрактным
public abstract class Animal {

    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    // ключевое слово abstract, можем не писать тело метода
    public abstract String sound();

    public void sayHello() {
        System.out.println("Hello, I'm " + name + ", " + sound());
    }
}
