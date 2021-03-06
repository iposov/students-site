# Алгоритмы для реализации

Курс на [repl.it](https://repl.it/data/classrooms/share/9a361fad6356e308ceee03c12f926f64)
В задачах на этом сайте ожидается, что входные данные приходят
из стандартного ввода, а выводиться должны в стандартный вывод.
Это позволяет проверить правильность программы автоматически на
сайте.

Если у задачи есть дополнительные тесты,
они распространяются в виде набора
файлов с расширениями, соответственно, `in` и `out`. Для
проверки решения необходимо запускать программу следующим
образом:

`program.exe <test.in >program.out`

Для проверки правильности ответа:

`diff program.out test.out`

Это сравнит вывод программы и правильный ответ.

Либо вы можете пользоваться возможностями среды
разработки, чтобы она при отладочном запуске программы
перенаправляла стандартный ввод и вывод.

## Алгоритмы на графах

### Алгоритм Краскала
Описание в [Викиконспекты ИТМО](https://neerc.ifmo.ru/wiki/index.php?title=%D0%90%D0%BB%D0%B3%D0%BE%D1%80%D0%B8%D1%82%D0%BC_%D0%9A%D1%80%D0%B0%D1%81%D0%BA%D0%B0%D0%BB%D0%B0)

Реализуйте алгоритм Краскала, учтите следующее:
1. Для хранения графа используйте структуру данных "ребро",
она должна хранить номера своих вершин и свой вес.
1. Храните для каждой вершины список ребер, которые
с ней связаны.
1. Для проверки того, что ребро
соединяет две разных компоненты связанности, используйте
наивную реализацию: в ней нужно хранить компоненты связности
как множества (set) вершин. При объединении компонент
связности нужно объединять множества.
1. После того, как решите следующую задачу, замените
наивную реализацию на реализацию через лес непересекующихся
множеств. Обратите внимание, насколько сложно в вашем
коде было сменить одну реализацию на другую. И убедитесь,
что тесты из архива стали проходить значительно быстрее.

Пример входных данных. Граф задан как последовательность
чисел. Сначала даны два числа - количество
вершин `v` и количество ребер графа `e`. После этого
даны `e` троек чисел с описанием ребер. Это два числа
с номерами вершин (нумерация с нуля) и вес ребра.

Пример входных данных
```
3 3
0 1 10
1 2 20
0 2 30
```

В выводе необходимо указать сначала количество ребер в ответе,
потом суммарный вес ребер и дальше необходимо перечислить
ребра в порядке, в котором их добавлял алгоритм Краскала.
При выводе ребра напишите два числа - номер меньшей,
а потом номер большей вершины.

Для указанного ввода ответом будет:
```
2 30
0 1
1 2
```

### Структура данных: система непересекающихся множеств
Описание в [Викиконспекты ИТМО](https://neerc.ifmo.ru/wiki/index.php?title=%D0%A1%D0%9D%D0%9C_(%D1%80%D0%B5%D0%B0%D0%BB%D0%B8%D0%B7%D0%B0%D1%86%D0%B8%D1%8F_%D1%81_%D0%BF%D0%BE%D0%BC%D0%BE%D1%89%D1%8C%D1%8E_%D0%BB%D0%B5%D1%81%D0%B0_%D0%BA%D0%BE%D1%80%D0%BD%D0%B5%D0%B2%D1%8B%D1%85_%D0%B4%D0%B5%D1%80%D0%B5%D0%B2%D1%8C%D0%B5%D0%B2))

[Набор тестов](union-find%20forest/tests.zip)

При реализации

1. для хранения системы множеств используйте массив длины,
равной количеству элементов. Значение массива `a[i]` - это
номер элемента представителя множества для элемента `i`.
Сначала `a[i] = i`, т.е. каждый элемент является своим
представителем.
1. используйте только одну, самую эффективную
эвристику. В функции find() после нахождения представителя
замените все ссылки в пути на этого представителя. 

*Входные данные*. Сначала дается `n` - количество элементов
множества. Далее даётся `n-1` пара чисел. Каждое число
пары означает номер элемента (с нуля), для которого 
надо найти множество. Два множества нужно объединить.
После каждой пары множеств нужно вывести, верно ли,
что элемент 0 и элемент `n-1` содержатся в одном множестве:
`YES` или `NO`:

Пример ввода:
```
4
0 1
2 3
1 2
``` 

Пример вывода:
```
NO
NO
YES
```

### Обходы графа

Обход графа - это перебор вершин в определенном порядке. Разные обходы графа позволяют
решать разные задачи, мы попробуем реализовать несколько алгоритмов, основанных на обходах
графа.

При обходе графа используется структура данных типа стека или очереди. Обход с очередью
называется поиском в ширину, а обход со стеком - поиском в глубину.
В процессе обхода вершинам назначаются цвета в зависимости от того, побывала ли вершина
в структуре данных. Сначала все вершины белые. При попадании в структуру данных вершина
становится серой. После удаления - черной. 

Ну и, наконец, во время обхода графа мы будем нумеровать вершины в порядке их посещения.

Cхема обхода:

```
v = стартовая вершина для обхода
d = СТЕК или ОЧЕРЕДЬ или что-то еще 
in = массив номеров вершин
color = массив посещенных вершин
d.push(v)
color[v] = серый

while d не пуст: 
    u = d.pop()
    if color[u] == черный
        continue
    color[u] = черный
    in[u] = очередной номер 
    for вершины w, такие что uw-ребро
        if color[w] != черный
            color[w] = серый
            d.push(w)
```            

* Идея поиска в глубину состоит в том, что мы начинаем с определенной вершины, и движемся
от нее по ребрам, пока получается приходить в новые вершины. Если пришли в вершину, 
из которой нельзя попасть в новую, возвращаемся назад и снова пытаемся пойти уже по новому пути.
* Идея поиска в ширину состоит в том, что сначала посещается начальная вершина, потом
посещаются все ее соседи, потом посещаются соседи соседей и т.д. 

Аналогичный результат можно получить без разделения цветов на серый и черный,
и код можно укоротить, но короткий код будет различаться для поиска в глубину и в ширину.

Ниже приведены примеры графа с двумя обходами. Числа на вершинах - это номера, присвоенные
во время обхода. В графе поиска в глубину пока что игнорируйте
красные стрелки и правую цифру.

|Исходный граф|Поиск в глубину|Поиск в ширину|
|------|----|-----|
|![Исходный граф](graph%20searches/graph-example.svg)|![Поиск в глубину](graph%20searches/graph-dfs.svg)|![Поиск в ширину](graph%20searches/graph-bfs.svg)|

### Алгоритмы, основанные на поиске в ширину

#### Минимальный путь в графе без весов

С помощью обхода в ширину можно найти расстояния от одной вершины до всех остальных.
Под расстоянием между двумя вершинами здесь понимается минимальное количество ребер, которое
необходимо пройти от одной вершины до другой.

Приведем в таблице расстояние от вершины a до других вершин:

|Расстояние|Вершины|
|---|---|
|0|`a`|
|1|`bh`|
|2|`dcijk`|
|3|`emgfk`|

Обход в ширину перебирает вершины в порядке увеличения расстояния.

Алгоритм:
1. Завести массив `dist`, в котором для каждой вершины хранится расстояние от нее
до `a`. Изначально все расстояния $\infty$, кроме расстояния до `a`, оно равно 0.
1. При добавлении в очередь вершины `w` нужно сразу присвоить:
`dist[w] = dist[u] + 1`.
1. Если требуется найти расстояние до конкретной вершины, то можно
остановить алгоритм, как только будет первый раз заполнен `dist`
для этой вершины. Иначе, если нужно найти расстояние от `a` до всех вершин,
обход в ширину нужно совершить до конца.

#### Минимальный путь в графе с весами, алгоритм Дейкстры

Если для каждого ребра задана его длина, то меняется определение расстояния.
Теперь расстояние между двумя вершинами - это минимальная сумма длин ребер,
которые надо пройти, чтобы попасть из первой вершины во вторую.

Алгоритм Дейкстры позволяет вычислить расстояния от одной вершины
до всех остальных.

1. Вместо очереди необходимо использовать другую структуру данных: очередь
с приоритетами. В эту структуру данных при добавлении вершины вместе с
вершиной добавляется ее "приоритет". При извлечении вершины извлекается вершина
с максимальным приоритетом. Найдите в стандартной библиотеке своего языка
программирования такую структуру данных.
1. Заводим массив `dist` аналогичный массиву из прошлого алгоритма. Здесь этот
массив используется как приоритеты вершин в очереди с приоритетами. Только
приоритет тем больше, чем меньше расстояние, т.е. при извлечении вершины
каждый раз нужно извлекать вершину с минимальным расстоянием.  
1. При добавлении вершины `w` в очередь у нее пересчитывается
 приоритет следующим образом:`dist[w] = min(dist[w], dist[u] + length(uw))`,
 где `length(uw)` это длина ребра `uw`.
1. Если требуется найти расстояние до конкретной вершины, то можно
остановить алгоритм, как только она будет извлечена из очереди. Иначе,
если нужно найти расстояния от вершины до всех других вершин, поиск в ширину
нужно провести до конца.


#### Минимальный путь с оптимизацией, алгоритм A*
позже... или сами...

### Алгоритмы, основанные на поиске в глубину

Из-за того, что поиск в глубину основан на стеке, его можно реализовать с помощью
рекурсии,
в этом случае в качестве стека используется стек вызова функцией самой себя.
Следующий алгоритм эквивалентен прошлой версии со стеком:

TODO: рекурсивный поиск в глубину, время выхода из вершины, "обратные" ребра.

```
color = массив цветов вершин
in = массив номеров вершин
function dfs(u)
    if color[u] != белый
        return
    color[u] = серый
    in[u] = очередной номер входа
    for вершины w, такие что uw-ребро:
        dfs(u)
    out[u] = очередной номер выхода
    color[u] = черный
```

#### Определение компонент связности
#### Определение компонент сильной связности
#### Топологическая сортировка
#### Поиск мостов
#### Поиск точек сочленения