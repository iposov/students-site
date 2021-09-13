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
            print(f"Ошибка при проверке. Получен ответ:\n    {student_answer}\nожидался:\n    {correct_answer}\nАргументы:")
            for arg in args:
                print("    ", arg, sep="")
            return
    print("Все тесты пройдены")


def create_tests(function, filename, arguments_lists):
    test_cases = [[*arguments, function(*arguments)] for arguments in arguments_lists]

    if filename[-3:] == '.gz':
        f = gzip.open(filename, "wt", encoding="utf8")
    else:
        f = open(filename, "w")

    with f:
        json.dump(test_cases, f)

