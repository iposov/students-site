def repeat_char_list(num_list, char='x'):
    return [char * num for num in num_list]


def alternate_strings(first_list, second_list):
    string_list = [first_list[i] + second_list[i] for i in range(len(second_list))]
    string_list.append(first_list[-1])
    return ''.join(string_list)


def increase_by_1(num_list, threshold):
    new_list = [num + 1 for num in num_list if num_list.index(num) < threshold]
    new_list.extend(num_list[i] for i in range(len(new_list), len(num_list)))
    return new_list


def increase_list_by_1(num_list, threshold):
    for i in range(len(num_list)):
        if i < threshold:
            num_list[i] += 1
    return None


def decompose(L, n):
    quotient = L // n
    decompose_list = [quotient for i in range(n)]
    residue = L % n
    increase_list_by_1(decompose_list, residue)
    return decompose_list


def fill_line(string_list, string_length):
    whitespace_num = string_length - len(''.join(string_list))
    if len(string_list) > 1:
        whitespace_list = repeat_char_list(decompose(whitespace_num, len(string_list) - 1), ' ')
    else:
        string_list.append('')
        whitespace_list = repeat_char_list(decompose(whitespace_num, len(string_list) - 1), ' ')
    filled_string = alternate_strings(string_list, whitespace_list)
    return filled_string


def string_length(string_list):
    return len(' '.join(string_list))


def read_file(file_name):
    with open(file_name, encoding="utf-8", mode='r') as reader:
        file_set = [0, 0, 0]
        for line in reader:
            file_set[0] += len(line)
            file_set[1] += len(line.split())
            file_set[2] += string_length(line.split())
            if line[-1] == '\n':
                file_set[2] += 1
    return tuple(file_set)


def reformat_text(file_name, string_length, new_file_name='output_text'):
    with open(file_name, encoding="utf-8", mode='r') as reader:
        word_list = []
        for line in reader:
            word_list.extend(line.split())
    with open(new_file_name, encoding="utf-8", mode='w') as writer:
        cur_line_length = 0
        cur_string = ''
        for word in word_list:
            if cur_line_length + len(word) < string_length:
                cur_line_length += len(word) + 1
                cur_string += word + ' '
            else:
                cur_string = cur_string[:-1] + '\n'
                writer.write(cur_string)
                cur_string = word + ' '
                cur_line_length = len(word) + 1
        writer.write(cur_string)
    return None


def reformat_text_2(file_name, string_length, new_file_name='output_text_2'):
    with open(file_name, encoding="utf-8", mode='r') as reader:
        word_list = []
        for line in reader:
            word_list.extend(line.split())
    with open(new_file_name, encoding="utf-8", mode='w') as writer:
        cur_line_length = 0
        cur_string = ''
        for word in word_list:
            if cur_line_length + len(word) < string_length:
                cur_line_length += len(word) + 1
                cur_string += word + ' '
            else:
                cur_string = fill_line(cur_string.split(), string_length) + ' '
                cur_string = cur_string[:-1] + '\n'
                writer.write(cur_string)
                cur_string = word + ' '
                cur_line_length = len(word) + 1
        cur_string = fill_line(cur_string.split(), string_length)
        writer.write(cur_string)


def f(x):
    if x < 0:
        return 42

f(-10)  # 42
f(+10)  # None

num_list = [10, 20, 30, 40]
print(increase_by_1(num_list, 3))
print(fill_line(["one", "two", "three"], 18))
print(read_file("exam_text.txt"))
reformat_text("exam_text.txt", 12)
reformat_text_2("exam_text.txt", 12)
