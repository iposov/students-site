def task1(num_list, symb):
    # a = list(map(int, input().split()))
    c = [symb * i for i in num_list]
    return c
print(task1([2, 1, 3], "y"))

def task2(a, b):
    s = ""
    for i in range(len(b)):
        s += str(a[i])
        s += str(b[i])
    s += str(a[-1])
    return s
print(task2(["123", "456", "789", "xyz"], ["abc", "def", "ghi"]))

def task3(lst, count):
    a = []
    for i in range(count):
        a.append(lst[i] + 1)
    return a + lst[count:]
print(task3([1, 2, 3, 4], 2))

def task4(lst, count):
    a = []
    for i in range(count):
        a.append(lst[i] + 1)
    print(a + lst[count:])
task4([1, 2, 3, 4], 2)

def task5(S, C):
    return task3([S // C for i in range(C)], S % C)
print(task5(30, 9))

# def task6(lst, num):



def task7(lst):
    a = 0
    for i in range(len(lst)):
        a += len(lst[i])
    return a + len(lst) - 1
print(task7(["one", "two", "three"]))


def task8(txt_file):
    with open(txt_file, mode="r", encoding="utf-8") as f:
        r = f.read()
        symbs = 0
        words = 1
        for i in r:
            if not i.isspace():
                symbs += 1
            else:
                words += 1
        return words, symbs
print(task8("input.txt"))

# def task9(mane_file, num, sec_file):







