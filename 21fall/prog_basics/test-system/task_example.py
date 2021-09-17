from testsystem import test


def task1(x):
    return x + x * 2


def task2(x, y):
    return x + y if x != 5 else 10


test(task1, 'tests/task_example.json.gz')
test(task2, 'tests/task_example_2.json.gz')
