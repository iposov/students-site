package ru.spbu.arts.oop.interfaces;

// при реализации интерфейса пишем implements (вместо extends) = "реализует"
public class Cat implements Animal {
    // мы обязаны реализовать все методы, которые указана в Animal

    //введем вручную поле для хранения имени
    //работу с именем приходится реализовывать самостоятельно, она больше
    //не доступна из Animal
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSound() {
        return "mew"; //звук кошек
    }

    //особый метод, есть только у котов
    public void catchMouse() {
        System.out.println("nom-nom");
    }

}
