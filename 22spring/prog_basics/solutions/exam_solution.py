def task1_repeat_symbols(numbers, symbol):
    return [symbol * x for x in numbers]


print(task1_repeat_symbols([1, 2, 3], 'x'))


def task2_alternate_lists(outer_list, inner_list):
    n = len(inner_list)
    # далее переменная i перебирает индекс элемента, а переменная lst перебирает два списка
    # получим один список с чередующимися значениями первого и второго списка
    two_lists_together = [lst[i] for i in range(n) for lst in (outer_list, inner_list)]

    return ''.join(two_lists_together) + outer_list[-1]


print(task2_alternate_lists(['x', 'y', 'zz'], ['##', '&&&']))


def task3_increase_beginning(numbers, increase):
    # соединим два списка, начало, увеличенное на 1, и хвост списка, который не должен меняться
    return [x + 1 for x in numbers[:increase]] + numbers[increase:]


print(task3_increase_beginning([10, 20, 30, 40, 50], 3))


def task4_increase_beginning_inplace(numbers, increase):
    numbers[:increase] = [x + 1 for x in numbers[:increase]]


lst = [10, 20, 30, 40, 50]
task4_increase_beginning_inplace(lst, 3)
print(lst)


def task5_split(L, n):
    # зачем мы делали прошлые задачи? Надо использовать
    return task3_increase_beginning([L // n] * n, L % n)


print(task5_split(20, 6))


def task6_make_line(words, line_length):
    if len(words) <= 1:
        return ''.join(words)

    # составляем список длин слов и складываем значения, получим, сколько всего букв
    # sum - встроенная в python функция
    # кстати, на экзамене я объяснял, почему в этой ситуации можно убрать фигурные скобки
    total_letters = sum([len(word) for word in words])
    spaces_count = line_length - total_letters  # сколько всего пробелов
    words_count = len(words)  # сколько всего слов
    # воспользуемся старыми задачами, чтобы распределить пробелы между словами
    split_spaces = task5_split(spaces_count, words_count - 1)
    return task2_alternate_lists(words, task1_repeat_symbols(split_spaces, ' '))


print(task6_make_line(["one", "two", "three"], 18))


def task7_length_with_spaces(words):
    spaces_between = len(words) - 1
    return sum(len(word) for word in words) + spaces_between


print(task7_length_with_spaces(["abc", "xyz", "qqqqq"]))  # должно быть 13


def task8_file_stats(filename):
    with open(filename, mode='r', encoding='utf8') as f:
        text = f.read()
        words = text.split()
        return len(text), len(words), task7_length_with_spaces(words)


print(task8_file_stats("exam_solution.py"))


def task9_left_justify_file(filename, line_length, output_filename):
    with open(filename, mode='r', encoding='utf8') as f:
        words = f.read().split()

    # будем заполнять очередную строку файла
    with open(output_filename, mode='w', encoding='utf8') as f:
        line = []
        for word in words:
            line.append(word)
            if task7_length_with_spaces(line) > line_length:
                print(' '.join(line[:-1]), file=f)
                line = [word]


task9_left_justify_file('exam_solution.py', 20, 'exam_solution.py.left_justify')


# задача 10 отличается от задачи 9 только тем, что написано в строке print
def task10_justify_file(filename, line_length, output_filename):
    with open(filename, mode='r', encoding='utf8') as f:
        words = f.read().split()

    # будем заполнять очередную строку файла
    with open(output_filename, mode='w', encoding='utf8') as f:
        line = []
        for word in words:
            line.append(word)
            if task7_length_with_spaces(line) > line_length:
                print(task6_make_line(line[:-1], line_length), file=f)
                line = [word]


task10_justify_file('exam_solution.py', 20, 'exam_solution.py.justify')
