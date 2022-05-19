import string


def string_symbols(s):
    return set(s)
    # return {symbol for symbol in s}

    # a = set()  # пустое множество, {}
    # for symbol in s:
    #     a.add(symbol)
    # return a


print(string_symbols("aaaaaaaaa"))
print(string_symbols("hello world!"))


def remove_symbols(s, symbols):
    # new_s_symbols = [symbol for symbol in s if symbol not in symbols]
    # return ''.join(new_s_symbols)

    # return ''.join([symbol for symbol in s if symbol not in symbols])

    # если в генераторе нет [], {}, это выражение генератор, обычно оно в круглых
    # скобках, но если это единственный аргумент функции, можно и без них
    # return ''.join((symbol for symbol in s if symbol not in symbols))
    return ''.join(symbol for symbol in s if symbol not in symbols)


print(remove_symbols("Hello world!", {'h', 'l', '!'}))


def all_words(s):
    # words_with_punctuation = s.split()  # split() разделяет по пробельным символам
    # return [word.strip(string.punctuation) for word in words_with_punctuation]
    return [word.strip(string.punctuation) for word in s.split()]


text1 = "Abc, hello world, xyz!"
text2 = "Oh, hello stars, abc, xyz!"
print(all_words(text1))


def common_words(sentence1, sentence2):
    words1 = all_words(sentence1)
    words2 = all_words(sentence2)
    return set(words1) & set(words2)
    #
    # a = set()
    # words1 = set(words1)
    # words2 = set(words2)
    # for word in words1:
    #     if word in words2:
    #         a.add(word)
    #
    # return a


print(common_words(text1, text2))


def common_words_ignore_case(sentence1, sentence2):
    words1 = all_words(sentence1.lower())  # сразу избавляемся от регистра
    words2 = all_words(sentence2.lower())
    return set(words1) & set(words2)


print(common_words_ignore_case(text1, text2))

# до 12.07
