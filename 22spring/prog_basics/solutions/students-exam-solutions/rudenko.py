def task1 (numbers,ch):
    answ = [ch * i for i in numbers]
    return answ
print (task1([1,3,5],'x'))

def task2(lst1, lst2):
    answ = lst1[0]
    for i in range (len(lst2)):
        answ += lst2[i]
        answ += lst1[i+1]
    return answ
print(task2(["abc", "xyz", "pqrst", 'juyg'],['0','00','0000']))

def task3(lst,digit):
    answ = [lst[i]+1 for i in range(digit)]
    return answ+lst[digit:]
print(task3([10, 20, 30, 40, 50, 60],3))

def task4(lst, digit):
    lst = [lst[i] + 1 for i in range(digit)] + lst[digit:]
    print (lst)
task4([10, 20, 30, 40, 50, 60],3)

def task5(l,n):
    answ = [l//n for i in range(n)]
    answ = task3(answ, l % n)
    return answ
print(task5(20,6))

def task6 (lst,digit):
    space = task5(digit, len(lst) - 1)
    space = [' '*i for i in space]
    answ = task2(lst,space)
    return answ
print(task6(["one", "two", "three"],18))

def task7 (str):
    answ = len(' '.join(str))
    return answ
print(task7(["one", "two", "three"]))

t = open('text.txt', mode='r',encoding='utf-8')
def task8(text):
    book = text.read()
    chars = 0
    words = 1
    for i in range(len(book)):
        chars+=1
        if book[i] == ' ' and book[i-1] != ' ':
            words+=1
    tuple1 = chars, words
    return tuple1
print(task8(t))

f = open("output.txt", mode="a", encoding="utf8")
def task9(text,n):
    book =text.read()
    chars = 0
    words = 1
    for i in range(len(book)):
        chars += 1
        f.write(str(book[i]))
        if chars == n:
                if book[i - 1] ==' ':
                    f.write('\n')
                else:
                    while book[i-1]!=' ':
                        i-=1
        chars=0
task9(t,10)



