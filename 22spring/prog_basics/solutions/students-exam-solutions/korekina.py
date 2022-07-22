# task 1

def spisok_strok(a, x):
    spisok = []
    for i in a:
        spisok.append(i*str(x))
    return spisok
print("Задание 1")
print(spisok_strok([2, 3, 1, 7], "h"))

# task 2

def Chered(a,b):
    spisok = [a[0]]
    for i in range (len(b)):
        spisok.append(b[i])
        spisok.append(a[i+1])
    return "".join(spisok)

sp1 = ["abc", "xyz", "pqrst", "oos"]
sp2 = ["##", "000", "77"]
print("\nЗадание 2")
print(Chered(sp1, sp2))

# task 3

def Upgrade1(a,x):
    spisok = a.copy()
    for i in range(int(x)):
        spisok[i] = a[i] + 1
    return spisok

sps = [10, 20, 30, 40, 90, 50]
print("\nЗадание 3")
print("Новый измененный список:", Upgrade1(sps, 4))
print("Изначальный список:",sps)

# task 4

def Upgrade2(a,x):
    for i in range(int(x)):
        a[i] = a[i] + 1

sp = [10, 20, 30, 40, 70]
Upgrade2(sp,4)
print("\nЗадание 4")
print("Измененный изначальный список:", sp)

# task 5

def Slag(L,n):
    chastn = L//n
    ost = L%n
    a = [chastn for i in range(n)]
    Upgrade2(a, ost)
    return a

print("\nЗадание 5")
print(Slag(29,6))

# task 6

def Stroka(a,x):
    if len(a) == 1:
        return a[0]
    x = x - len("".join(a))
    spisok_ch = Slag(x, len(a)-1)
    spisok_st = spisok_strok(spisok_ch, " ")
    stroka = Chered(a, spisok_st)
    return stroka

spis = ["one", "two", "three", "four"]
print("\nЗадание 6")
print(Stroka(spis, 20))

# task 7

def Dlina_stroki(a):
    return len(" ".join(a))

print("\nЗадание 7")
print(Dlina_stroki(spis))

# task 8

def file(a):
    with open(a, mode="r", encoding="utf-8") as f:
        text = f.read()
    return len(text), len(text.split()), Dlina_stroki(text.split())

print("\nЗадание 8")
print(file("test.txt"))

# task 9
def Razb(a, x, b):
    with open(a, mode="r", encoding="utf-8") as f:
        text = f.read()
    new_text = text.split()
    stroka = new_text[0]
    big_stroka = ""
    for i in range(1, len(new_text)):
        r = len(stroka + " " + new_text[i])
        if r > x:
            big_stroka+= stroka + "\n"
            stroka = new_text[i]
        if r <= x:
            stroka+= " " + new_text[i]
    big_stroka += stroka + "\n"
    with open(b, mode="w", encoding="utf8") as f:
        f.write(big_stroka)

Razb("file1.txt", 12, "file2.txt")

#task 10

def Razb2(a,x,b):
    with open(a, mode="r", encoding="utf-8") as f:
        text = f.read()
    new_text = text.split()
    stroka = new_text[0]
    big_stroka = ""
    for i in range(1, len(new_text)):
        r = len(stroka + " " + new_text[i])

        if r > x:
            big_stroka += Stroka(stroka.split(), x) + "\n"
            stroka = new_text[i]
        if r <= x:
            stroka += " " + new_text[i]
    big_stroka += Stroka(stroka.split(), x) + "\n"
    with open(b, mode="w", encoding="utf8") as f:
        f.write(big_stroka)

Razb2("1.txt", 14, "2.txt")



