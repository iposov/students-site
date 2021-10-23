# Разборы задач
from testsystem import test


# Задача о выводе трехчлена: a, b, c -> ax^2 + bx + c
# 1, -2, 0 -> "x^2 - 2x"

def poly_solution_1(a, b, c):
    # Отдельно соберем три части многочлена, при 2-ой, 1-ой, 0-ой степени
    if a == 0:
        deg2 = '0'
    elif a == 1:
        deg2 = 'x^2'
    elif a == -1:
        deg2 = '-x^2'
    else:
        deg2 = f'{a}x^2'

    if b == 0:
        deg1 = '0'
    elif b == 1:
        deg1 = 'x'
    elif b == -1:
        deg1 = '-x'
    else:
        deg1 = f'{b}x'

    deg0 = str(c)  # f'{c}'

    # соединяем deg2 и deg1    2x^2 и -3x
    if deg2 == '0':  # if a == 0
        deg21 = deg1
    elif deg1 == '0':
        deg21 = deg2
    elif deg1[0] == '-':  # if b < 0
        deg21 = deg2 + deg1
    else:
        deg21 = deg2 + '+' + deg1

    # соединяем deg21 и deg0    2x^2+3x и -5
    if deg21 == '0':
        return deg0
    elif deg0 == '0':
        return deg21
    elif deg0[0] == '-':
        return deg21 + deg0
    else:
        return deg21 + '+' + deg0


def poly_solution_2(a, b, c):
    def coef(a, var):
        """
        Приписывает коэффициент a к переменной var. Например, `coef(1, 'x')` равен 'x'.
        coef(2, 'x^2') равен '2x^2', coef(0, 'x') равен '0'

        :param a: коэффициент
        :param var: переменная
        :return: коэффициент, приписанный к переменной
        """
        if a == 0:
            return '0'
        if a == 1:
            return var
        if a == -1:
            return '-' + var
        else:
            return f'{a}{var}'

    def sum(x, y):
        """приписывает x к y, учитывая, что один из них может быть 0 или отрицательный"""
        if x == '0':
            return y
        if y == '0':
            return x
        if y[0] == '-':
            return x + y
        else:
            return x + '+' + y

    return sum(sum(coef(a, 'x^2'), coef(b, 'x')), str(c))


test(poly_solution_1, "tests/poly.json.gz")
test(poly_solution_2, "tests/poly.json.gz")


# задача про таблицу из псевдографики
def table(m, n):
    t = [
        '┌─┬─┐',
        '│ │ │',
        '├─┼─┤',
        '│ │ │',
        '└─┴─┘']

    def repeat(line, k):  # line = '┌─┬─┐', k = 5
        return line[0:1] + line[1:3] * (k - 1) + line[3:]
        # для строк line[0:1] = line[0]
        # для списков line[0:1] = [line[0]]

    rows = [repeat(row, n) for row in t]  # делаем строки нужной длины
    rows = repeat(rows, m)  # делаем нужное количество строк

    # записываем все строки в результат
    result = ''
    for row in rows:
        result = result + row + '\n'

    return result  # return "\n".join(rows) + "\n"

print(table(4, 5))

test(table, "tests/table.json.gz")
