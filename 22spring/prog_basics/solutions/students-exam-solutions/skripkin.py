def task_1(numbers_list, symbol):
    return [symbol * i for i in numbers_list]


print(task_1([2, 3, 1], 'x'))


def task_2(list_1, list_2):
    s = str()
    for i in range(len(list_2)):
        s += list_1[i] + list_2[i]
    s += list_1[-1]
    return s


print(task_2(['abc', 'xyz', 'pqrst'], ['##', '000']))


def task_3(numbers_list, number):
    return [i + 1 for i in numbers_list[:number]] + numbers_list[number:]


print(task_3([10, 20, 30, 40], 3))


def task_4(numbers_list, number):
    for i in range(number):
        numbers_list[i] += 1


numbers_list = [10, 20, 30, 40]
task_4(numbers_list, 3)
print(numbers_list)


def task_5(l, n):
    result = [l // n] * n
    return task_3(result, l % n)


print(task_5(20, 6))


def task_6(string_list, number):
    if len(string_list) > 1:
        spaces_number = number - sum([len(i) for i in string_list])
        return task_2(string_list, task_1(task_5(spaces_number, len(string_list) - 1), ' '))
    else:
        return string_list[0]


print(task_6(['one', 'two', 'three'], 18))


def task_7(string_list):
    return sum([len(i) for i in string_list]) + len(string_list) - 1


print(task_7(['abc', 'xyz', 'qqqqq']))


def task_8(filename):
    with open(filename, 'r', encoding='utf-8') as f:
        text = f.read()
    return (len(text), len(text.split()), task_7(text.split()))


print(task_8('C:/study/test_text.txt'))


def task_9(filename_input, filename_output, number):
    with open(filename_input, 'r', encoding='utf-8') as f:
        text = f.read()
    text = text.split()

    result = str()
    s = [text[0]]
    for i in text[1:]:
        if (sum([len(i) for i in s]) + len(s) + len(i)) <= number:
            s += [i]
        else:
            result += ' '.join(s) + '\n'
            s = [i]
    result += ' '.join(s) + '\n'

    with open(filename_output, 'w') as f:
        f.write(result)


task_9('C:/study/text_input.txt', 'C:/study/text_output.txt', 12)


def task_10(filename_input, filename_output, number):
    with open(filename_input, 'r', encoding='utf-8') as f:
        text = f.read()
    text = text.split()

    result = ''
    s = [text[0]]
    for i in text[1:]:
        if (sum([len(i) for i in s]) + len(s) + len(i)) <= number:
            # s += [i]
            s.append(i)
        else:
            result += task_6(s, number) + '\n'
            s = [i]
    result += task_6(s, number) + '\n'

    with open(filename_output, 'w') as f:
        f.write(result)


task_10('C:/study/text_input.txt', 'C:/study/text_output.txt', 12)
