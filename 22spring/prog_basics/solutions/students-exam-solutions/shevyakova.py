def f1(list1, st):
    return [st * list1[i] for i in range(len(list1))]


print(f1([2, 3, 1], 'x'))


def f2(list1, list2):
    st = ''
    for i in range(len(list1)):
        st += list1[i]
        if len(list2) > i:
            st += list2[i]
    return st


print(f2(["abc", "xyz", "pqrst"], ["##", "000"]))


def f3(list1, k):
    ll = [list1[i] + 1 for i in range(k)]
    ll.extend(list1[-1:])  # ll.extend(['x'])
    # ll.append(list1[-1]) # ll.append('x')
    return ll


print(f3([10, 20, 30, 40], 3))


def f7(list1):
    return len(" ".join(list1))


ll = ["abc", "xyz", "qqqqq"]
rezult = (f7(ll))
print("Длина строки =  " + str(rezult))


def f8(file):
    simvs = 0  # Количество символов в файле
    words = 0  # количество слов
    length = 0  # длина файла
    list1 = []
    with open(file, mode="r", encoding="utf-8") as f:
        for line in f:
            simvs += len(line)
            for word in line.split():
                words += 1
                length += len(word)
        list1.append(simvs)
        list1.append(words)
        list1.append(length)
        return tuple(list1)


rezult = f8("a.txt")
print(rezult)
print("количество символов:  " + str(rezult[0]) +
      '\n' + "количество слов:  " + str(rezult[1]) +
      '\n' + "длина :  " + str(rezult[2]))


def f3(list1, k):
    ll = [list1[i] + 1 for i in range(k)]
    ll.extend(list1[k:])
    return ll


def f5(L, n):
    Z = L // n
    O = L % n
    list1 = [Z for i in range(n)]
    return f3(list1, O)


print(f5(20, 6))
