package inheritance.overriding;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public String sound() {
        return "woof";
    }
}
