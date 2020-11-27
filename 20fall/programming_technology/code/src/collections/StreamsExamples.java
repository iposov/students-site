package collections;

import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String[] args) {
        //Поток — это набор значений, примерно как в коллекциях, но, в отличие
        //от коллекций он
        // 1) не обязательно хранится в памяти
        // 2) обрабатывается только последовательно, элемент за элементом.
        //    вернуться к просмотренным элементам невозможно.
        // Потоки, в отличие от коллекций, потенциально могут даже быть бесконечными.

        // поток из слов
        Stream<String> wordsStream = Stream.of("hello", "world", "cat", "banana",
                "pneumonoultramicroscopicsilicovolcanoconiosis");

        wordsStream.forEach(word -> System.out.println(word));

        //больше ничего с этим потоком уже не сделать
//        wordsStream.forEach(word -> System.out.println(word.length()));
        // Ошибка!! нельзя второй раз перебрать элементы потока.

        Stream<Integer> naturals = Stream.iterate(1, x -> x + 1);
        //поток натуральных чисел. Сначала 1, каждое следующее - это предыдущее плюс 1

        naturals
                .takeWhile(x -> x < 100) //получаем другой поток, в котором
                //элементы идут только пока они меньше 10
                .forEach(num -> System.out.println(num));
    }

}
