---
type: tasks
---

# Еще задачи на Основы Python

В некоторых следующих задачах вам придется пользоваться случайными числам. Первые несколько задач подготавливают к решению следующих.

1. Дан список, можно считать, что это список чисел. Проверить, есть ли в нем два одинаковых элемента. 
1. Дан список и натуральное число $n$. Проверить, что в списке встречаются все числа от 1 до $n$.

1. **Парадокс дней рождения**.
В году 365 дней (d = 365), в группе 30 студентов (n = 30).
С какой вероятностью найдутся два студента с одним днем рождения?

    1. Заведите функцию, которая ставит один эксперимент. На вход получает d, n. Генерирует случайные n дней рождения, проверяет, не совпали ли два, возвращает логическое значение.

    1. Создайте функцию, которая получает на вход d, n и количество экспериментов e, например, e = 1000. Запускаем эксперимент e раз. Возвращаем вероятность совпадения дней рождения, она равна тому, сколько раз дни рождения совпали,
делить на количество экспериментов.

1. **Яйца с сюрпризом**. Представим, что мы покупаем яйца с сюрпризом, в которых есть (n = 10) возможных игрушек внутри. И мы хотим собрать коллекцию из всех игрушек. Сколько понадобится купить яиц, в среднем, чтобы собрать полную коллекцию?

    1. Делаем функцию, которая проводит единичный эксперимент. Она получает на вход число n, потом последовательно генерирует случайный номер игрушки от 1 до n и повторяет
процесс, пока не сгенерируются все номера от 1 до n. Например, при n = 3 могут сгенерироваться числа 1, 3, 3, 3, 1, 1, 3, 2. Получив два, функция останавливает процесс генерации, потому что получены все номера от 1 до 3.
       
        Функция должна вернуть номер шага, на котором сгенерировались все номера. В примере это 8.

    1. Сделайте функцию, которая получает на вход n и количество экспериментов e, например, e = 1000. Запускаем эксперимент е раз и считаем среднее значение количества шагов:

        $$ \frac{steps_1 + steps_2 + \cdots + steps_e}{e}. $$

        Это среднее значение и нужно вернуть.

## Какие бывают русские слова

Ваша задача будет состоять в том, чтобы отобрать из списка всех русских слов [russian.7z](russian.7z) те слова, которые подходят под условия ниже. Кроме того, чтобы укоротить вывод, давайте считать, что в этой задаче нам интересны только слова минимум из четырех букв, и в которых кроме маленьких русских букв нет никаких других символов.

Не забудьте, что каждая задача — это отдельная функция. Она должна принимать на вход список всех русских слов для анализа, и должна возвращать список из подходящих слов, или что-то другое, указанное в условии.

0. Сделайте функцию чтения файла. Она получает на вход имя файла и возвращает список слов из файла, подходящих под основное условие: длина хотя бы 4, все символы — это маленькие буквы.
  
    Еще сделайте функцию распечатки списка слов. Она должна принимать на вход список слов, ничего не возвращать и печатать слова на экране. В строчку, в столбик, как удобно.
1. Палиндромы. Это слова, которые читаются с начала и с конца одинаково;
2. В которых хотя бы 4 гласных, и все гласные в слове одинаковые;
3. 20 самых длинных русских слов;
4. В которых есть три одинаковых буквы подряд;
5. Слова, которые, если их прочитать с конца, тоже оказываются русскими словами, т.е. тоже находятся внутри файла. Но при этом, эти слова не должны быть палиндромами.
6. Слова, в которых буквы увеличиваются. Т.е. список sorted(слово) должен быть такой же, как список букв слова.
7. В каком слове чаще всего повторяется буква? И какая эта буква? Т.е. посчитайте для каждого слова, какая буква в нем встречается больше всего раз, и запомните, сколько раз она встретилась. После чего отберите слова, где это значение максимально. Верните структуру такого типа: `(2, [("мама", "м"), ("голова", "о"), ...])`

  Т.е. вы возвращаете кортеж, в котором сначала написано, сколько раз повторяются буквы (конечно, в вашем ответе будет не 2, а намного больше повторений), потом в кортеже лежит список, и в нем в кортежах
  слова вместе с самой частой буквой.
8. Найдите самое длинное русское слово, из которого можно удалять буквы по одной, чтобы в результате слова оставались русскими. Например, слово мама, мам, ам, а.

    Подсказка: отсортируйте слова по возрастанию длины, для каждого слова нужно сохранять, подходит ли оно под условие. Попытайтесь удалить у слова по каждой букве и проверьте, не подходит ли под условие хотя бы какое-то из полученных коротких слов.
