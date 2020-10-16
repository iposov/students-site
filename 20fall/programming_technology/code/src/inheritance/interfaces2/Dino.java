package inheritance.interfaces2;

public class Dino implements Growable {

    private int weight = 0;

    @Override
    public void grow(int t) {
        weight += t;
    }

    public void print() {
        System.out.println("Я динозавр веса " + weight);
    }
}
