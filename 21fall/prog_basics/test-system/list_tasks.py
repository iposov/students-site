# TODO test changing every empty list

from testsystem import test, create_tests, write_test_suites, TestSuite


def even_list(n):
    return list(range(2, 2 * n + 1, 2))


create_tests(even_list, [[n] for n in range(1, 10)])


def list_of_empty_lists_checker(function, env):
    function.call(0)
    env.assert_result_equals([])
    function.call(1)
    env.assert_result_equals([[]])

    for n in range(2, 6):
        l = function.call(n)
        env.assert_result_equals([[]] * n)
        l[0].append(42)
        env.assert_equals([[42]] + [[]] * (n - 1), l, "При добавлении 42 в первый список другие списки тоже изменились")


write_test_suites("tests/list_of_empty_lists.json.gz", TestSuite(list_of_empty_lists_checker))

test(lambda n: [[] for i in range(n)], "tests/list_of_empty_lists.json.gz")
test(lambda n: [[]] * n, "tests/list_of_empty_lists.json.gz")


def list_exchange_inplace_checker(function, env):
    def exchange(lst):
        if len(lst) <= 1:
            return lst.copy()
        return lst[-1:] + lst[1:-1] + lst[:1]

    for l in [10], [10, 20], [10, 20, 30], ["abc", "def", "ghi", "jkl"]:
        l1 = l.copy()
        function.call(l1)
        env.assert_result_equals(None)
        env.assert_equals(exchange(l), l1, "После вызова функции список, переданный в функцию, должен был измениться")


def list_exchange_pure_checker(function, env):
    def exchange(lst):
        if len(lst) <= 1:
            return lst.copy()
        return lst[-1:] + lst[1:-1] + lst[:1]

    for l in [10], [10, 20], [10, 20, 30], ["abc", "def", "ghi", "jkl"]:
        l1 = l.copy()
        function.call(l1)
        env.assert_result_equals(exchange(l))
        env.assert_equals(l, l1, "После вызова функции список, переданный в функцию, не должен был измениться")


write_test_suites("tests/list_exchange_inplace.json.gz", TestSuite(list_exchange_inplace_checker))
write_test_suites("tests/list_exchange_pure.json.gz", TestSuite(list_exchange_pure_checker))

test(lambda lst: lst[-1:] + lst[1:-1] + lst[:1] if len(lst) > 1 else lst, "tests/list_exchange_pure.json.gz")


def _inpl(l):
    l[0], l[-1] = l[-1], l[0]


test(_inpl, "tests/list_exchange_inplace.json.gz")


def gray_1(n):
    l = [0]
    for i in range(1, n + 1):
        l = l + [i] + l
    return l


def gray_2(n):
    codes = [0] * n
    result = [codes.copy()]
    for i in gray_1(n - 1):
        codes[i] = 1 - codes[i]
        result.append(codes.copy())
    return result


create_tests(gray_1, [[n] for n in range(5)])
create_tests(gray_2, [[n] for n in range(1, 6)])
