package inheritance.constructors;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }
    // мы обязаны создавать объекты вызовом одного из конструкторов
    // значит, в этом примере гарантируется, что у всех животных
    // есть имя.

    public String sound() {
        return "hrrrrrrrrrrrr"; // обобщенный звук животных
    }

    public void sayHello() {
        System.out.println("Hello, I'm " + name + ", " + sound());
    }
}
