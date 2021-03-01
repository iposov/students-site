def split(s):
    word = ''
    for i in range(len(s)):
        if s[i] != ' ' and i != len(s) - 1:
            word += s[i]
        else:
            word += s[i]
            yield word.strip()
            word = ''

print(list(split("abc def")))
