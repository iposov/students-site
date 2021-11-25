#TODO 'a', 'lowercase', 'UPPERCASE' to test task3

from testsystem import write_test_suites, create_tests, test, TestSuite


def palindrome_test(function, test_environment):
    def is_palindrome_strict(text, strict):
        if not strict:
            text = text.replace(" ", "").lower()
        return text[::-1] == text

    use_strict = test_environment.data

    symbols = ('a', 'b', ' ', 'A', 'B')
    word = []
    max_level = 7

    def search(level):
        text = ''.join(word)
        if use_strict:
            function.call(text, True)
            test_environment.assert_result_equals(is_palindrome_strict(text, True))
            function.call(text, False)
            test_environment.assert_result_equals(is_palindrome_strict(text, False))
        else:
            function.call(text)
            test_environment.assert_result_equals(is_palindrome_strict(text, True))
        if level == max_level:
            return
        word.append(None)
        for symbol in symbols:
            word[-1] = symbol
            search(level + 1)
        del word[-1]

    search(0)


write_test_suites("tests/palindrome.json.gz", TestSuite(palindrome_test, False))
write_test_suites("tests/palindrome_strict.json.gz", TestSuite(palindrome_test, True))


def _is_poly(text):
    return text == text[::-1]


def _is_poly_strict(text, strict):
    if not strict:
        # text = text.replace(" ", "").lower()
        text = text.replace(" ", "").lower()
    return text == text[::-1]


test(_is_poly, "tests/palindrome.json.gz")
test(_is_poly_strict, "tests/palindrome_strict.json.gz")


def symbol_pairs(text):
    return text[::2] == text[1::2]


create_tests(symbol_pairs, [
    [""], ["a"], ["A"], ["aabb"], ["aaBB"], ["aaB"], ["aBB"], ["aabbccdd"], ["aabbccdde"], ["aabbccde"]
])


def lower_upper(text):
    t1 = text[::2]
    t2 = text[1::2]
    return t1.islower() and t2.isupper() or t1.isupper() and t2.islower()


create_tests(lower_upper, [
    [""], ["a"], ["A"], ["aAbB"], ["aAbBc"], ["aAbBC"], ["aaAbBc"], ["aA" * 20], ["aB" * 20 + "a"]
])


def exchange_symbols(text, c1, c2):
    rules = str.maketrans(c1 + c2, c2 + c1)
    return text.translate(rules)


string_with_all_symbols = ''.join(chr(i) for i in range(32, 128))
create_tests(exchange_symbols, [
    ["", "0", "1"],
    ["01", "0", "1"],
    ["aaaabbbbb", "a", "b"],
    ["aaaabbbbb", "x", "y"],
    ["aaaxabbybbb", "a", "b"],
    ["hello world", "l", "d"]
] + [[string_with_all_symbols * 2, c1, c2] for c1 in "a9B~!@#$%^&*()" for c2 in "a9B~!@#$%^&*()-+" if c1 != c2])

create_tests(lambda text: exchange_symbols(text, '0', '1'), [
    [""],
    ["01010"],
    ["01001asdf00020123"],
    ["asdlkjaslkdfj"],
] + [[bin(x).replace("0b", "")] for x in range(128)] +
             [[bin(x).replace("0b", "") + "abc"] for x in range(128)], filename="tests/exchange_01.json.gz")


def dragon_curve(n):
    s = "R"
    for i in range(n):
        s = s + "R" + exchange_symbols(s, "R", "L")[::-1]
    return s


create_tests(dragon_curve, [[n] for n in range(5)])


def dragon_curve_(n):
    s = "R"
    for i in range(n):
        s = s + "R" + exchange_symbols(s, "R", "L")[::-1]
    # if n == 3:
    #     return s[:4] + 'x' + s[5:]
    return s

test(dragon_curve_, "tests/dragon_curve.json.gz")
