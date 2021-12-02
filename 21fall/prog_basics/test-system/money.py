a = {
    500: 1,
    200: 2,
    100: 19,
    50: 22,
    10: 100 + 101,
    5: 100 + 57,
    2: 175,
    1: 100 + 217,
    0.5: 32,
    0.1: 10,
    0.05: 0
}

s = 0
for num, count in a.items():
    if num < 50:
        s += num * count

print(s)
print(4100 / s)
