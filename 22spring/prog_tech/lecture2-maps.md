# Map, Ассоциативные массивы

Аналоги `dict` в Python. Синтаксически в Java работа с ассоциативными массивами значительно длиннее.

Тип ассоциативных массивов: `Map<K, V>`, например, `Map<String, Integer>`, это означает, что ключи в массиве — строки, а значения — целые числа:

```
Map<String, Integer> love = Map.of("cat", 100, "dog", 100, "coffee", 10, "tea", 40);
// в Python: {"cat": 100, "dog": 100, "coffee": 10, "tea": 40}

```

Как и в коллекциях, то, что получается через `of()` — это неизменяемый ассоциативный массив. Но можно создать обычные:

```
Map<String, Integer> love1 = new HashMap<>();
Map<String, Integer> love2 = new LinkedHashMap<>();
Map<String, Integer> love3 = new TreeMap<>();

love1.put("cat", 100);
love1.put("dog", 100);
love1.put("coffee", 10);
love1.put("tee", 40);

System.out.println(love1);
```

`HashMap`, `LinkedHashMap`, `TreeMap` различаются так же, как соответствующие множества. Порядком перебора ключей (см. множества).


Для получения значения есть метод `get`, он возвращает
значение по ключу или `null`, если значения нет:

```
System.out.println(love1.get("cat")); // ? 100
System.out.println(love1.get("aardvark")); // ? null

// получить значение по ключу, или значение по умолчанию, если ключа нет
System.out.println(love1.getOrDefault("dog", 0));  // 100
System.out.println(love1.getOrDefault("aardvark", 0));  // 0

```

Метод `remove` удаляет элемент по ключу:

```
love1.remove("dog"); // убрать ключ собака
System.out.println(love1);
```

## Перечисление элементов ассоциативного массива

Способ 1. Перечисляем ключи. Метод `keySet()` возвращает множество всех ключей массива:

```
// Map<String, Integer> love
// love.keys()
for (String key : love.keySet())
    System.out.println(key + " -> " + love.get(key));
```

Способ 2, перебираем записи (ключ, значение)

В Python:
```
a = {"cat": 100, "dog": 100, "coffee": 10, "tea": 40}
for key, value = a.items():
   print(f'{key} -> {value}')
```

В Java есть метод `entrySet`, но в Java нет тьюплов (кортежей), чтобы так просто перечислить пары из ключей и значений. Реально перечисляются значения типа `Map.Entry<String, Integer>`:

```
for (Map.Entry<String, Integer> entry : love.entrySet())
    //entry.getKey() и entry.getValue() - ключ и значение
    System.out.println(entry.getKey() + " -> " + entry.getValue());
// вспоминаем, что в java локальные переменные можно вводить через var

for (var entry : love.entrySet())
    //entry.getKey() и entry.getValue() - ключ и значение
    System.out.println(entry.getKey() + " -> " + entry.getValue());
```

Способ 3. Функциональный, через лямбда-выражения

```
love.forEach((key, value) -> {
    // в фигурных скобках пишем, как будто у нас функция с аргументами
    // (String key, int value)
    System.out.println(key + " -> " + value);
});

// если в фигурных скобках одно действие, их можно опустить:
love.forEach((key, value) -> System.out.println(key + " -> " + value));
```

# Объектно-ориентированное программирование

Напоминание: [Книги](https://github.com/iposov/students-site/tree/master/22spring/prog_tech/src/ru/spbu/arts/oop/books), [Животные](https://github.com/iposov/students-site/tree/master/22spring/prog_tech/src/ru/spbu/arts/oop/animals)

## Абстрактные классы
[Животные c abstract class Animal](https://github.com/iposov/students-site/tree/master/22spring/prog_tech/src/ru/spbu/arts/oop/abstractanimals)
