def exam1(list, symbol):
    result = []
    for i in list:
        result.append(symbol*i)
    return result
print(exam1([2, 3, 1], 'x'))

def exam2(list1, list2):
    list3 = []
    for n in range(len(list1)):
        list3.append(list1[n])
        if n == len(list1)-1:
            break
        list3.append(list2[n])
    return ''.join(list3)
print(exam2(['abc', 'xyz', 'fdgghv'], ['1234', '===']))

def exam3(list, c):
    result = list.copy()
    for i in range(c):
        result[i] +=1
    return result
print(exam3([10, 20, 30, 40], 3))

def exam4(list, c):
    for i in range(c):
        list[i] +=1
print(exam4([10, 20, 30, 40], 3))

def exam5(L, n):
    elem =  L//n
    list = []
    for i in range(n):
        list.append(elem)
    rem = L % n
    for j in range(rem):
        list[j] +=1
    return list
print(exam5(10, 5))
print(exam5(20, 6))

def exam6(list, c):
    l = 0
    for i in list:
        l += len(i)
    spaces = 18-l
    elem = spaces // len(list[:-1])
    list1 = []
    for i in range(len(list)):
        list1.append(' '*elem)
    rem = spaces % len(list)
    for j in range(rem):
        list1[j] = (' ')*(len(list1[j])+1)
    list2 = []
    for n in range(len(list)):
        list2.append(list[n])
        if n == len(list) - 1:
            break
        list2.append(list1[n])
    return ''.join(list2)
print(exam6(['one', 'two', 'three'], 18))

def exam7(list):
    l = len(''.join(list))
    return l+len(list)-1
print(exam7(["abc", "xyz", "qqqqq", "fhgvhj"]))

def exam8(file):
    f = open(file, mode='r', encoding='utf8')
    text = f.read()
#    return len(text)
    words = text.split()
#    return len(words)
    l = sum(len(word) for word in words)
#    return l+len(words)-1
    result = (len(text), len(words), l+len(words)-1)
    return result
    f.close()
print(exam8('exam.txt'))

def exam9(file1, n, file2):
    f1 = open(file1, mode='r', encoding='utf8')
    text = f1.read()
    words = text.split()
    words2 = []
    l = 0
    for word in words:
        l += len(word)+1
        if l <= n:
            words2.append(word)
        else:
            words2.append('\n')
            words2.append(word)
            l = len(word)+1
    f2 = open(file2, mode='w', encoding='utf8')
#    letters = [i for i in ' '.join(words2)]
#    for i in range(len(letters)):
#        if i != len(letters)-1:
#            if letters[i] == '\n':
#                letters.pop(i+1)
#    f2.write(''.join(letters))
    f2.write(' '.join(words2))
    f1.close()
    f2.close()
print(exam9('reading.txt', 10, 'writing.txt'))