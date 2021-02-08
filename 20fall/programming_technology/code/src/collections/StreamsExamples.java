package collections;

import java.util.*;
import java.util.stream.*;

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
                //элементы идут только пока они меньше 100. Он конечный.
                .forEach(num -> System.out.println(num));

        // Операции над потоками бывают двух видов: операции-преобразования
        // и терминальные операции. Первые «изменяют» поток, т.е. в результате
        // у вас все равно остается поток. Пример выше: takeWhile
        // Терминальные операции делают какие-то действия над всеми элементами потока
        // и над одним потоком можно выполнить только одну терминальную операцию.
        // Ровно одну, обязетельно нужна одна терминальная операция,
        // потому что зачем иначе создавался поток?
        //
        //
        //
        //

        // Примеры операций-преобразований.
        System.out.println("----- операции преобразования ------");
        Stream
                .iterate(1, x -> x + 1) // принято каждую операцию писать в новой строке
                .filter(x -> x % 2 == 1) // указывает, что нужно удалить элементы, которые не подходят под условие
                // оставляем только нечетные числа. Integer -> Boolean
                .filter(x -> { // оставим только числа, которые не кончаются на 1
                    int lastDigit = x % 10;
                    return lastDigit != 1;
                })
                .map(x -> x + 1) // указывает, на что заменить каждый элемент
                .takeWhile(x -> x < 100)
                .map(x -> "Число " + x) // Был Stream<Integer>, стал Stream<String>
                .forEach(x -> System.out.println(x));

        System.out.println("----- Еще несколько преобразований -----");

        Stream
                .iterate(1, x -> x + 1)
                .map(x -> x / 2)
                .distinct() // взять различные элементы
                .limit(100) // взять 100 первых элементов
                .forEach(x -> System.out.println(x));

        // еще есть sorted(), отсортировать элементы

        // Что же за вариант исправления от Idea?
        // Мы пишем x -> System.out.println(x), предлагает System.out::println
        // Это еще один способ записи лямбда выражений.
        //
        // В общем случае, если вы пишете объект::функция это
        // то()же самое, что (x,y,z) -> объект.функция(x,y,z)
        // Класс::статич_метод это (x,y,z) -> Класс.статич_метод(x,y,z)
        // Класс::обычный_метод это (o,x,y,z) -> o.обычный_метод(x,y,z)

        // Потоки базовых типов. До этого были потоки объектных типов: Stream<T>.
        // Получается, что для целых чисел нужен Stream<Integer>. Это неудобно,
        // также неудобно как List<Integer>. Для базовых типов есть отдельные классы
        // типа IntStream, DoubleStream и т.п.
        IntStream.of(1, 2, 10, 20, 30, 50).forEach(System.out::println);
        DoubleStream.of(1.2, 3.4).forEach(System.out::println);
        LongStream.of(1_000_000_000_000L, 2_000_000_000_000L).forEach(System.out::println);

        Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .map(String::length) // это Stream<Integer>, потому что
                // map берет Stream<T> и делает Stream<Q>
                .mapToInt(integer -> integer) // превращает Integer в int, происходит
                // разворачивание. Теперь это IntStream
                .forEach(num -> System.out.println("длина " + num));

        // можно было сразу:
        Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .mapToInt(String::length) // это IntStream
                .forEach(num -> System.out.println("длина " + num));

        // терминальные операции
        // forEach - см. выше. Аналог цикла

        // collect - означает собрать все элементы потока в какую-то
        // единую сущность. Чаще всего — в список.
        // но можно собрать в множество, в ассоциативный массив, в
        // Объект со статистической информацией.
        // Сбором всех элементов занимаются коллекторы Collector.
        // Можно делать свои коллекторы, хотя это непросто, потому что
        // нужно написать много кода про то, как именно собирать.
        // Чаще всего достаточно взять готовый коллектор из класса Collectors

        //соберем в список
        final List<String> list = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .collect(Collectors.toList()); // еще есть toSet

        final Map<String, Integer> map = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                // указываем, какой у каждого слова ключ, какое значение
                .collect(Collectors.toMap(word -> word, String::length));
        System.out.println(map);

        String joined = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .collect(Collectors.joining("+")); // Как в python: "+".join([1, 2, 3])
                                               //"1+2+3"
        //Но лучше делайте String.join, он недавно появился
//        String.join("+", "asdf", "fdas", "243wer", "sdaads");
//        или
//        String.join("+", коллекция строк);
        System.out.println(joined);

        final Double mean = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .collect(Collectors.averagingInt(String::length));
        System.out.println(mean);

        final IntSummaryStatistics statistics = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .collect(Collectors.summarizingInt(String::length));

        System.out.println(statistics);

        // У IntStream и подобных потоков коллекторы другие, ищите их отдельно
//        IntStream.of(1, 2, 3).collect()

        // еще несколько терминальных операций
        final Object[] words1 = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .toArray();//в массив

        final String[] words2 = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                .toArray(l -> new String[l]); //если нужен массив не Object,
                                              //передаем ф-ию, которая создает
                                              //массив указанного размера

        // Преобразования коллекций, потоков в массивы и обратно, всегда есть
        // какие-то хитрости

        // еще терминальные операции min, max. Но нужен сравниватель
        final Optional<String> shortestWord = Stream
                .of("hello", "world", "cat", "banana",
                        "pneumonoultramicroscopicsilicovolcanoconiosis")
                //хочу, чтобы слова с меньшей длиной были меньше.
                .min((w1, w2) -> w1.length() - w2.length());//Comparator.comparingInt(String::length)

        System.out.println(shortestWord);
        //Optional<String> вместо String потому что результата может не быть, если поток
        //пустой

        Optional<String> noAnswer = Stream
                .<String>of() //пришлось написать <String>, потому пустой of() не понимает,
                              //что это поток именно строчек
                .min((w1, w2) -> w1.length() - w2.length());

        System.out.println(noAnswer);

        String realWord = shortestWord.get(); //узнать реальную строку, которая внутри
        //но принято проверять
        if (noAnswer.isPresent())
            System.out.println("Самое короткое слово в пустом списке это " + noAnswer.get());
        else
            System.out.println("В пустом списке нет самого короткого слова");
    }

}
