package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptoinsExamples2 {

    public static void main(String[] args) {
        System.out.println("начался main");
        // обработка исключения, блок try. Если внутри блока произошло исключение,
        // блок завершается и управление передается в блок catch после try
        try {
            initialize();
            //если в initialize была ошибка, блок try дальше не выполняется
            //внутри try оптимистичный сценарий
            System.out.println("инициализация прошла успешно");
        } catch (IOException e) {
            // catch (IOException e), т.е. в этом блоке ловятся только исключения
            // типа IOException, в частности FileNotFoundException
            System.out.println("не удалось прочитать файл: " + e.getMessage());
            // переменная e хранит информацию об ошибке.
            //e.printStackTrace(); //это печать стека, тот самый красный текст
            //это очень удобно для отладки
        }
        //это строка выполнится точно, она после try
        System.out.println("закончился main");
    }

    private static void initialize() throws IOException {
        System.out.println("начался initialize");
        initializeInterface();
        System.out.println("закончился initialize");
    }

    private static void initializeInterface() throws IOException {
        System.out.println("начался initializeInterface");
        readSettings();
        System.out.println("закончился initializeInterface");
    }

    private static void readSettings() throws IOException {
        System.out.println("начался readSettings");
        readFile("a.txt");
        System.out.println("закончился readSettings");
    }

    // в заголовке написали throws IOException
    // значит, мы говорим явно, что при вызове этого метода
    // может возникнуть исключение
    private static void readFile(String fileName) throws IOException {
        System.out.println("начался readFile, читаем " + fileName);
        Files.readString(Paths.get(fileName));
        // обязаны отреагировать на то, что может быть IOException при
        // вызове readString
        System.out.println("закончился readFile");
    }
}
