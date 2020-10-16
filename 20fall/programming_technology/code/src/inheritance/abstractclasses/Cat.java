package inheritance.abstractclasses;

public class Cat extends Animal {

    private int miceCount = 0;

    public Cat(String name) {
        super(name); // вызов конструктора базового класса. Должен быть
        // написан в начале конструктора
        System.out.println("Создали кота первым способом");
    }

    public Cat() {
        super("Simon");
        System.out.println("Создали кота вторым способом");
    }

    @Override
    public String sound() {
        return "mew";
    }

    public void catchMouse() {
        miceCount++;
        System.out.println("Я уже поймал " + miceCount + " мышей");
    }
}
