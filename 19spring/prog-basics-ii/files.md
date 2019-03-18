# Работа с файлами

## Пути к файлам

Класс (тип) `Path`. Переменные этого типа содержат путь в файловой системе к файлу или
каталогу на диске. Для создания значения типа `Path` используйте метод `Path.of()`. Например, заведем переменную с путём к блокноту:

```java
//как обычно, заводим переменную синтаксисом ТИП ИМЯ = НАЧАЛЬНОЕ ЗНАЧЕНИЕ
Path notepad1 = Path.of("C:\\windows\\notepad.exe"); //обязательно экранируем обратный слэш
// но лучше прямой слэш, работает в разных ОС, включая Win, Lin:
Path notepad2 = Path.of("C:/windows/notepad.exe");
// можно вместо разделителя перечислить элементы пути
Path notepad3 = Path.of("C:/windows", "notepad.exe");
Path notepad4 = Path.of("C:", "windows", "notepad.exe");
//можно написать var, Java сама поймет, что тип Path.
var notepad5 = Path.of("C:", "windows", "notepad.exe");
```

С путем можно совершать много разных действий, полный список доступен по ссылке [https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Path.html](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/nio/file/Path.html).
Напомню, что подобные страницы документации можно искать поисковым запросом `docs java 11 Path`.

Для примера, вот несколько возможностей:
```java
notepad1.getParent() // возвращает предыдущую папку: C:\windows. Она имеет тип Path
notepad1.getFileName() // возвращает имя файла, notepad.exe. Возвращает тип Path
```

Чтобы пользоваться этим классом, напишите в начале программы `import java.nio.file.Path`. nio - это "new input output", т.е.
новая библиотека ввода/вывода. Старая библиотека `java.io` имеет ограниченные возможности, но она значительно более распространена.
В ней есть класс `java.io.File`, это аналог современного `java.nio.Path`.

Преобразования:
```java
myPath.toFile() //превращает Path в File
myFile.toPath() //наоборот
```

## Запись в файл

Для записи в файл будем использовать класс PrintStream. Это класс
из java.io (поэтому для использования пишем `import java.io.PrintStream`).
Это ровно тот же класс, что имеет `System.out`, поэтому при
использовании этого класса для записи в файл можно делать все те же
привычные нам действия, которые мы делаем при печати в консоль.

Для создания объекта класса PrintStream используется оператор new. Это самый распространенный способ создания
объектов в Java, поэтому дальше мы очень часто будем его встречать.

```java
//путь к файлу можно указать либо в виде строки, либо в виде File
//не забываем указывать кодировку
PrintStream out = new PrintStream("путь к файлу", "utf8");
PrintStream out = new PrintStream("путь к файлу", StandardCharsets.UTF_8);
//второй способ задания кодировки предпочтительней, потому что проверка правильности
//кодировки произойдет еще на этапе компиляции.

out.println("Hello"); //распечатка с переводом строки
out.print("Hello"); //распечатка без перевода строки
out.printf("%d + %d", 2, 3); //для тех, кто пользуется
//это всё аналогично System.out.println() ...

out.close(); //нельзя забывать закрыть файл
```

Как и в Python, вместо ручного закрытия файла лучше пользоваться конструкцией, которая гарантирует закрытие файла:

```java
try (PrintStream out = new PrintStream("a.txt", StandardCharsets.UTF_8)) {
}
```

Это аналог оператора `with` из Python. После выхода из блока try закрытие файла гарантируется.

Если нужно в одном блоке открыть два файла, то они пишутся через точку с запятой:
```java
try (
    PrintStream out1 = new PrintStream("a.txt", StandardCharsets.UTF_8);
    PrintStream out2 = new PrintStream("b.txt", StandardCharsets.UTF_8);
) {
    //можно работать с файлами
}
//здесь после try файлы уже закрыты.
```

Ну и, конечно, можно писать var вместо явного указания типов переменных.

## Чтение из файла

Для чтения из файла подойдет класс java.util.Scanner.
Он позволяет читать из текстового файла слова, числа, и другие элементы.

Scanner тоже создается оператором `new`, конструкция `try` гарантирует, что файлы будут закрыты.
При создании `Scanner` можно указать либо путь к файлу, тогда используйте параметр типа `Path` или `File`, либо сразу текст.
Обратите внимание, что при создании `Scanner` текст не считается именем файла, вы указываете ровно тот текст, который хотите читать
с помощью возможностей класса `Scanner`.

```java
try (
    Scanner in1 = new Scanner(myPath, кодировка);
    Scanner in2 = new Scanner("123 321 текст 42 внутри сканера")
) {
    //in2 читает содержимое строки, которую ему передали
    System.out.println(in2.next()); //возвращает "123"
    System.out.println(in2.next()); //возвращает "321"
    System.out.println(in2.hasNext()); //возвращает true - есть еще слово
    System.out.println(in2.next()); // "текст"
    System.out.println(in2.hasNextInt()); //true - дальше число
    System.out.println(in2.nextInt()); //42 типа int
    System.out.println(in2.hasNextInt()); //false - "внутри" не число
    System.out.println(in2.hasNext()); //true
    
    System.out.println(in2.hasNextLine());
    System.out.println(in2.nextLine()); //проверка и чтение строки
}
```

## Чтение и запись файлов с помощью класса Files
В простых ситуациях можно записывать в файлы с помощью вспомогательного
класса java.nio.file.Files.

* `byte[] b = File.readAllBytes(myPath)`. Прочитать файл в виде
массива байт.
* `String s = File.readString(myPath, кодировка)`. Прочитать весь файл
в виде одной строки текста
* `List<String> l = Files.readAllLines(myPath, кодировка)`. Прочитать
файл в виде списка строк (списки еще не проходили).
* `Files.writeString(myPath, textToWrite, кодировка)` записывает строку
в файл.
* `Files.write(myPath, список строк, кодировка)` записывает построчно
в файл указанные строки.


## Обработка исключений
Чтобы все примеры выше работали, нужно в загловоки функций, которые
используют работу с вводом/выводом, добавлять `throws Exception`:

```java
public static void main(String[] args) throws Exception {
```
