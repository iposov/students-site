# Ввод и вывод в Java

InputStream / OutputStream - абстрактные потоки байт.
input - байты, которые мы читаем.
output - байты, которые мы записываем.
примеры потоков байт: файл, адрес в Интернете, символы с 
клавиатуры и т.п., ресурсы программы.

Reader / Writer. Аналогично, но это потоки не байт, а
символов
Reader всегда можно превратить в InputStream и наоборот,
Writer всегда можно превратить в OutputStream и наоборот,
только при этом необходимо указывать кодировку.

методы InputStream:

    int read(); //прочитать очередной байт.
                //-1 возвращается, если поток закончился
                //иначе числа от 0 до 255.
    int read(byte[] buffer)
                //прочитать байты в массив buffer.
                //возвращается, сколько реально байт
                //прочиталось. (читается мало, если поток
                //закончился)
                
OutputStream - аналогично, но write
Reader, Writer - аналогично, но читается int, который
                 можно превратить в char
                 
BufferedInputStream
BufferedOutputStream
BufferedReader
BufferedWriter

это классы, которые хранят часть потока в своем буффере
(массив байт или символов). Это нужно для быстродействия.
Кроме того, имеют полезные методы типа Write, Writeln,
Readln и т.п., чтобы писать или читать
сразу String, а не посимвольно.

Удобней всего, конечно, читать Scanner, писать PrintStream,
но это только для текстовых файлов. Кроме того, Scanner
очень медленный.

FileInputStream, FileOutputStream - это потоки, связанные
с файлом. `new FileInputStream("a.txt")` - это поток
байт из файла a.txt

InputStreamReader - превращает InputStream в Reader

    Reader r = new InputStreamReader(
            new FileInputStream("a.txt"),
            "utf-8" //кодировка
    );
    
Т.е. как, например, читать файл построчно, не используя
Scanner:

    try (BufferedReader in = new BufferedReader(
        new InputStreamReader(
                new FileInputStream("a.txt"),
                "utf-8"
        )
    )) {
        while (true) {
            String line = in.readLine();
            if (line == null) //конец файла
                break;
            sout(line); //выводим на экран прочитанное
        }
    }

Классы, которые мы только что обсуждали, были в Java
с самого начала, поэтому они часто встречаются.
Но этими классами неудобно пользоваться, даже операция
копирования файла требует много кода.
    
## Современный ввод/вывод
см. класс io.ModernInputOutput