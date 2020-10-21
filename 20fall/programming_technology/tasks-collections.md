---
type: tasks
---

### Коллекции

1. Создать список `List<Integer>` из чисел от 1 до 100. Здесь и везде реализуйте функцию, которая решает задачу. В main методе
вызовите ее для проверки.
    ```
    List<Integer> list100 = create100();
    System.out.println("list100 = " + list100); // [1, 2, 3, ..., 100]
    ```
1. Сделайте функцию, которая распечатывает длину списка и его значения построчно. Используйте цикл `for each`
    ```
    List<String> list1 = List.of("abc", "xyz", "ooo");
    
    // на экране появится
    //   Элементов в списке: 3
    //   abc
    //   xyz
    //   ooo
    printList(list1);
    ```
1. Аналогично предыдущему, но вместе с элементами печатаются их индексы. Здесь можете использовать любой цикл.
    ```
    List<String> list2 = List.of("abc", "xyz", "ooo");
    
    // на экране появится
    //   Элементов в списке: 3
    //   1: abc
    //   2: xyz
    //   3: ooo
    printListWithIndices(list1);
    ```   
1. Сделайте функцию, которая получает два списка и возвращает один, состоящий из двух заданных. Склеивает списки.
    ```
    List<String> list3 = List.of("aaa", "bbb", "ccc");
    List<String> list4 = List.of("xxx", "yyy", "zzz");
    List<String> list3plusList4 = concatenateLists(list3, list4);
    System.out.println(list3plusList4); //aaa bbb ccc xxx yyy zzz
    // можно не проверять, что исходные списки не изменились, потому что List.of()
    // создает неизменяемый список. Но можно и проверить:
    System.out.println(list3); //aaa bbb ccc
    System.out.println(list4); //xxx yyy zzz
    ```
1. Дан список, верните новый список, в котором все элементы идут в обратном порядке.
Сделайте две версии задачи: чистую функцию и функцию, которая меняет заданный список.
    ```
    //созадем изменяемый список list5.
    List<String> list5 = new ArrayList<>(List.of("first", "middle", "last"));
    //сначала чистая функция
    List<String> list5rev = reverseList(list5);
    //проверяем, что list5rev перевернутый, а list5 остался без изменений.
    System.out.println("list5rev = " + list5rev + ", but list5 = " + list5);
   
    //теперь функция, которая меняет сам список
    reverseListInPlace(list5);
    //проверяем, что список действительно изменился
    System.out.println("list5 = " + list5);
    ```
    <!--   
    1. Сделайте функции, которые меняют местами первый и последний элементы списка. Как и раньше,
    реализуйте два варианта: чистую функцию, и функцию, которая изменяет переданный список.
        ```
        List<Integer> list6 = new ArrayList<>(List.of(10, 20, 30, 40, 50, 60));
        List<Integer> list6swap = swapFirstAndLast(list6);
        //распечатаем новый список и старый, чтобы убедиться, что старый список не изменился
        System.out.println("list6swap = " + list6swap + ", but list6 = " + list6);
        
        //а теперь изменим список
        swapFirstAndLastInPlace(list6);
        System.out.println("list6 = " + list6);
        ```
        -->   
1. Сделайте по две версии следующих трех функций: чистую функцию и функцию, которая меняет заданный список.
   * Дан `List<String>`, удалите в нем все элементы с четным индексом.   
   * Дан `List<String>`, удалить в нем все элементы, которые являются четными числами
   * Дан `List<Integer>`, удалить в нем все элементы, которые являются четными числами

    ```
    List<String> ints = List.of("11", "22", "33", "55", "66", "88", "100", "3", "4");
    
    System.out.println("ints = " + ints);
    //функция должна удалить элементы с четными индексами, т.е. оставить только каждое второе число
    System.out.println("ints no even indices = " + filterEvenIndices(ints)); //["22", "55", "88", "3"]
    //функция должна удалить четные числа
    System.out.println("ints without even = " + filterEven(ints)); //["11", "33", "55", "3"]
    //теперь удалим четные числа, но в списке уже из Integer:
    List<Integer> ints2 = List.of(11, 22, 33, 55, 66, 88, 100, 3, 4);
    System.out.println("ints without even = " + filterEven2(ints2)); //[11, 33, 55, 3]
    
    // В этой части мы проделаем то же самое, но с функциями, которые изменяют переданные списки.
    // слово mutable означает "изменяемый", потому что в этой части мы будем использовать списки,
    // которые можно изменять.
    System.out.println(" ============= mutable lists =================== ");
    
    List<String> mutableInts = new ArrayList<>(ints);
    mutableFilterEvenIndices(mutableInts);
    System.out.println("ints no even indices = " + mutableInts); //["22", "55", "88", "3"]
    
    mutableInts = new ArrayList<>(ints);
    mutableFilterEven(mutableInts);
    System.out.println("ints without even = " + mutableInts); //["11", "33", "55", "3"]
   
    List<Integer> mutableInts2 = new ArrayList<>(ints2);
    mutableFilterEven2(mutableInts2)); 
    System.out.println("ints without even = " + mutableInts2); //[11, 33, 55, 3]
    ```

1. Взять текстовый файл, желательно большой на русском. Прочитать из него все слова, каждое слово привести к нижнему регистру и
   сохранить в множестве `HashSet`. Вывести все слова.
   * Повторите аналогичные действия для `TreeSet`, `LinkedHashSet`. Т.е. Ваша программа должна читать текстовый файл три раза.
   Убедитесь, что вы не дублируете код, и не скопировали программу три раза для каждого из видов множества. Для этого
   создайте три разных множества и передавайте их в функцию следующим образом:
   
    ```
    Set<String> hashSet = new HashSet<>();
    Set<String> linkedHashSet = new LinkedHashSet<>();
    Set<String> treeSet = new TreeSet<>();
    
    doReadWordsInFile("a.txt", hashSet);
    doReadWordsInFile("a.txt", linkedHashSet);
    doReadWordsInFile("a.txt", treeSet);
    ```
