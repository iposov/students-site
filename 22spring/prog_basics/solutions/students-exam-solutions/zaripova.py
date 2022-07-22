def task_1(nlist, sym):
    slist = []
    for i in nlist:
        slist.append(sym*i)
    return slist

print(task_1([1, 4, 3], 'x'))

def task_2(list1, list2):
    altstr = ""
    for i in range(len(list1)):
        altstr = altstr + list1[i]
        if not (i == len(list1) - 1):
            altstr =  altstr +list2[i]
    return altstr

print(task_2(["!!!", "@", "&&&", "7", ":)"], ["have", "a", "nice", "day"]))

def task_3(arr, num):
    arr2 = arr.copy()
    for i in range(num):
        arr2[i] = arr2[i] + 1
    return arr2

arr = [1, 3, 80, 42]
print(arr)
print(task_3(arr, 3))
print(arr)

def task_4(arr, num):
    for i in range(num):
        arr[i] += 1

arr = [1, 3, 80, 42]
print(arr)
task_4(arr, 2)
print(arr)

def task_5(l, n):
    nlist = [l//n]*n
    rest = l % n
    if rest:
        for i in range(rest):
            nlist[i] = nlist[i] + 1
    return nlist

print(task_5(11, 4), task_5(12, 4))

def task_6(slist, lres):
    ls = 0
    for s in slist: ls  = ls +  len(s)
    spaces = task_1(task_5(lres - ls, len(slist) - 1), " ")
    return task_2(slist, spaces)

print(task_6(["Art", "b", "C"], 8))

def task_7(slist):
    l = 0
    for s in slist:
        l = l + len(s)
    l = l + (len(slist) - 1)
    return l

print(task_7(["abc", "xyz", "qqqqq"]), len("abc xyz qqqqq"))

def task_8(fname):
    with open(fname, 'r', encoding = 'utf-8') as file:
        symb = 0
        word = 0
        line  = file.readline()
        while line:
            symb += len(line)
            word += len(line.split())
            line = file.readline()
    return symb, word

print(task_8("ex.txt"))