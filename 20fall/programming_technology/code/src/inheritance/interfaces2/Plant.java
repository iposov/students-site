package inheritance.interfaces2;

public class Plant implements Growable {

    private int height = 0;

    //копируем заголовок - переопределяем метод grow
    @Override
    public void grow(int t) {
        height += t;
    }

    public void print() {
        System.out.println("Я растение высоты " + height);
    }
}
