import bs4
# import requests
#
# octopus_link = r"https://ru.wikipedia.org/wiki/%D0%9E%D1%81%D1%8C%D0%BC%D0%B8%D0%BD%D0%BE%D0%B3%D0%B8"
# response = requests.get(octopus_link)
# html = response.text
#
# with open("octopus.html", mode="w", encoding="utf8") as f:
#     f.write(html)
from bs4.element import Tag

with open("octopus.html", mode="r", encoding="utf8") as f:
    octopus_html = f.read()

def get_fist_link(html):
    document = bs4.BeautifulSoup(html, features="lxml")
    div = document.find('div', attrs={'class': 'mw-parser-output'})

    for p in div.find_all('p'):
        print("----------------")
        # попробуем перебрать всё содержимое параграфа

        brackets_count = 0  # сколько скобочек открылось

        for element in p:
            # element может быть bs4.element.Tag
            # или bs4.element.NavigableString

            element_text = ''
            if isinstance(element, Tag):
                # внутри параграфа найден тег
                if element.name == 'a':
                    if brackets_count == 0:
                        return element  # возвращаем тег со ссылкой
                else:
                    # достаём текст из тега, например, из <b>...</b>
                    element_text = element.text
            else:
                # обычный текст внутри нашего параграфа
                element_text = str(element)

            for symbol in element_text:
                if symbol == '(':
                    brackets_count += 1
                elif symbol == ')':
                    brackets_count -= 1
            # print("Обработан текст:")
            # print(element_text)
            # print("Скобок: " +str(brackets_count))



link = get_fist_link(octopus_html)
print("ОТВЕТ")
print(link.attrs['href'])

