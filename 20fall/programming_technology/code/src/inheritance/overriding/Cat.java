package inheritance.overriding;

public class Cat extends Animal {

    public Cat(String name) {
        super(name); // вызов конструктора базового класса. Должен быть
        // написан в начале конструктора
        System.out.println("Создали кота первым способом");
    }

    public Cat() {
        super("Simon");
        System.out.println("Создали кота вторым способом");
    }

    // здесь есть поле name (из Animal)
    // есть методы sound() и sayHello()

    // можно изменить = переопределить методы из базовых классов
    // для переопределения достаточно повторить заголовок метода
    // Idea показывает в этом случае слева букву o (overrides)
    // Лучше явно указывать, что вы хотите именно переопределить,
    // для этого рекомендуется писать в начале слово @Override
    @Override
    public String sound() {
        return "mew";
    }

    // можно и новые создать методы
    // Они только у кота, у собаки их нет.
    private int miceCount = 0;

    public void catchMouse() {
        miceCount++;
        System.out.println("Я уже поймал " + miceCount + " мышей");
    }
}
