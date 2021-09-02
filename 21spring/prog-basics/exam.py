from random import shuffle


# отрезать начало и конец
def crop_begin_end(word):
    return word[1:-1]


# перемешать буквы
def shuffle_letters(word):
    all_letters = list(word)
    shuffle(all_letters)
    return ''.join(all_letters)


# Перемешать буквы без первой и последней
def shuffle_middle_letters(word):
    if len(word) <= 2:  # не забываем про короткие слова, их надо разобрать отдельно
        return word

    return word[0] + shuffle_letters(crop_begin_end(word)) + word[-1]


# Часть 4. Загрузить текст из файла, перемешать слова, распечатать на экране
def shuffle_words_in_file(filename):
    with open(filename, mode="r", encoding="utf8") as f:
        words = f.read().split()

    shuffled_words = [shuffle_middle_letters(word) for word in words]
    # shuffled_words = [shuffle_middle_letters(words[i]) for i in range(len(words))]

    # дальше три способа распечатать, выбирайте любой
    # 1. собираем все слова в одну строку через пробелы. Это ожидаемый способ, который вы выберете
    print(" ".join(shuffled_words))

    # 2. печатаем в цикле все слова, но указываем, что вместо перевода строки нужно печатать пробел
    for word in shuffled_words:
        print(word, end=' ')
    print()  # в конце все равно надо распечатать перевод строки

    # 3. распечатываем, как будто каждый элемент списка это один аргумент print
    # (см. раздел про деструктуризацию)
    print(*shuffled_words)


# Часть 4б
def shuffle_words_in_file_full(filename):
    with open(filename, mode="r", encoding="utf8") as f:
        text = f.read()  # забрали весь текст из файла

    russian_letters = set('абвгдеёжзийклмнопрстуфхцчшщъыьэюя')  # еще можно наполнить в цикле, но русские буквы идут не по порядку, ё отдельно

    last_word = []  # сюда будем собирать символы слова

    # мы собираем символы не в строку, а в список, потому что список наполнять эффективнее, он изменяемый.
    # А строки неизменяемые, и копируются каждый раз при удлинении.

    # выделим распечатку перемешанного слова в отдельную функцию, потому что нам это надо делать несколько раз
    def print_last_word():
        if last_word != []:  # или просто if last_word: Или можно вообще не проверять, распечатается пустая строка
            print(shuffle_middle_letters("".join(last_word)), end='')
            # если надо не распечатывать ответ, а наполнять им строку, то надо делать что-то типа
            # result += shuffle_middle_letters(last_word), где result - это список символов, который сначала пустой

    for c in text:  # перебираем текст посимвольно
        if c.lower() in russian_letters:
            last_word.append(c)
        else:
            print_last_word()
            last_word = []
            print(c, end='')
    print_last_word()  # в конце снова выводим слово, потому что файл может заканчиваться словом


"""
Вот как еще можно перебирать файл посимвольно. Читаем за раз по одной букве. Благодаря этому
мы экономим память — не наполняем ее сразу всем содержимым файла, который может быть большим.
while True:
    c = f.read(1)  # читаем 1 символ
    if c == '':  # если ничего не прочиталось, значит, конец файла
        break
    обрабатываем символ 'c'
"""


# часть пять, генератор перестановок
def generate_permutations(word):
    while True:
        yield shuffle_middle_letters(word)


# часть 6. Класс перестановщик


class Permutator:

    def __init__(self, indices):
        self._indices = indices

    def permute(self, word):
        letters = [word[i - 1] for i in self._indices]
        return "".join(letters)


# Обязательная часть с проверкой всех функций

print("---- part1 ----")
print(crop_begin_end("aardvark"))
print(crop_begin_end("house"))
print(crop_begin_end("cat"))
print(crop_begin_end("am"))
print(crop_begin_end("a"))
print(crop_begin_end(""))

print("---- part2 ----")
print(shuffle_letters("aardvark"))
print(shuffle_letters("house"))
print(shuffle_letters("cat"))
print(shuffle_letters("am"))
print(shuffle_letters("a"))
print(shuffle_letters(""))

print("---- part3 ----")
print(shuffle_middle_letters("aardvark"))
print(shuffle_middle_letters("house"))
print(shuffle_middle_letters("cat"))
print(shuffle_middle_letters("am"))
print(shuffle_middle_letters("a"))
print(shuffle_middle_letters(""))

print("---- part4 ----")
shuffle_words_in_file("oop1.md")
shuffle_words_in_file_full("oop1.md")

print("---- part5 ----")
g = generate_permutations("verylongword")
print(next(g))
print(next(g))
print(next(g))

print("---- part6 ----")
p = Permutator([1, 3, 2, 4])  # говорим, что это перемешиватель для строк длины 4
# сначала первая буква, потом третья, потом вторая, потом четвертая
print(p.permute("abcd"))  # acdb
print(p.permute("xyzt"))  # xzyt
print(p.permute("abab"))  # aabb
