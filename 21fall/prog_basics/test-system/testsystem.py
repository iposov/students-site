import json
import gzip


def test(function, filename):
    if filename[-3:] == '.gz':
        f = gzip.open(filename, "rb")
    else:
        f = open(filename, "rb")

    with f:
        test_cases = json.load(f)

    for [*args, correct_answer] in test_cases:
        student_answer = function(*args)
        if student_answer != correct_answer:
            print(f"{function.__name__}: Ошибка при проверке. Получен ответ:\n    {student_answer}\n    ожидался:\n    {correct_answer}\n    Аргументы:")
            print(f"    {function.__name__}(", end="")
            print(*args, sep=", ", end="")
            print(')')
            return
    print(f"{function.__name__}: Все тесты пройдены")


def create_tests(function, arguments_lists, filename=None):
    if not filename:
        filename = f'tests/{function.__name__}.json.gz'

    test_cases = [[*arguments, function(*arguments)] for arguments in arguments_lists]

    if filename[-3:] == '.gz':
        f = gzip.open(filename, "wt", encoding="utf8")
    else:
        f = open(filename, "w")

    with f:
        json.dump(test_cases, f)

