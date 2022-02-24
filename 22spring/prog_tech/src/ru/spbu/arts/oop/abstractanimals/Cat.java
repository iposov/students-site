package ru.spbu.arts.oop.abstractanimals;

public class Cat extends Animal { // в файле Cat.java

    //Создание кота подразумевает, что сначала создается «внутренний» класс Animal
    //Для этого есть конструктор Animal(String name), и нам надо его вызвать
    public Cat(String name) {
        super(name); // вызов конструктора базового класса
    }

    //конструктор без аргументов
    public Cat() {
        super("Vaska"); //имя для Animal все равно требуется
    }

    // переопределяем метод getSound(), для котов он теперь работает иначе.
    // для переопределения достаточно написать метод с тем же заголовком.
    // рекомендуется дополнтельно дописать @Override в начало
    @Override
    public String getSound() {
        return "mew"; //звук кошек
    }

    //особый метод, есть только у котов
    public void catchMouse() {
        System.out.println("nom-nom");
    }

}
