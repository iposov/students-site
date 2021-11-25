# Наследование

Наследование в Java по смыслу совпадает с наследованием в Python.
Рассмотрим на примере с животными.

```java
public class Animal {  // создаём в файле Animal.java
    
    private String name; // у всех животных есть имя
    
    public Animal(String name) {
        this.name = name;
    }
    
    public String getSound() {
        return "wrrrrrrrrrrrrrrrrr"; //усреднённый звук всех животных
    }
    
    public void sayHello() {
        System.out.println("%s! I'm %s!".formatted(getSound(), name));
        //или this.getSound(), this.name
    }
}
```

Используем так:

```java
public class AnimalsTester { // в файле AnimalsTester.java
    public static void main(Stirng[] args) {
        var a1 = new Animal("Barsik");
        var a2 = new Animal("Tuzik");
        
        a1.sayHello(); // wrrrrrrrrrrrrrrrrr, I'm Barsik
        a2.sayHello(); // wrrrrrrrrrrrrrrrrr, I'm Tuzik.
    }
}
```

Унаследуем от класса `Animal` два других класса: `Cat` и `Dog`. Чтобы написать, что класс наследует другой, пишем A extends B (дословно: расширяет). 

После этого всё содержимое Animal переходит в Cat. Т.е. теперь у Cat есть имя `name`,
есть метод getSound(), есть `sayHello`.  Кроме этого мы можем
 - добавить новые поля и методы
 - изменить работу старых методов (переопределить, override)

```java
public class Cat extends Animal { // в файле Cat.java
    
    //Создание кота подразумевает, что сначала создается «внутренний» класс Animal
    //Для этого есть конструктор Animal(Stirng name), и нам надо его вызвать
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

// собака
public class Dog extends Animal { // в файле Dog.java
    
    public Dog(String name) {
        super(name); // вызов конструктора базового класса
    }

    @Override
    public String getSound() {
        return "woof"; //звук кошек
    }
}

```

Использование:

```
Cat c1 = new Cat("Murzik"); // нужен конструктор!! 
Cat c2 = new Cat(); //имя будет Vaska

Dog d1 = new Dog("Sharik");

c1.sayHello(); // "mew, I'm Murzik"
c2.sayHello(); // "mew, I'm Vaska"
d1.sayHello(); // "woof, I'm Sharik"

c1.catchMouse(); //можно
//d1.catchMouse(); //нельзя
```

Переменным, которые хранят значения типа Animal можно присваивать, на самом деле,
не только Animal, но и Cat и Dog:

```
Animal a1 = new Animal("Burenka");
Animal a2 = new Cat("Barsik");
Animal a3 = new Dog("Tuzik");

//потом можно переделать, a3 = new Cat(...)

System.out.println(a1.getSound()); // "mrrrrrrrrr"
System.out.println(a2.getSound()); // "mew" по реальному содержимому a2
System.out.println(a3.getSound()); // "woof" по реальному содержимому

// или
Animal[] animals = {a1, a2, a3, new Cat()};
for (Animal a : animals) {
    System.out.println(a.getSound());
    a.sayHello();
}
```

В последнем цикле каждое животное поздоровается по-своему. Кот как кот, собака как собака.

# Формат SVG
Формат изображений, распространенный, современный.

Попробуем вручную создать svg файл.

```
<?xml version="1.0" encoding="UTF-8"?>
<svg width="200" height="200">
    <rect fill="#00FF00" stroke="#FF0000" x="70" y="80" width="100" height="100"/>
    <rect fill="#00FF00" stroke="#FF0000" x="50" y="50" width="100" height="100"/>
</svg>
```

Напишите это в текстовом редакторе в файле с расширением `.svg` и просмотрите в просмоторщике изображений. 
