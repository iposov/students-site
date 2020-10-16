package inheritance.interfaces;

public class Dog implements Animal {
    @Override
    public String sound() {
        return "woof";
    }

    @Override
    public String getName() {
        return "Шарик";
    }
}
