def t1(list, x):
    r = []
    for e in list:
        r.append(x * e)
    return r


print("Первое задание:")
print(t1([2, 1, 3], 'x'))
print(t1([], 'x'))
print(t1([2, 2], 'x'))
print(t1([0], 'x'))


def t2(list1, list2):
    res = list1[0]
    for i in range(len(list2)):
        res = res + list2[i] + list1[i + 1]
    return res


print("Второе задание:")
print(t2(["abc", "cda"], ["###"]))
print(t2(['abc', 'xyz', 'pqrst'], ['##', '000']))


def t3(list, n):
    res = list.copy()
    rng = min(n, len(list))
    for i in range(rng):
        res[i] = res[i] + 1
    return res


print("Третье задание:")
print(t3([10, 20, 30, 40], 3))
print(t3([1, 2, 3], 1))


def t4(list, n):
    rng = min(n, len(list))
    for i in range(rng):
        list[i] = list[i] + 1


print("Четвёртое задание:")
print(t4([10, 20, 30, 40], 3))
print(t4([1, 2, 3], 1))


def t5(L, n):
    fair = L // n
    res = []
    for i in range(n):
        res.append(fair)
    mod = L % n
    t4(res, mod)
    return res


print("Пятое задание:")
print(t5(10, 5))
print(t5(11, 5))
print(t5(20, 6))
print(t5(22, 6))


def t6(words, l):
    wordsLen = 0
    for word in words:
        wordsLen = wordsLen + len(word)
    spaceAmount = l - wordsLen
    spaceCntList = t5(spaceAmount, len(words) - 1)
    spaceList = t1(spaceCntList, ' ')
    return t2(words, spaceList)


print("Шестое задание:")
print("'", t6(['one', 'two', 'three'], 18), "'", sep="")


def t7(words):
    ans = 0
    for word in words:
        ans = ans + len(word) + 1
    ans = ans - 1
    return ans


print("Седьмое задание:")
print(t7(['abc', 'xyz', 'qqqqq']))
print(t7(['abc', 'xyz', 'qqqqq','yyhyyy']))


def t8(filename):
    sCnt = 0
    words = []
    with open(filename, 'r') as file:
        for line in file:
            sCnt = sCnt + len(line)
            words = words + line.split()
    return (sCnt, len(words), t7(words))


print("Восьмое задание:")
print(t8("1.txt"))