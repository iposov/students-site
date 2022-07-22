import itertools

a = ["abc", "xyz", "pqrst"]
b = ["##", "000"]

def h():
    c = ["".join(map("".join, itertools.zip_longest(a, b, fillvalue="")))]
    return c
print(h())



####
my_list = [10, 20, 30, 40]
number = 3
index = 0
while number > 0:
    my_list[index] += 1
    index += 1
    number -= 1
print(my_list)


####
def g():
    y = ['x' * digit for digit in [2, 3, 1]]
    return y
print(g())

####

#Можно сразу присвоить значения
L = 10
n = 5

# или через input()
# L, n = [int(input("Число L: ")) for i in range(1)] + [int(input("Число n: ")) for i in range(1)]
lict = []
c = L // n
d = L % n
for _ in range(n):
    lict.append(c)
for _ in range(d):
    lict[_] += 1
print(lict)

####
list_7 = ["abc", "xyz", "qqqqq"]
print(len(" ".join(list_7)))

####