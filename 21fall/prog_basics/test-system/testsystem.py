import inspect
import json
import gzip
import io
import sys
from colorama import Fore, Back, Style, init as colorama_init

colorama_init()


# TODO add number of tests that are allowed to fail


class Message:
    def __init__(self, message, detailed_message=None, args=None, kwargs=None, input_stream=None, expected_value=None,
                 actual_value=None, function_name=None):
        self.message = message
        self.detailed_message = detailed_message
        self.args = args
        self.kwargs = kwargs
        self.input_stream = input_stream
        self.expected_value = expected_value
        self.actual_value = actual_value
        self.function_name = function_name

    def print(self):
        # def has_several_lines(text):
        #     return '\n' in text.strip()

        print(f"{Fore.RED}Ошибка при проверке {self.function_name}: {self.message}{Fore.RESET}")
        if self.detailed_message is not None:
            print(self.detailed_message)
        if self.args is not None or self.kwargs is not None:
            joined_args = ''
            if self.args is not None:
                joined_args += ', '.join(str(arg) for arg in self.args)
            if self.kwargs is not None:
                joined_args += ', '.join(f'{key}={value}' for key, value in self.kwargs.items())
            print(f"Вызов {self.function_name}({joined_args})")
        if self.input_stream is not None:
            print("Данные для входного потока:")
            print(f"{Back.LIGHTYELLOW_EX}{self.input_stream}{Back.RESET}")
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


class FunctionWrapper:
    def __init__(self, function):
        self.function = function
        self.stdout = ""
        # self.stderr = ""
        # self.exception = None
        self.args = None
        self.kwargs = None
        self.stdin = None

    def call(self, *args, stdin=None, **kwargs):
        self.args = args
        self.kwargs = kwargs
        self.stdin = stdin
        if stdin is not None:
            sys.stdin = io.StringIO(stdin)
        sys.stdout = io.StringIO()
        # sys.stderr = io.StringIO()
        # self.exception = None

        try:
            return self.function(*args, **kwargs)
        # except BaseException as e:
        #     self.exception = e
        finally:
            self.stdout = sys.stdout.getvalue()
            # self.stderr = sys.stderr.getvalue()
            sys.stdin = sys.__stdin__
            sys.stdout = sys.__stdout__

    def message(self, message, detailed_message=None, expected_value=None, actual_value=None):
        return Message(
            message,
            detailed_message,
            args=self.args,
            kwargs=self.kwargs,
            input_stream=self.stdin,
            expected_value=expected_value,
            actual_value=actual_value,
            function_name=self.function.__name__
        )


def compare_return_value_with_expected(function, test_environment):
    test_cases = test_environment.data
    for test_case in test_cases:
        *args, correct_answer = test_case
        student_answer = function.call(*args)
        if correct_answer != student_answer:
            test_environment.Message("Результат вызова функции не совпадает с правильным",
                                     args=args,
                                     expected_value=correct_answer,
                                     actual_value=student_answer
                                     ).print()
            return False
    return True


class TestSuite:
    Message = Message
    CheckerFunctions = (compare_return_value_with_expected,)

    def __init__(self, checker_function, data=None):
        self.checker_function = checker_function
        self.data = data

    def run(self, function):
        wrapper = FunctionWrapper(function)
        return self.checker_function(wrapper, self)

    def serialize(self):
        result = {'checker': self.checker_function.__name__}
        if self.data is not None:
            result['data'] = self.data
        if self.checker_function not in TestSuite.CheckerFunctions:
            result['checker_code'] = inspect.getsource(self.checker_function)
        return result

    @staticmethod
    def deserialize(serialized_object):
        checker_function_name = serialized_object['checker']
        if 'checker_code' in serialized_object:
            compiled_checker = compile(serialized_object['checker_code'], filename="checker", mode='single')
            module_dict = {}
            exec(compiled_checker, module_dict)
            checker_function = module_dict[checker_function_name]
        else:
            checker_functions = [fun for fun in TestSuite.CheckerFunctions if fun.__name__ == checker_function_name]
            if not checker_functions:
                raise Exception("Unknown checker function " + checker_function_name)
            checker_function = checker_functions[0]
        return TestSuite(checker_function, serialized_object.get('data'))


def deserialize_test_suites(serialized_object):
    if len(serialized_object) == 0:
        return []
    if type(serialized_object[0]) == list:  # old version
        return [TestSuite(compare_return_value_with_expected, serialized_object)]
    return [TestSuite.deserialize(serialized_test_suite) for serialized_test_suite in serialized_object]


def serialize_test_suites(test_suites):
    if len(test_suites) == 1 and test_suites[0].checker_function == compare_return_value_with_expected:
        return test_suites[0].data
    return [test_suite.serialize() for test_suite in test_suites]


# public functions

def test(function, filename):
    if filename[-3:] == '.gz':
        f = gzip.open(filename, "rb")
    else:
        f = open(filename, "rb")

    with f:
        test_suites_json = json.load(f)

    test_suites = deserialize_test_suites(test_suites_json)

    all_tests_passed = True
    for test_suite in test_suites:
        if not test_suite.run(function):
            all_tests_passed = False
            break

    if all_tests_passed:
        print(f"{Fore.GREEN}{function.__name__}: Все тесты пройдены{Fore.RESET}")


def create_tests(correct_function, arguments_lists, filename=None):
    if not filename:
        filename = f'tests/{correct_function.__name__}.json.gz'

    test_cases = [[*arguments, correct_function(*arguments)] for arguments in arguments_lists]

    if filename[-3:] == '.gz':
        f = gzip.open(filename, "wt", encoding="utf8")
    else:
        f = open(filename, "w")

    with f:
        json.dump(test_cases, f)


def write_test_suites(filename, *test_suites):
    if filename[-3:] == '.gz':
        f = gzip.open(filename, "wt", encoding="utf8")
    else:
        f = open(filename, "w")
    with f:
        json.dump(serialize_test_suites(test_suites), f)
