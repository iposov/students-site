package inheritance.overriding;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String sound() {
        return "hrrrrrrrrrrrr"; // обобщенный звук животных
    }

    public void sayHello() {
        System.out.println("Hello, I'm " + name + ", " + sound());
    }
}
