# Функциональное программирование

## Ссылки

1. [haskell.org](haskell.org) для установки
1. [wiki.haskell.org](wiki.haskell.org) много материалов для изучения

## Учебники

1. [Кубенский А.А. Функциональное программирование](https://biblio-online.ru/book/658E3C89-AAD5-498B-8B34-A29E1750D810/funkcionalnoe-programmirovanie)

для доступа к сайту издательства Юрайт перейдите по ссылке [http://cufts.library.spbu.ru/CRDB/SPBGU/resource/306/goto](http://cufts.library.spbu.ru/CRDB/SPBGU/resource/306/goto) и введите свои университетские логин и пароль.

## Лекции

Что мы успели изучить на двух первых лекциях:
1. Базовые типы данных Int, Integer, Char, Float, Double, Bool
1. Списки \[*любой тип*\], String == \[Char\]. Конструкторы списка `:` (приписывание элемента в начало) и `[]` (пустой список).
1. Синтаксис определения функций, рекурсия, хвостовая рекурсия.
1. Описание типов функций
1. Сопоставление с образцом: при описании функций и в операторое `case`. Guards
1. Условное выражение `if`
1. Выражения `where` и `let`.
1. Инфиксная и префиксная запись функций.
1. Лямбда выражения: `\x -> x + 1`
1. Параметрический полиморфизм: типовые переменные в описании типа, например, `head :: [a] -> a` 
1. Действия со списками http://hackage.haskell.org/package/base-4.12.0.0/docs/Data-List.html
1. Функции высшего порядка: например `map f list` и `filter pred list`
1. Диапазоны: `[1..10]`, `[1,3..10]`, `[1..]`, `[1,3..]`

На третьей лекции мы обсудили
1. Карринг и частичное применение функций.
2. Функции foldl и foldr

Четвертая лекция: [Функции `.` и `$`, Алгебраические типы данных](http://nbviewer.jupyter.org/github/iposov/students-site/blob/master/18fall/functional_programming/11oct.ipynb?asdf)

Вы можете найти необходимые знания, например, в этом учебнике: [Haskell Wikibook](https://en.wikibooks.org/wiki/Haskell).
Читайте разделы в Haskell Basics: `Variables and functions`, `Truth values`, `Type basics`, `Lists and tuples`, `Next steps`.
В разделе Elementary Haskell: всё без `Types declarations` и без разделов о чем-то непонятном, что мы еще не прошли.

## Задачи

1. [Первая часть](tasks1.md)
