package exceptions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ExceptoinsExamples1 {

    public static void main(String[] args) throws IOException {
        System.out.println("начался main");
        initialize();
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
