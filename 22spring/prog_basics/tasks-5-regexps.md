---
type: tasks
---

# Задачи на регулярные выражения

1. Дана строка, проверьте, что в ней содержится корректный email адрес.
    1. Будем считать, что корректный email состоит из имени пользователя (одна или более латинских букв в нижнем регистре), далее следует символ @, далее идет домен (тоже одна или больше латинских букв в нижнем регистре), в конце должна быть точка и не менее двух латинских букв в нижнем регистре. Т.е. конец должен выглядеть как .com, .ru и т.п. Помните, что обычная точка означает любой символ, и ее может понадобиться экранировать.
    2. В условиях предыдущей задачи расширьте допустимые символы для имени пользователя и первой части домена (до точки). Разрешите использовать знак минуса, подчеркивания, цифры.
    3. Используйте регулярное выражение с сайта [emailregexr.com](https://www.emailregex.com)
2. Дана строка с текстом на русском языке. В тексте встречаются номера телефонов — последовательности от 7 до 10 цифр, возможно, с плюсом в начале. Между соседними цифрами либо ничего нет, либо есть скобки, минусы, пробелы. Верните список из всех найденных номеров телефонов.
3. Дана строка с текстом на русском языке, в которой автор неправильно расставил пробелы перед запятыми. Например, `Это строка  , у которой зачем-то написаны два пробела перед запятой`. Нужно найти все пробельные символы перед запятыми и удалить их. Должно получиться `Это строка, у которой зачем-то написаны два пробела перед запятой`.
4. Дана строка. Найдите в ней все слова, написанные через дефис и поменяйте две половинки этих слов местами. Например, строка "Какая-то сине-зеленовая трава" должна превратиться в "то-Какая зеленовая-сине трава".
5. Дана строка. Посчитайте, сколько раз в ней встречаются символы "кот", в произвольном регистре. Т.е. Кот и КОТ тоже надо считать. Используйте мета-символы указания начала и конца слова, начала и конца строки, чтобы находить именно слова, а не части слов, например, "КОТорый".
6. Дан текст, заменить все вхождения чисел (последовательности цифр, возможно, начинающейся на `-`) на такие же числа, увеличенные на 1. Например, текст `У меня 2 яблока и -4 банана` должен превратиться в `У меня 3 яблока и -3 банана`. 