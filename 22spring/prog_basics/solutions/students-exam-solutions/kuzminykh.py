def task_1(numbers, symbol):
    return [symbol * num for num in numbers]


print(task_1([2, 3, 1], 'x'))


def task_2(list_1, list_2):
    string = ''
    for i in range(len(list_1)):
        string += list_1[i]
        if i == len(list_1) - 1:
            break
        string += list_2[i]
    return string


print(task_2(["abc", "xyz", "pqrst"], ["##", "000"]))


def task_3(numbers, digit):
    new_numbers = []
    for i in range(digit):
        new_numbers.append(numbers[i] + 1)
    if digit < len(numbers):
        for num in numbers[digit:]:
            new_numbers.append(num)
    return new_numbers


print(task_3([10, 20, 30, 40], 3))


def task_4(numbers, digit):
    for i in range(digit):
        numbers[i] += 1


numbers = [10, 20, 30, 40]
task_4(numbers, 2)
print(numbers)


def task_5(dividend, divider):
    comp = dividend // divider
    remainder = dividend % divider
    comps = [comp for i in range(divider)]
    for i in range(remainder):
        comps[i] += 1
    return comps


print(task_5(20, 6))


def task_6(words, length):
    words_length = 0
    for word in words:
        words_length += len(word)
    space_length = length - words_length
    if len(words) == 1:
        string = words[0] + ' ' * (length - len(words[0]))
    else:
        spaces = task_1(task_5(space_length, len(words) - 1), ' ')
        string = task_2(words, spaces)
    return string


print(task_6(["one", "two", "three"], 18))


def task_7(words):
    spaces = task_1(task_5(len(words) - 1, len(words) - 1), ' ')
    string = task_2(words, spaces)
    return len(string)


print(task_7(["one", "two", "three", "four"]))


def task_8(filename):
    with open(filename, encoding='utf8', mode='r') as file:
        text = file.read()
        length = len(text)
        words = text.split()
        words_length = len(words)
        optional_length = task_7(words)
        return length, words_length, optional_length


print(task_8('text.txt'))


def task_9(filename, string_length, output):
    with open(filename, encoding='utf8', mode='r') as file, open(output, encoding='utf8', mode='w') as output_file:
        string = file.read()
        words = string.split()
        length = [len(word) for word in words]
        total = 0
        prev_index = 0
        for index, num in enumerate(length):
            if total + num >= string_length:
                output_file.write(' '.join(words[prev_index:index]) + '\n')
                prev_index = index
                total = num
                continue
            total += num + 1
        output_file.write(' '.join(words[prev_index:]))


task_9('text.txt', 15, 'output1.txt')


def task_10(filename, string_length, output):
    with open(filename, encoding='utf8', mode='r') as file, open(output, encoding='utf8', mode='w') as output_file:
        string = file.read()
        words = string.split()
        length = [len(word) for word in words]
        total = 0
        prev_index = 0
        for index, num in enumerate(length):
            if total + num >= string_length:
                output_file.write(task_6(words[prev_index:index], string_length) + '\n')
                prev_index = index
                total = num
                continue
            total += num + 1
        output_file.write(task_6(words[prev_index:], string_length))


task_10('text.txt', 25, 'output2.txt')
