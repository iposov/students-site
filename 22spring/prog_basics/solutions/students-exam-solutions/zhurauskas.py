
def func1(nums, sym):
    res = []
    for i in range(len(nums)):
        res.append(str(sym) * nums[i])
    return res


def func2(list1, list2):
    res = ''
    for i in range(len(list2)):
        res += list1[i] + list2[i]
    res += list1[-1]
    return res


def func3(arr, num):
    res = []
    for i in range(len(arr)):
        if i < num:
            res.append(arr[i] + 1)
        else:
            res.append(arr[i])
    return res


def func4(arr, num):
    for i in range(num):
        arr[i] += 1


def func5(L, n):
    res = [L // n] * n
    for i in range(L % n):
        res[i] += 1
    return res


def func7(list):
    res = len(list) - 1
    for i in range(len(list)):
        res += len(list[i])
    return res


print(func1([2, 3, 1], 'x'))
print(func2(['q', 'w', 'e'], ['1', '2']))
print(func3([10 ,20 ,30 ,40], 3))
arr = [10 ,20 ,30 ,40]
func4(arr, 3)
print(arr)
print(func5(20, 6))
print(func7(["abc", "xyz", "qqqqq"]))

