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
