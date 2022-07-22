#1
def get_list_of_symbols(l, s):
    return([i*s for i in l])

print(get_list_of_symbols([2, 3, 1], 'x'))

#2
def get_concatenated_str(l1, l2):
    return ''.join([l1[i] + l2[i] for i in range(len(l2))]) + l1[-1]

print(get_concatenated_str(["abc", "xyz", "pqrst"], ["##", "000"]))

#3
def get_new_increased_list(l, num):
    return [l[i] + 1 for i in range(num)] + l[num:]

l = [10, 20, 30, 40]
n = 3
print('новый список с увеличенными числами ', get_new_increased_list(l, n))
print('старый список не меняется после передачи в функцию ', l)

#4
def current_increased_list(l, num):
    l[:] = [l[i] + 1 for i in range(num)] + l[num:]

current_increased_list(l, n)
print('старый список изменился внутри функции ', l)

#5
def terms_of_nums(n1, n2):
    rem = n1 % n2
    first_l = [n1 // n2] * n2
    return [first_l[i] + 1 for i in range(rem)] + first_l[rem:]

n1 = 20
n2 = 6
print(f'честное разбиение {n1} на {n2} слагаемых {terms_of_nums(n1, n2)}')

#6
def str_with_spaces(l, n):
    if len(l) == 1:
        s = ''.join(l).ljust(n)
    else:
        num_of_spaces = terms_of_nums(n - len(''.join(l)), len(l) - 1)
        s = get_concatenated_str(l, get_list_of_symbols(num_of_spaces, ' '))
    return s[:n] #обрезаем на случай если изначально был передан список с длиной строк больше n

a = ["one two three"]
b = 18
print(str_with_spaces(a, b))
print(str_with_spaces(a, 3))

#7
def len_str_with_spaces(l):
    return len(' '.join(l))

print(len_str_with_spaces(["abc", "xyz", "qqqqq"]))

#8
def data_info(file):
    with open(file, 'r', encoding='utf-8') as f:
        data = f.read()
    ds = data.split()
    return (len(data), len(ds), len_str_with_spaces(ds))

print(data_info('in.txt'))

#9
def limited_file(file_in, max_len, file_out):
    with open(file_in, 'r', encoding='utf-8') as f:
        data = f.read()
    ds = data.split()
    with open(file_out, 'w') as file:
        file.write(ds[0])
        str_len = len(ds[0])
        for word in ds[1:]:
            if str_len + len(word) + 1 <= max_len:
                file.write(' ' + word)
                str_len = str_len + len(word) + 1
            else:
                file.write('\n' + word)
                str_len = len(word)

print(limited_file('in.txt', 12, 'out.txt'))

#10
def limited_file2(file_in, max_len, file_out):
    with open(file_in, 'r', encoding='utf-8') as f:
        data = f.read()
    ds = data.split()
    lim_l = [[]]

    i = 0
    lim_l[i].append(ds[0])
    str_len = len(ds[0])

    for word in ds[1:]:
        if str_len + len(word) + 1 <= max_len:
            lim_l[i].append(word)
            str_len = str_len + len(word) + 1
        else:
            i += 1
            lim_l.append([])
            lim_l[i].append(word)
            str_len = len(word)

    with open(file_out, 'w') as file:
        for l in lim_l:
            file.write(str_with_spaces(l, max_len) + '\n')

print(limited_file2('in.txt', 12, 'out.txt'))
