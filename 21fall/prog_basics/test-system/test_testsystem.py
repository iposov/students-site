import testsystem as ts


def task1(x, y):
    return x + y if x * y != 4 else x + y + 1


def test_task1(function, env):
    for i in range(100):
        for j in range(100):
            result = function.call(i, j)
            correct = i + j
            if result != correct:
                function.message(
                    "Результат вычисления не сходится с правильным",
                    expected_value=correct,
                    actual_value=result
                ).print()
                return False
    return True


ts.create_tests(task1, [[1, 2], [4, 5], [0, 0]], 'task1.json')

ts.test(task1, 'task1.json')

ts.write_test_suites('task1_.json', ts.TestSuite(test_task1))

ts.test(task1, 'task1_.json')
