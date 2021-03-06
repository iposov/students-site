---
type: tasks
---

## Задание

1. Скачать pycharm community edition. Лучше через JetBrains Toolbox, а не напрямую. Или сразу Ultimate Edition, получив лицензию для студентов на сайте jetbrains.com.
   
### Вспоминаем Python 

1. Дан *список списков* символов, например:
    ```
    [
       ['x', 'x', 'y', 'z'],
       ['.', '.', '.', '.'],
       ['@', '@', '@', '@']
    ]
    ```
   Распечатать его на экране в виде набора символов по строкам:
    ```
    xxyz
    ....
    @@@@
    ```
1. Создать список списков для прошлой задачи, который при распечатывании будет выглядеть как квадрат 16 на 16 из точек, внутри которого ровно в середине еще один квадрат 8 на 8 из символов `#`:
   ```
   ................
   ................
   ................
   ................
   ....########....
   ....########....
   ....########....
   ....########....
   ....########....
   ....########....
   ....########....
   ....########....
   ................
   ................
   ................
   ................
   ``` 
   
1. Еще задачи на то, чтобы вспомнить python, ищите на сайте [codingbat.com](http://codingbat.com). Выбирайте раздел с python, пробуйте задачи разной сложности. Английский переводите сами, с помощью друзей, меня или с помощью google translate.  
   
### Генераторы

1. Создать генератор бесконечной последовательности, в которой сначала идет одна единица, потом две двойки, потом три тройки и т.д.: 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, ...
1. Создать функцию-генератор `split`, которая получает на вход строку, и возвращает по очереди слова этой строки. Слова разделены пробелами. Функция должна вычислять слова постепенно, не храня их в памяти, т.е. нельзя вызвать split у строки, а потом возвращать постепенно элементы.
   
     Добавьте print() внутри функции для каждого найденного в строке слова, чтобы в будущем видеть, в какой момент реально произошло выделение очередного слова из строки. Это нужно для целей отладки.
1. Напишите выражение-генератор, которое берет генератор слов из прошлой задачи и приводит каждое слово к нижнему регистру. Возьмите из него три первых слова и убедитесь, что при этом не вычисляются следующие слова. 
1. Создать функцию, которая получает на вход генератор и число. Она возвращает
    1. список из не более чем стольких элементов исходного генератора
    2. генератор из не более чем стольких элементов исходного генератора

   Например, если есть генератор чисел фибоначчи, то вызов take(10, fib()) должен вернуть `[1, 1, 2, 3, 5, 8, 13, 21, 34, 55]`
   
### Функции и лямбда выражения

1. Сделайте функцию `fun_min` для поиска минимума другой функции. `fun_min` получает на вход целые числа x1, x2, и функцию f. Функция f получает числа и возвращает числа.
   Нужно перебрать все числа от x1 до x2 и найти, на каком из них f дает минимальный результат. Например, `fun_min(0, 10, lambda x: x * (x - 10))` должно вернуть 5.
   
1. Поиск корня, для специалистов по математическому анализу. Функция `find_root` должна получать те же аргументы, что и в прошлой задаче. При этом `f(x1)` и `f(x2)` должны иметь разные знаки, а функция `f` должна быть непрерывна. Найдите корень функции f, деля отрезок (x1,x2) пополам и определяя на каждом шаге, в какой из половин лежит корень. Продолжать нунжо, пока отрезок с корнем не станет меньше чем `1e-8`. 

1. У вас есть устройство с двумя регистрами X и Y. После запуска устройства в них находятся числа 0. Устройство умеет выполнять следующие команды:
    * `print` распечатывает значения регистров `X=, Y=`
    * `+1` увеличивает регистр X на 1.
    * `mov` записывает в регистр X значение из Y
    * `add` добавляет к значению в регистре X значение из Y.
    * `swap` меняет местами значения регисторв X и Y
    * придумайте еще, если хотите
    
    Напишите функцию interpret, которая получает на вход программу в виде строки для устройства и выполняет ее. Например,
`interpret("+1 +1 swap +1 add print")` выведет `X=3 Y=2`.
   
   Решать нужно следующим образом. Используйте словарь, в котором названия операций — это ключи, а значения — это функции, которые получают на вход значения X и Y, а возвращают кортеж из двух новых значений X и Y.  

1. Сделайте функцию рисования графиков `plot`, которая получает на вход числа x1, x2, y1, y2 и функцию f. Функция f должна получать на вход целое число и возвращать целое число.
   Например,
   ```
   def f(x):
      return x + 1
   
   print(plot(0, 10, 0, 10, f))
   print(plot(0, 10, 0, 10, lambda x: x + 1))
   ```
   Функция plot должна возвращать график функции f при x меняющемся от x1 до x2. График - 
это строка, которая при распечатке выглядит как график функции. В обоих случаях должен получиться такой результат:
   
    ```
    .........#.
    ........#..
    .......#...
    ......#....
    .....#.....
    ....#......
    ...#.......
    ..#........
    .#.........
    #..........
    ...........
    ```
    Здесь левый столбец соответствует `x=x1=0`, правый соответствует `x=x2=10`. Нижняя
   строчка соответствует `y=y1=0`, верхняя — `y=y2=10`.
   
1. Решите еще раз предыдущую задачу, но функуция не должна принимать y1 и y2, вместо этого она сама определяет минимальное и максимальное значение функции.
