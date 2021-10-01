import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner; // аналогично import в Python
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FileReadWriteExamples {

    // Дописываем throws Exception в заголовок всех методов,
    // которые работают с файлами
    public static void main(String[] args) throws Exception {
        readFileExample(); // прочитай пример файла
    }

    // Дописываем throws Exception в заголовок всех методов,
    // которые работают с файлами
    private static void readFileExample() throws Exception {
        //заводим переменную типа Path для хранения пути к файлу
        Path txt = Path.of("read-write-example.txt");
        try (Scanner in = new Scanner(txt, StandardCharsets.UTF_8)) {
            String line1 = in.nextLine(); // прочитать строку nextLine() или next() слово
            String line2 = in.nextLine(); // прочитать следующую
            System.out.println(line1);
            System.out.println(line2);
        }
    }

}
