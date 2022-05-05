package ru.spbu.arts.exceptions;

/*
    Функция, которая будет печатать указанную фразу указанное количество раз,
    но она не будет согласна печатать что угодно 13 раз.
 */
public class ExceptionsExample {
    public static void main(String[] args) throws Exception {
        // исключение в repeat может возникнуть, поэтому нужно либо обработать, либо сказать, что не будем обрабатывать
        repeat("2 + 2 = 4", 4); // выполнилось
        repeat("2 * 2 != 5", 6); // выполнилось
        repeat("2 * 2 != 13", 13); // ошибка !!!
        repeat("2 * 2 != 100", 100); // программа до сюда не доходит
    }

    // В заголовке есть throws Exception — это явное указание, что в функции может возникнуть Exception,
    // и функция его не обрабатывает
    private static void repeat(String text, int count) throws Exception {
        if (count == 13)
            //бросаем исключение, говорим, что возникла исключительная ситуация.
            //вместо Exception можно использовать другие классы, IOException, IllegalArgumentException
            throw new Exception("I don't like 13");
        // если возникла ошибка, программа до сюда не доходит
        // throw - как return, только не возвращается результат
        for (int i = 0; i < count; i++)
            System.out.println(text);
    }
}
