# Класс Object

Этот класс — корень иерархии наследования.
Любой класс, который вы заводите, либо наследуется от указанного вами класса: `class A extends B`, либо наследуется от `Object`: `class A` эквивалентна `class A extends Object`. Получается, что любой класс напрямую или косвенно наследует `Object`.

```
class A {}
class B extends A {}
class C extends B {}
```

В этом случае, `Object <- A <- B <- C`.

Зачем? Во-первых, получается, что всё является объектом (кроме значений базовых типов (8 шт), например, `int`).

```
Object o1 = "abc";  // String
Object o2 = new Student("", "");
Object o3 = new Scanner(...);
Object o4 = new int[]{10, 20, 30};
Object o5 = 42; //42 преобразуется в Integer (boxing)

private void fun(Object o) {
    // в эту функцию можно передать всё что угодно
}
```

Второе, зачем нужен Object. В этом классе определён ряд методов, получается, что эти методы есть у абсолютно всех объектов. Перейдем к коду, чтобы посмотреть на эти методы:

[код](https://github.com/iposov/students-site/blob/master/22spring/prog_tech/src/ru/spbu/arts/oop/ObjectExamples.java)
