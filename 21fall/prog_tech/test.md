# Задача для зачёта

Дан файл с положительными числами, и в начале
сказано, сколько этих чисел. Т.е. первое число — это количество чисел дальше.

```
10
42 234
3245 342 540
34
234
44 44 55
```

Надо прочитать все числа в массив, записать
их в другой файл, выровняв по правому краю (по длине самого большого числа).

```
  42
 234
3245
 342
 540
  34
 234
  44
  44
  55
```

(упрощение — просто выведите в столбик)

Крайний срок: 15.30. Решение пошлите в чате, в виде одного файла с классом.

Идентификаторы в Java. Переменные с маленькой буквы:
```
myVariable
x
x2
variableOfSeveralWords
```
Классы правильно с называть с заглавной буквы:
```
Main
Test
MyTest
```

Неправильно:
переменная не должна быть с заглавной буквы:
```
X
int Hello = 123;
```
через подчеркивания
```
variable_of_several_words = 321;
```

Пример чтения файлов:

```java
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner; // аналогично import в Python

public class FileReadWriteExamples {

    // Дописываем throws Exception в заголовок всех методов,
    // которые работают с файлами
    public static void main(String[] args) throws Exception {
        readFileExample(); // прочитай пример файла
        writeFileExample();
    }

    private static void writeFileExample() throws Exception {
        // запись в файлы будет похожа на печать на экран

        //try это аналог with в python, т.е. при выходе из try будет вызвано outFile.close()
        //PrintStream - это тип, который имеет System.out
        //Т.е. outFile может ровно то же, что и System.out
        try (PrintStream outFile = new PrintStream("texts-examples/a.txt", StandardCharsets.UTF_8)) {
            outFile.println("Hello");
            outFile.print("печать без перевода строки");
            outFile.flush(); // сброс данных в файл, но после закрытия файла это происходит автоматически
        }
    }

    // Дописываем throws Exception в заголовок всех методов,
    // которые работают с файлами
    private static void readFileExample() throws Exception {
        //заводим переменную типа Path для хранения пути к файлу
//        Path txt = Path.of("texts-examples/read-write-example.txt");
        Path txt = Path.of("texts-examples", "read-write-example.txt");
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            String line1 = in.nextLine(); // прочитать строку nextLine()
            String line2 = in.nextLine(); // прочитать следующую строку
            String word3 = in.next(); // прочитать следующее слово
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(word3);

            int x = in.nextInt();
            System.out.println(x);
            //int y = in.nextInt(); //ошибка, там уже не число

            // Проверка, что дальше в файле находится число
            if (in.hasNextInt()) {
                int y = in.nextInt(); // чтение числа из файла
                System.out.println("прочитали число " + y);
            } else {
                System.out.println("в файле дальше не число");
            }

            // проверка, что дальше в файле есть слово для чтения
            while (in.hasNext()) {
                String word = in.next();
                System.out.println("Прочитано слово " + word);
            }
        }
    }
}

```
