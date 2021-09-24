import math

from testsystem import create_tests


def task_example(x):
    return 2 * x


def task_example_2(x, y):
    return x + y


def last_is_5(x):
    return x % 10 == 5


def has_3_digits(x):
    return 100 <= x <= 999


def last_digits_are_similar(x):
    return x % 10 == x // 10 % 10


from_1_to_2000 = [[x] for x in range(1, 2000)]
create_tests(task_example, from_1_to_2000)
create_tests(task_example_2, [(x, y) for x in range(1, 10) for y in range(1, 10)])
create_tests(last_is_5, from_1_to_2000)
create_tests(has_3_digits, from_1_to_2000)
create_tests(last_digits_are_similar, from_1_to_2000)


def is_leap(year):
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)


create_tests(is_leap, [[year] for year in range(1600, 2100)])


def cats(n):
    last = n % 10
    pre_last = n // 10 % 10

    if pre_last == 1 or last == 0 or 5 <= last <= 9:
        return f'{n} котов'
    if last == 1:
        return f'{n} кот'
    return f'{n} кота'


create_tests(cats, from_1_to_2000)


def quadratic_equation(a, b, c):
    if a == 0:
        if b == 0:
            if c == 0:
                return "решений бесконечно много"
            else:
                return "решений нет"

        x = -c / b
        return f"одно решение x = {x:.2f}"

    d = b ** 2 - 4 * a * c
    if d < 0:
        return "решений нет"
    elif d == 0:
        x = -b / (2 * a)
        return f"одно решение x = {x:.2f}"
    else:
        x1 = (-b - d ** 0.5) / (2 * a)
        x2 = (-b + d ** 0.5) / (2 * a)
        if x1 > x2:
            x1, x2 = x2, x1
        return f"два решения x1 = {x1:.2f}, x2 = {x2:.2f}"


eq_coefs = list(range(-10, 11))
create_tests(quadratic_equation, [[a, b, c] for a in eq_coefs for b in eq_coefs for c in eq_coefs])


def poly(a, b, c):
    def coef(a, x):
        if a == 0:
            return "0"
        if a == 1:
            return x
        if a == -1:
            return "-" + x
        return f"{a}{x}"

    def sum(x, y):
        if x == "0":
            return y
        if y == "0":
            return x
        if y[0] == '-':
            return x + y

        return x + '+' + y

    return sum(coef(a, 'x^2'), sum(coef(b, 'x'), str(c)))


poly_coefs = [-100, -99, -239, 100, 99, 239] + list(range(-3, 4))
create_tests(poly, [[a, b, c] for a in poly_coefs for b in poly_coefs for c in poly_coefs])


def number_to_string(n):
    ones = ["ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"]
    ones_fem = [ones[0], "одна", *ones[2:]]
    teens = ["десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать",
             "семнадцать", "восемнадцать", "девятнадцать"]
    tens = ["ноль", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят",
            "девяносто"]
    hundreds = ["ноль", "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот",
                "девятьсот"]
    words_million = ["миллион", "миллиона", "миллионов"]
    words_thousand = ["тысяча", "тысячи", "тысяч"]

    def triple(t, ones):
        a = t // 100
        b = t // 10 % 10
        c = t % 10

        res = []
        if a > 0:
            res.append(hundreds[a])

        if b > 1:
            res.append(tens[b])
        if b == 1:
            res.append(teens[c])
        elif c != 0:
            res.append(ones[c])

        return res

    def word(n, words):
        last = n % 10
        pre_last = n // 10 % 10

        if pre_last == 1 or last == 0 or 5 <= last <= 9:
            return words[2]
        if last == 1:
            return words[0]
        return words[1]

    t1 = n // 1_000_000
    t2 = n // 1_000 % 1_000
    t3 = n % 1_000

    res = []
    if t1 > 0:
        res += triple(t1, ones)
        res.append(word(t1, words_million))
    if t2 > 0:
        res += triple(t2, ones_fem)
        res.append(word(t2, words_thousand))
    if t3 > 0:
        res += triple(t3, ones)

    return " ".join(res)


nums = [[x] for x in range(1, 2001)]
nums += [[x] for x in range(1, 1_000_000_000, 479909)]  # 40000th prime
triplets = list(range(0, 30)) + list(range(100, 130)) + [111 * x for x in range(1, 10)]
nums += [[1_000_000 * t1 + 1_000 * t2 + t3] for t1 in triplets for t2 in triplets for t3 in triplets if t1 != 0 or t2 != 0 or t3 != 0]

create_tests(number_to_string, nums)
create_tests(number_to_string, [[x] for x in range(0, 1000)], filename="tests/number_to_string_short.json.gz")
