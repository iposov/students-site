import inspect
import json
import gzip
import io
import sys

# from colorama import Fore, Back, Style, init as colorama_init
#
# colorama_init()

USE_COLORS = False


def color(text):
    if USE_COLORS:
        return text
    else:
        return ""


class Fore:
    RED = color('\033[31m')
    GREEN = color('\033[32m')
    RESET = color('\033[39m')


class Back:
    LIGHTGREEN_EX = color('\033[102m')
    LIGHTRED_EX = color('\033[101m')
    LIGHTCYAN_EX = color('\033[106m')
    LIGHTYELLOW_EX = color('\033[31m')
    RESET = color('\033[49m')


class Style:
    RESET_ALL = color('\033[49m')


# TODO add number of tests that are allowed to fail
# TODO allow checker function to be a list of functions

class FunctionWrapper:
    def __init__(self, function, additional_parameters):
        self.name = function.__name__
        self.function = function
        self.stdout = ""
        # self.stderr = ""
        # self.exception = None
        self.args = None
        self.kwargs = None
        self.stdin = None
        self.result = None
        # TODO self.check_output_is_always_empty, self.check_results_is_always_None

    def call(self, *args, stdin=None, **kwargs):
        self.args = args
        self.kwargs = kwargs
        self.stdin = stdin
        self.result = None

        previous_stdin = sys.stdin
        previous_stdout = sys.stdout

        if stdin is not None:
            sys.stdin = io.StringIO(stdin)
        sys.stdout = io.StringIO()
        # sys.stderr = io.StringIO()
        # self.exception = None

        try:
            self.result = self.function(*args, **kwargs)
            return self.result
        # except BaseException as e:
        #     self.exception = e
        finally:
            self.stdout = sys.stdout.getvalue()
            # self.stderr = sys.stderr.getvalue()
            sys.stdin = previous_stdin
            sys.stdout = previous_stdout

    def print_call_information(self):
        if self.args is not None or self.kwargs is not None:
            joined_args = ''
            if self.args is not None:
                joined_args += ','.join(str(arg) for arg in self.args)
            if self.kwargs is not None:
                joined_args += ','.join(f'{key}={value}' for key, value in self.kwargs.items())
            print(f"Вызов {self.function.__name__}({joined_args})")
        if self.stdin is not None:
            print("Данные для входного потока:")
            print(f"{Back.LIGHTYELLOW_EX}{self.stdin}{Back.RESET}")


def compare_return_value_with_expected(function, test_environment):
    test_cases = test_environment.data
    for test_case in test_cases:
        *args, correct_answer = test_case
        student_answer = function.call(*args)
        test_environment.assert_result_equals(correct_answer)


class TestSuite:
    CheckerFunctions = (compare_return_value_with_expected,)

    def __init__(self, checker_function, data=None):
        self.checker_function = checker_function
        self.data = data

    def run(self, function, additional_wrapper_parameters, additional_environment_parameters):
        wrapper = FunctionWrapper(function, additional_wrapper_parameters)
        self.checker_function(wrapper, TestEnvironment(wrapper, self.data, additional_environment_parameters))

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


class TestEnvironment:
    def __init__(self, wrapper, data, additional_parameters):
        self.wrapper = wrapper
        self.data = data

        def get_param(name, default):
            if additional_parameters:
                return additional_parameters.get(name, default)
            return default

        self.replace_spaces = get_param('replace', False)

    def _print_message(self, message=None, detailed_message=None, print_call=True):
        if message is not None:
            print(f"{Fore.RED}Ошибка при проверке {self.wrapper.name}: {message}{Fore.RESET}")
        else:
            print(f"{Fore.RED}Ошибка при проверке {self.wrapper.name}{Fore.RESET}")
        if detailed_message is not None:
            print(detailed_message)
        if print_call:
            self.wrapper.print_call_information()

    def fail(self, message, detailed_message, print_call=True):
        self._print_message(message, detailed_message)
        raise AssertionError()

    def assert_equals(self, expected_value, actual_value, message=None, detailed_message=None, print_call=True):
        if expected_value == actual_value:
            return

        self._print_message(message, detailed_message, print_call)

        expected_text = str(expected_value)
        actual_text = str(actual_value)
        if self.replace_spaces is not False:
            replace_symbol = '\u00B7' if self.replace_spaces is True else self.replace_spaces
            expected_text = expected_text.replace(' ', replace_symbol)
            actual_text = actual_text.replace(' ', replace_symbol)
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

        raise AssertionError()

    def assert_result_equals(self, expected_result):
        self.assert_equals(expected_value=expected_result, actual_value=self.wrapper.result,
                           message="Результат функции не совпадает с ожидаемым")

    def assert_output_equals(self, expected_output):
        self.assert_equals(expected_value=expected_output, actual_value=self.wrapper.stdout,
                           message="Результат функции не совпадает с ожидаемым")


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

def test(function, filename, replace_spaces=False):
    if filename[-3:] == '.gz':
        f = gzip.open(filename, "rb")
    else:
        f = open(filename, "rb")

    with f:
        test_suites_json = json.load(f)

    test_suites = deserialize_test_suites(test_suites_json)

    all_tests_passed = True
    try:
        for test_suite in test_suites:
            test_suite.run(function, {}, {"replace_spaces": replace_spaces})
    except AssertionError:
        all_tests_passed = False

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
