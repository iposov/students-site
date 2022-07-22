def zad1(arr, ch):
    return [ch * num for num in arr]


def zad2(arr1, arr2):
    arr = [str(a) + b for a, b in zip(arr1, arr2)]
    arr.append(arr1[-1])
    return ''.join(arr)


def zad3(arr, num):
    arr2 = [i + 1 for i in arr if arr.index(i) < num]
    arr2.extend(arr[i] for i in range(len(arr2), len(arr)))
    return arr2


def zad4(arr, num):
    for i in range(num):
        arr[i] += 1


def zad5(l, n):
    arr = [l // n] * n
    zad4(arr, l % n)
    return arr


def zad6(arr, num):
    if len(arr) == 1:
        arr.extend(' ')
    letters_len = 0
    for i in range(len(arr)):
        letters_len += len(arr[i])
    total_spaces_len = num - letters_len
    total_spaces_arr = zad5(total_spaces_len, len(arr) - 1)
    total_spaces_arr = zad1(total_spaces_arr, ' ')
    s = zad2(arr, total_spaces_arr)
    return s


def zad7(arr):
    return len(''.join(arr))+len(arr)-1


def zad8(file):
    with open(file) as f:
        s = f.read()
    return tuple[len(s), len(s.split()), zad7(s.split())]


def zad9(file1, file2):
    with open(file1, encoding='utf-8', mode='r') as input_file:
        s = []
        for line in input_file:
            s.extend(line.split())
    with open(file2, encoding='utf-8', mode='w') as output_file:
        output_file.write(s[0])
        i = len(s[0])
        for word in s[1:]:
            if i+len(word)+1 > 12:
                output_file.write('\n'+word)
                i = len(word)
            else:
                output_file.write(' '+word)
                i = i+len(word)+1


def zad10(file1, file2):
    with open(file1, encoding='utf-8', mode='r') as input_file:
        s = []
        for line in input_file:
            s.extend(line.split())
    with open(file2, encoding='utf-8', mode='w') as output_file:
        buff_str = s[0]
        for word in s[1:]:
            if len(word)+len(buff_str)+1 > 12:
                output_file.write(zad6(buff_str.split(), 12)+'\n')
                buff_str = word
            else:
                buff_str += ' ' + word


print(zad1([1, 3, 2], 'x'))
print(zad2(["abc", "xyz", "pqrst"], ["##", "000"]))
print(zad3([49, 10, 15, 100], 3))
print(zad5(12, 7))
print(zad6(['one', 'two', 'three'], 18))
print(zad7(["abc", "xyz", "qqqqq"]))
print(zad8('zad8.txt'))
zad9('zad9_input.txt', 'zad9_output.txt')
zad10('zad10_input.txt', 'zad10_output.txt')
