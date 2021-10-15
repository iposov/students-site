import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExamples {

    public static void main(String[] args) {
        System.out.println("abc".matches("abc"));
        System.out.println("abc".matches("abc|xyz|pqr"));
        System.out.println("pqr".matches("abc|xyz|pqr"));
        System.out.println("123".matches("abc|xyz|pqr"));
        String time = "((0|1)\\d|20|21|22):(0|1|2|3|4|5)\\d";
        System.out.println("21:34".matches(time));

        String pattern = "\\d{10}"; // `\d{10}`.
        String filePathPattern = "[A-Z]:\\\\[A-Za-z]+\\\\[A-Za-z]+\\.txt";
        System.out.println("C:\\Windows\\a.txt".matches(filePathPattern));

        String text = "23:16 and 12:54 and 77:88, hello";
        Pattern timePattern = Pattern.compile("(\\d\\d):(\\d\\d)");
        Matcher m1 = timePattern.matcher(text);
        Matcher m2 = timePattern.matcher("44:55");

        //проверка, соответствует ли строка шаблону. Возвращает true|false
        System.out.println(m1.matches()); // false
        System.out.println(m2.matches()); // true, действительно, строка времени

        Matcher m3 = timePattern.matcher(text);
        boolean found = m3.find(); // вернет true, если нашел
        System.out.println(found);
        System.out.println(m3.group()); // найденная подстрока
        System.out.println(m3.start()); // индекс начала
        System.out.println(m3.end()); // индекс конца

        // чтобы найти следующий, делаем снова find

        found = m3.find(); // вернет true, если нашел еще один
        System.out.println(found);
        System.out.println(m3.group()); // найденная подстрока
        System.out.println(m3.start()); // индекс начала
        System.out.println(m3.end()); // индекс конца

        // обычно делают
        while (m3.find()) {
            System.out.println(m3.group());
            System.out.println(m3.start()); // индекс начала
            System.out.println(m3.end()); // индекс конца
        }
    }

}
