package inheritance.interfaces;

//классы расширяют (extends)
//интерфейсы реализуют (implements)
public class Cat implements Animal {

    private final String name;

    public Cat(String name) {
        this.name = name;
    }

    //как и в классах, при переопределении метода
    //рекомендуется написать @Override. Нужно записать
    //заголовок метода, как в интерфейсе
    @Override
    public String sound() {
        return "mew";
    }

    @Override
    public String getName() {
        return name;
    }

}
