# Лекция 3. Управляющие конструкции языка Java

## Переменные в Java

В отличие от Python у каждой переменной Java указывается тип, и переменная может хранить значения толького этого типа. Например, переменная типа `int` может хранить значения только типа `int`:

```
int x = 42; // хорошо
x = "abc"; // ошибка компиляции, программа даже не запустится.

int x = "abc"; //тоже ошибка
```

При заведении переменной сначала указывается ее тип, потом имя:
```
int x;
String s;
boolean b;
int p, q, r; // можно сразу несколько
int pp = 0, qq = 0, r = 0; 
```

Можно сразу инициализировать значение переменной, указав начальное значение:

```
int x = 42; //инициализатор
String s = "abc";
```

Пока вы не присвоите переменной значение, из нее нельзя читать значение. Это тоже ошибка компиляции:

```
String s;
System.out.println(s); //распечатать значение — ошибка
//variable s might not have been initialized

int x;
if (....)
    x = 10;
System.out.println(x); //ошибка, могло не быть инициализировано
```
### Область видимости переменной

Переменная в Java доступна с момента опеределения до конца блока, в котором она определена. Блок — это часть программы между фигурными скобками:

```
public static void main(String[] args) {
    int x = 1; // z недоступна, она будет определена позже
    if (x < 10) {
        int y = 20;
        System.out.println(x + y); //доступны x и y
    }
    int z = 2;
    System.out.println(x, z); //y недоступна 
}
```

## Условный оператор if

Если есть логическое выражение `УСЛОВИЕ` (выражение типа `boolean` и только его), его можно вставить в оператор if:

```
if (УСЛОВИЕ) {  // фигурная скобка через пробел после )
    //операторы с отступом в 4 пробела 
} else { //без отступа относительно if
    //операторы с отступом в 4 пробела
} //без отступа относительно if

if (УСЛОВИЕ) {
     
} // else не обязательный
```

В отличие от python, расстановка отступов не влияет на работу программы, отступы ставятся для читаемости текста, они важны, ставьте их, пожалуйста, правильно.

Если в блоке операторов внутри if ровно один оператор, можно не ставить фигурные скобки (я рекомендую не ставить в этой ситуации):

```
if (x < 10)
    System.out.println("меньше 10");
else {  //2 действия, скобки нужны
    x = x + 1;
    System.out.println("больше 10");
}
```

В Java нет `elif`. Как поступить без него?

```
if (x < 0)
    sout("отрицательный"); //sout = System.out.println()
else {
    if (x == 0)
        sout("ноль");
    else {
        if (x > 1_000_000)
            sout("очень большой");
        else
            sout("положительный");
    }
}
```

запишем это же короче.

```
if (x < 0)
    sout("отрицательный"); //sout = System.out.println()
else if (x == 0)
    sout("ноль");
else if (x > 1_000_000)
    sout("очень большой");
else
    sout("положительный");
```

Получается, что `else if` это как бы и есть `elif` из Python.

## Оператор switch

(Кстати!!!! Вышла 17 Java. Обновитесь!!! 17 — релиз с длительной
поддержкой)

Этот оператор позволяет выбрать один вариант действий в зависимости от значения выражения. Посмотрим только на новую версию switch, старую версию ```switch (выражение) {case VAR: break}``` с двоеточием поле case посмотрите сами.

Позже

## Функции в Java

Пример программы с функциями

```java
public class Task {
    
    public static void main(String[] args) {
        // главная функция, с нее начинается программа
        // давайте договоримся делать функцию main первой
        
        sout(sum(2, 3)); //5
        int z = sum(2, 3); 
        //sum(2, "abc"); //ошибка, аргументы указаны как тип int
        sout(hello("Ilya")); //"Hello, Ilya"
        printHello("Ilya")); //ok
        //sout(printHello("Ilya")); //нечего печатать, ошибка
        //void x = printHello("Ilya"); //ошибка, ничего не вернется
    }
    
    private static ТИП-РЕЗУЛЬТАТА ИМЯ-ФУНКЦИИ(АРГУМЕНТЫ С ТИПАМИ) {
        тело функции 
    }
    
    private static int sum(int x, int y) {
        return x + y; // оператор return аналогичен python
        //возвращаемое выражение должно иметь тип, указанный в
        //заголовке функции
    }
    
    private static String hello(String name) {
        return "Hello, " + name + "!";
    }
    
    private static void printHello(String name) { //void — ничего
        sout("Hello, " + name + "!");
    }
}
```

### Отступление, как форматировать строки в Java

Нужен аналог f-строк в Python. `f"Hello, {name}!"`
```
    String name = "Ilya";
    String.format("Hello, %s!", name); //это получается тип String
    sout(String.format("Hello, %s!", name));
    String hello = String.format("Hello, %s!", name);
    String.format("x = %f", 4.2);
    String.format("x = %.2f", 4.2); //.2 два знака после запятой
    //%s - подставь строку
    //%f - подставь вещественно число
```

Подробности про `%s` и другие проценты по ссылке https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Formatter.html