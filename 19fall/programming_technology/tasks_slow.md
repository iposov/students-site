---
type: tasks
---

# Коллекции и ассоциативные массивы

## Базовые операции со списками

Заставьте работать следующий код

```java
List<String> list1 = List.of("abc", "xyz", "ooo");

//функция распечатывает значения списка построчно. Воспользуйтесь циклом for each:
//   в списке 3 элемента
//   "abc"
//   "xyz"
//   "ooo"
printList(list1);

//функция распечатывает значения в списке вместе с их индексами. Воспользуйтесь обычным циклом
//   в списке 3 элемента
//   0: "abc"
//   1: "xyz"
//   2: "ooo"
printListWithIndices(list1);

//создать и вернуть список чисел от 1 до 20
List<Integer> list20 = createRange(20);
System.out.println("list20 = " + list20); // [1, 2, 3, ..., 20]

//эта функция должна поменять местами первый и последний элемент списка.
//Функция должна быть "чистой", это значит, что она не изменяет исходный список,
//а создает новый
List<Integer> list20swap = swapFirstAndLast(list20);
//распечатаем новый список и старый, чтобы убедиться, что старый список не изменился
System.out.println("list20swap = " + list20swap + ", but list20 = " + list20);

//эта функция аналогична предыдущей, но она ничего не возвращает, зато
//изменяет содержимое переданного списка
swapFirstAndLastInPlace(list20);
System.out.println("list20 = " + list20);

//скопируем значения из списка list1 в новый список list2
List<String> list2 = new ArrayList<>(list1);
//сделайте две версии функции, которая переворачивает список. Чистую функцию, и меняющую
//переданные значения:
List<String> list2rev = reverseList(list2);
System.out.println("list2rev = " + list2rev + ", but list2 = " + list2);
reverseListInPlace(list2);
System.out.println("list2 = " + list2);

//создадим числовой список для следующих функций. List.of создает неизменяемый список
List<Integer> ints = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);

System.out.println("ints = " + ints);
//функция должна отфильтровать четные числа из списка, оставить только нечетные
System.out.println("ints without even = " + filterEven(ints)); //[11, 33, 55, 3]
//функция должна удалить элементы с четными индексами, т.е. оставить только каждое второе число
System.out.println("ints no even indices = " + filterEvenIndices(ints)); //[22, 55, 88, 3]

//Теперь реализуйте in-place аналоги этих функций, т.е. они делают действия, изменяя переданный список
//копируем список ints, создавая новый изменяемый (mutable) список intsMutable
List<Integer> intsMutable = new ArrayList<>(ints);
System.out.println("intsMutable = " + intsMutable);
filterEvenInPlace(intsMutable);
System.out.println("intsMutable without even = " + intsMutable); //[11, 33, 55, 3]
filterEvenIndicesInPlace(intsMutable);
System.out.println("intsMutable without even indices = " + intsMutable); //[33, 3]
```

## Разные виды коллекций

Реализуйте функцию `readWordsFromFile`, чтобы работал следующий код:
```java
//при указании типа здесь можно написать Collection<String>, List<String> или ArrayList<String> 
List<String> wordsList = new ArrayList<>();
//здесь можно написать Collection<String>, Set<String> или HashSet<String>
Set<String> wordsHashSet = new HashSet<>();
Set<String> wordsLinkedHashSet = new LinkedHashSet<>();
Set<String> wordsTreeSet = new TreeSet<>();

// Эта функция открывает указанный файл и читает все слова из него в указанную коллекцию.
// Возьмите какой-нибудь большой текст на русском. Используйте Scanner для чтения слов, приводите слова к нижнему
// регистру.
// Тип второго аргумента функции должен быть Collection<String>, это означает, что передать можно
// любую коллекцию, в частности, любые списки и множества
readWordsFromFile("text.txt", wordsList);
readWordsFromFile("text.txt", wordsHashSet);
readWordsFromFile("text.txt", wordsLinkedHashSet);
readWordsFromFile("text.txt", wordsTreeSet);

System.out.println("wordsList = " + wordsList);
System.out.println("wordsHashSet = " + wordsHashSet);
System.out.println("wordsLinkedHashSet = " + wordsLinkedHashSet);
System.out.println("wordsTreeSet = " + wordsTreeSet);
```

## Ассоциативные массивы

### Ассоциативные массивы
1. Дана строка. Посчитать каждый символ, сколько раз он встретился. Например, строка "banana" должна выдать массив `Map<Character, Integer>`:

            'b' -> 1
            'a' -> 3
            'n' -> 2

1. Аналогично предыдущему, но выдать `Map<Character, List<Integer>>` со списком индексов, где встретился символ:

            b -> [0]
            a -> [1, 3, 5]
            n -> [2, 4]
            
1. Частотный словарь слов из файла. Т.е. нужно прочитать слова из файла и посчитать, сколько раз они встретились. Приводите слова к нижнему регистру перед подсчетом. Желательно использовать большой текст на русском, например, возьмите его на http://lib.ru. Используйте `Scanner.useDelimiter()`, чтобы указать сканеру, какие символы считать разделителями слов.
   * Сначала используйте `HashMap`
   * Попробуйте заменить `HashMap` на `LinkedHashMap` и на `TreeMap`. Как изменился результат?
   * (не обязательно) Исправьте программу так, чтобы она использовала все три вида массивов: HashMap, TreeMap, LinkedHashMap. Соответственно, выведите ответ три раза. Не дублируйте код.
   * (не обязательно) Выведите слова в порядке уменьшения частот. Вам потребуется отсортировать список List<Map.Entry<String, Integer>>
