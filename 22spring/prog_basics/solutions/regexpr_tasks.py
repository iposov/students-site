import re


def find_email(string):
    pattern = re.compile(r"[a-z\d_-]+@[a-z_\d-]+\.[a-z]{2,}")
    # matches = re.findall(pattern, string)
    return [match.group() for match in re.finditer(pattern, string)]


text = "iposov@gmail.com Replace & List __shichiroku@yandex.ru output custom_shichiroku76@mail.com results. Details lists capture groups."

print(find_email(text))
