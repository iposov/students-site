# Файлы

## Пути к файлам

Типы данных: путь к файлу
1. `Path` из пакета `java.nio.file`.
2. `File` из пакета `java.io`.

Чтобы пользоваться этими типами, в начале (до `public class`)
программы нужно написать:

```
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.*; //можно так вместо двух предыдущих
import java.io.File;
``` 

Создание:
1. `new File("a.txt")` или `new File("c:\windows\a.txt")`. 
В первом случае путь относительный, во втором - абсолютный. Как
и в python, рекомендуется использовать только относительные.
1. `Paths.get("a.txt")` или `Paths.get("c:\windows\a.txt")` или
`Paths.get("c:", "windows", "a.txt")` или
`Paths.get("c:/windows", "a.txt")`

Пример:

`File f = new File("c:/windows/a.txt")` или
`Path p = Paths.get("c:/windows/a.txt")`

В этих переменных хранится информация о пути, можно ее извлекать:
```
String name = f.getName(); // "a.txt"
Path fname = p.getFileName(); //аналогично, но тип другой
String folder = f.getParent(); // "c:/windows"
Path pfolder = p.getParent(); //аналогично, но вернет Path 
```

В `File` есть дополнительные возможности по действию с файлами,
можно проверить существует ли файл, есть ли права на чтение,
можно его переименовать или удалить. Лучше ими не пользоваться,
ищите новые методы сделать то же самое через классы из пакета
java.nio.

## Запись в файл

Очень много возможностей в Java есть по записи в файл. В примерах
в Интернете вы найдете десятки совершенно разных способов.
Мы будем пользоваться самым простым для наших целей, классом
`PrintStream` из пакета `java.io`.

(т.е. пишите `import java.io.PrintStream;` или
`import java.io.*;`)

По смыслу `PrintStream` - это поток символов для записи куда-то,
например, в файл.

Создание:

`PrintStream ps1 = new PrintStream("a.txt", "utf8")`. Указываем
имя файла и кодировку. Можно вместо имени файла указать `File`:
`PrintStream ps1 = new PrintStream(new File("a.txt"), "utf8")`.

После того как объект создан, им можно пользоваться. Он устроен
аналогично `System.out`:

```
ps1.println(); // это как System.out.println(), но в файл
ps1.print(); // это аналогично, но без перевода строки в конце
ps1.printf(); // это как print(String.format())
```

### Дополнения
На самом деле, созданный PrintStream необходимо закрывать:
```
PrintStream ps1 = new PrintStream("a.txt", "utf8");
ps1.println(...);
ps1.close(); // важно!! Нужно освобождать ресурсы
```
В java аналог конструкции with это конструкция try:

```
try (PrintStream ps1 = new PrintStream("a.txt", "utf8")) {
    // в этом блоке можно пользоваться ps1
    ps1.println('....');
}
```

В java, в отличие от python, вы обязаны обработать ошибку,
если она может возникнуть. Для этого, в том методе, который
содержит чтение файла в загловок нужно добавить `throws Exception`:

```
public static void main(String[] args) throws Exception {
    doSomething();
}

private static void doSomething() throws Exception {
    writeToConsole("hello");
    writeToFile("a.txt", "hello");
}

private static void
    writeToFile(String fileName, String text) throws Exception {

    try (PrintStream out = new PrintStream(fileName, "utf8)) {
        out.println(text);
    }
}

// не нужен throws Exception
private static void writeToConsole(String text) {
    System.out.println(text);
}

```

## Чтение из файла
Класс `Scanner` из пакета `java.util`.

Создание: `new Scanner(источник, "utf8")`. Источники:
1. файл File
1. файл Path (Paths)
1. `System.in` это стандартный ввод, фактически, клавиатура
1. String. Будет читать строку: `new Scanner("текст для чтения")`

Кодировку указывайте только если читаете из файла.
Распространенная ошибка: `new Scanner("a.txt")`. Ожидается, что
будет чтение из файла `a.txt`, но реально читается строка текста.

`Scanner` умеет читать текст по словам, по строкам. Слова можно
воспринимать как String или как числа и другие типы.

```
Scanner in = new Scanner("Слово    42   1.333");
//in.useDelimiter("рег выр"); // можно не делать.
// По умолчанию разделение пробелом
in.hasNext(); //проверка, есть ли еще слова. true
in.hasNextInt(); // false, это не число
String s1 = in.next(); //прочитает "Слово"
in.hasNext(); // true
in.hasNextInt(); // true,  потому что следующее слово - число!!
int s2 = in.nextInt(); //42. если бы было не число, была бы ошибка
in.hasNextInt(); // false
in.hasNextDouble(); // true
double s3 = in.nextDouble(); // 1.333
in.hasNext(); // false больше слов нет
in.nextLine(); // а вот так можно прочитать строчку целиком
``` 

Если читаете файл, обязательно внутри `try`, и добавлять
`throws Exception`.