import java.util.Scanner;
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

        //Проверим работу групп
        Pattern wordNumber = Pattern.compile("([a-z]+)(\\d+)");
        String text2 = """
            Какой-то текст a23 со словами xyz42 с цифрами.
            И еще таких слов немного pqr111.
            """;
        Matcher wordNumberMatcher = wordNumber.matcher(text2);
        while (wordNumberMatcher.find()) {
            System.out.println("Найдено " + wordNumberMatcher.group(0));
            System.out.println("Буквы   " + wordNumberMatcher.group(1));
            System.out.println("Цифры   " + wordNumberMatcher.group(2));
            System.out.println();
        }

        // функция replaceAll
        //заменим буквыцифры на символ точки
        System.out.println("a23 xx bc42".replaceAll("([a-z]+)(\\d+)", "."));
        //если в замене есть символ доллара, он указывает номер группы
        System.out.println("a23 xx bc42".replaceAll("([a-z]+)(\\d+)", "$1"));
        System.out.println("a23 xx bc42".replaceAll("([a-z]+)(\\d+)", "-$1-"));
        System.out.println("a23 xx bc42".replaceAll("([a-z]+)(\\d+)", "$1$2$1"));
        //0 группа = вся найденная подстрока
        System.out.println("a23 xx bc42".replaceAll("([a-z]+)(\\d+)", "[$0]"));

        // Напомним
        // Pattern wordNumber = Pattern.compile("([a-z]+)(\\d+)");
        Matcher m4 = wordNumber.matcher("a23 xx bc42");
        // нужно запомнить кусок кода:
        StringBuilder sb = new StringBuilder(); //Аналог String, но изменяемый
        while (m4.find()) {
            // Выясняем, на что заменять
            String letters = m4.group(1); // "a"
            String digits = m4.group(2); // "23"
            String replacement = letters.toUpperCase() + digits;
            // даем команду на замену
            m4.appendReplacement(sb, replacement);
        }
        m4.appendTail(sb);
        System.out.println(sb.toString()); // Преобразуем результат замен в строку

        Scanner in = new Scanner("""
                     Первое предложение.
                     Второе предложение! Еще 1 (одно), предложение, с запятыми.""");
        System.out.println(in.next()); // Первое
        System.out.println(in.next()); // предложении.
        System.out.println(in.next()); // Второе

        // по-умолчанию Scanner считает разделителями любые пробельные символы.
        // но можно задать другой разделитесь
        in.useDelimiter("[^а-яА-Я0-9]+"); //^ означает всё, кроме укзанных символов
        System.out.println(in.next()); //предложение (без !)
        System.out.println(in.next()); //Еще
        System.out.println(in.hasNextInt()); //проверям, что дальше число
        System.out.println(10 * in.nextInt()); //читаем это как число

    }

}
