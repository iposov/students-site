import json
import gzip
from colorama import Fore, Back, Style, init as colorama_init

colorama_init()


# TODO add number of tests that are allowed to fail

def test(function, filename):
    if filename[-3:] == '.gz':
        f = gzip.open(filename, "rb")
    else:
        f = open(filename, "rb")

    with f:
        test_cases = json.load(f)

    for *args, correct_answer in test_cases:
        student_answer = function(*args)
        if student_answer != correct_answer:
            print(
                f"{function.__name__}: Ошибка при проверке. Получен ответ:\n    {student_answer}\n    ожидался:\n    {correct_answer}\n    Аргументы:")
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


# testcase: {'in': '', args: [], checker: code}

"""
[
    [arg1, arg2, result],
    [arg1, arg2, result]
]

[
    {code}
]


TestCase:
check(function)

1) 
loop: input_stream, arguments, additional_data (to test)

get: output_stream, result

-> message|None

2)
loop: additional_data

-> message|None

/ error info may include input_stream, arguments

[
    {
        type: "TestSuite...",
        data: [],
        ...: ...
    }
]
"""


class Message:
    def __init__(self, message, detailed_message=None, args=None, input_stream=None, expected_value=None,
                 actual_value=None):
        self.message = message
        self.detailed_message = detailed_message
        self.args = args
        self.input_stream = None
        self.expected_value = expected_value
        self.actual_value = actual_value

    def print(self, function):
        # def has_several_lines(text):
        #     return '\n' in text.strip()

        print(f"{Fore.RED}Ошибка при проверке {function.__name__}: {self.message}{Fore.RESET}")
        if self.detailed_message is not None:
            print(self.detailed_message)
        if self.args is not None:
            joined_args = ', '.join(str(arg) for arg in self.args)
            print(f"Вызов {function.__name__}({joined_args})")
        # TODO implement if message.input_stream in not None:
        if self.expected_value is not None or self.actual_value is not None:
            # '·' \u00B7 for spaces
            expected_text = str(self.expected_value)  # .replace(' ', '\u00B7')
            actual_text = str(self.actual_value)  # .replace(' ', '\u00B7')
            different_symbol = -1
            min_length = min(len(actual_text), len(expected_text))
            for i in range(min_length):
                if expected_text[i] != actual_text[i]:
                    different_symbol = i
                    break
            ending = ''
            if different_symbol == -1 and len(actual_text) != len(expected_text):
                different_symbol = min_length
                ending = '\u23F9'
            if actual_text[different_symbol:].isspace() or expected_text[different_symbol:].isspace():
                ending = '\u23F9'

            print("Получено:")
            print(
                f'{Back.LIGHTGREEN_EX}{actual_text[:different_symbol]}{Back.LIGHTRED_EX}{actual_text[different_symbol:]}{ending}{Style.RESET_ALL}')
            print("Ожидалось:")
            print(
                f'{Back.LIGHTGREEN_EX}{expected_text[:different_symbol]}{Back.LIGHTCYAN_EX}{expected_text[different_symbol:]}{ending}{Style.RESET_ALL}')


class TestSuite:
    all_subclasses = {}
    type = None

    def __init__(self, data, **kwargs):
        self.data = data
        self.constructor_kwargs = kwargs
        self.init(**kwargs)

    def init(self, **kwargs):
        pass

    def run(self, function):
        for data_for_one_test in self.data:
            message = self.run_one_test(function, data_for_one_test)
            if message is not None:
                return message

    def run_one_test(self, function, data_for_one_test):
        pass  # to be overridden

    def serialize(self):
        return {
            'type': self.type,
            'data': self.data,
            **self.constructor_kwargs
        }

    @staticmethod
    def deserialize(serialized_object):
        clazz = TestSuite.all_subclasses[serialized_object['type']]
        initializer_args = {k: serialized_object[k] for k in serialized_object if k not in ['type', 'data']}
        return clazz(serialized_object['data'], **initializer_args)

    @staticmethod
    def register(clazz):
        TestSuite.all_subclasses[clazz.type] = clazz


class TestSuiteCompareReturnValue(TestSuite):
    type = 'return'

    def run_one_test(self, function, data_for_one_test):
        *args, correct_answer = data_for_one_test
        student_answer = function(*args)
        if correct_answer != student_answer:
            return Message("Результат вызова функции не совпадает с правильным",
                           args=args,
                           expected_value=correct_answer,
                           actual_value=student_answer)


TestSuite.register(TestSuiteCompareReturnValue)


class TestSuiteCheckFunction(TestSuite):
    type = 'check(function)'

    def init(self, checker_code, checker_main):
        compiled_checker = compile(checker_code, filename="checker", mode='single')
        module_dict = {}
        exec(compiled_checker, module_dict)
        self.checker = module_dict[checker_main]

    def run_one_test(self, function, data_for_one_test):
        return self.checker(function, data_for_one_test)


TestSuite.register(TestSuiteCheckFunction)


class TestSuiteCheckReturnValue(TestSuite):
    type = "check(return)"

    def init(self, checker_code, checker_main):
        compiled_checker = compile(checker_code, filename="checker", mode='single')
        module_dict = {}
        exec(compiled_checker, module_dict)
        self.checker = module_dict[checker_main]

    def run_one_test(self, function, data_for_one_test):
        *args, checker_data = data_for_one_test
        result = function(*args)
        return self.checker(function, result, checker_data)


TestSuite.register(TestSuiteCheckReturnValue)


def run_test_suites(function, test_suites):
    for test_suite in test_suites:
        message = test_suite.run(function)
        if message is not None:
            message.print(function)
            return


def deserialize_test_suites(serialized_object):
    if len(serialized_object) == 0:
        return []
    if type(serialized_object[0]) == list:  # old version
        return [TestSuiteCompareReturnValue(serialized_object)]
    return [TestSuite.deserialize(serialized_test_suite) for serialized_test_suite in serialized_object]
