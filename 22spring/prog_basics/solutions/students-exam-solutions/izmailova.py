def func1(b,n):
    # l = [n * b[i] for i in range(len(b))]
    l = [n * x for x in b]
    # for i in range(len(b)):
    #     t=n * b[i]
    #     l.append(t)
    return l

print(func1([1,2,3],'s'))

def func2(list1,list2):
    list3=list1[:-1]
    comblist= zip(list3,list2)
    new_list= [i for sublist in comblist for i in sublist]
    line= "".join(map(str,new_list))
    return line + str(list1[-1])

def func3(list1,n):
    new_list=[]
    for i in range(n):
        t=list1[i]+1
        new_list.append(t)
    for j in range(n,len(list1)):
        new_list.append(list1[j])
    return new_list

def func5(K,n):
    l = [K//n]*n
    for j in range(K%n):
        l[j]=l[j]+1
    return l

def func6(line, n):
    symbols = len("".join(map(str, line)))
    emptylist=" "
    o=[]

    l = [(n-symbols)//len(line)] * (len(line)-1)
    for j in range(n % len(line)):
        l[j] = l[j] + 1

    for i in range(len(l)):
        t = str(emptylist) * l[i]
        o.append(t)
    comblist= zip(line,o)
    new_list = [i for sublist in comblist for i in sublist]
    newline = "".join(map(str, new_list))
    return (newline+str(line[-1]))

def func7(list1):
    line = " ".join(map(str, list1))
    return (len(line))

def func8():
    with open("a.txt", mode="r", encoding="utf-8") as f:
        text = f.read()
        list_of_words= text.split()
        words=len(list_of_words)
        symbols=len("".join(map(str,text.split())))
        return(words,symbols)



print(func2([1,2,'mmm',4],[5,'##',7]))
print(func3([10,20,30,40,50,60],4))
print(func5(16,5))
print(func6(['one','two','thee','four'],25))
print(func7(['abc', 11, 'f22!']))
print(func8())

