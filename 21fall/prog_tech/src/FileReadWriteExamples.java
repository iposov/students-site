import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner; // аналогично import в Python

public class FileReadWriteExamples {

    // Дописываем throws Exception в заголовок всех методов,
    // которые работают с файлами
    public static void main(String[] args) throws Exception {
        readFileExample(); // прочитай пример файла

        //еще возможности по чтению. Вспомогательный класс `Files`
//        Files.readAllBytes() - прочитать как массив byte
//        Files.readString() - прочитать как строку весь файл
//        Files.readAllLines() - прочитать все строки

        writeFileExample();

        //Files.writeString() - записать строку как один файл с этой строкой
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

            if (in.hasNextInt()) {
                int y = in.nextInt();
                System.out.println("прочитали число " + y);
            } else {
                System.out.println("в файле дальше не число");
            }

            while (in.hasNext()) {
                String word = in.next();
                System.out.println("Прочитано слово " + word);
            }
        }
    }
}
