from testsystem import test, create_tests


def task1(x, s):
    return s + s


test(task1, "task1.json")
