import re


def find_email(string):
    pattern = re.compile(r"[a-z\d_-]+@[a-z_\d-]+\.[a-z]{2,}")
    # matches = re.findall(pattern, string)
    return [match.group() for match in re.finditer(pattern, string)]


text = "iposov@gmail.com Replace & List __shichiroku@yandex.ru output custom_shichiroku76@mail.com results. Details lists capture groups."

print(find_email(text))

"""
Дана строка с текстом на русском языке.
В тексте встречаются номера телефонов — последовательности от 7 до 10
цифр, возможно, с плюсом в начале. Между соседними цифрами либо ничего
нет, либо есть скобки, минусы, пробелы. Верните список из всех
найденных номеров телефонов.
"""

def find_phone_numbers(text):
    # phone_regexp = r'\+?\d{7,10}'
    # 1-------2-------3-------4-------5-------6-------7
    #\d  []* \d  []*  \d []* \d  []* \d  []* \d   []* \d
    phone_regexp = r'\+?\d([() -]*\d){6,9}'
    return [match.group() for match in re.finditer(phone_regexp, text)]

print(find_phone_numbers("""
Это длинный текст с номерами +79214014400 еще телефон +73423305304 +112323443 вот.
12314234234234234234 +1(234)23-423-34
"""))
