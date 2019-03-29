```java
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regexps {

    public static void main(String[] args) {
        //регулярные выражения в Java

        //1) разделить строку на части
        // \\s это интерпретируется как java строка \s
        String[] s = "a,  b, c,  d,   e,f".split(",\\s*");
        //System.out.println(Arrays.toString(s));
        for (String word : s)
            System.out.println("|" + word + "|");

        //2) проверить строку на соответствие выражению
        System.out.println("abc".matches("[a-z]+"));
        System.out.println("abc123".matches("[a-z]+"));
        System.out.println("abc123".matches("^abc.*"));

        //3) в Scanner есть метод useDelimiter() - можно
        //указать, какие символы разделяют слова в тексте
        Scanner in = new Scanner("ab, c234, 123asdf");
        in.useDelimiter("[^a-zA-Z]+");
        //слова ab c asdf

        //4) замена (replaceAll - по рег. выр, replace - по символам)
        System.out.println(
                "abc aqwer sdf".replaceAll(" ", "+")
        );

        //5) группы. Полноценная работа с рег. выр
        String text = "Большые сине-зеленый водросли и красно-желтый апельсин.";

        //Pattern - это регулярное выражение.
        //оно создается методом compile:
        Pattern p = Pattern.compile("([а-яА-Я]+)-([а-яА-Я]+)");

        //Matcher = сопоставитель. Сопоставляет текст с рег.
        //выражением.
        Matcher m = p.matcher(text);
        m.matches(); //проверить соответствие, проще было бы
                     //вызвать matches напрямую у строки.
                     //Этим методом, зато, можно потом
                     //смотреть содержимое групп
        //m.find(); // найти очередное вхождение рег. выр в текст.

        //пока рег. выражение находится в строке ...
        while (m.find()) {
            System.out.println("Найдено!!!");
            System.out.println(m.group()); //найденная строка
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }

}
```
