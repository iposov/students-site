import a  # импортирование содержимого файла (модуля) a.py
# расширение .py не пишем

# Доступ к содержимому модуля через a.

x = 123
print(x)
print(a.x)
print(a.f(42))  # функция работает

# из модуля a импортируем объекты (переменные, функции) x и f
from a import x, f

print(x)
print(f(42))

# при импорте можно переименовать
from a import x as FOURTY_TWO, f as INCREMENT

print(FOURTY_TWO)
print(INCREMENT(42))

import a as A_MODULE

print(A_MODULE.x)
print(A_MODULE.f(42))

# Все import, from import принято писать только в верху файла

# А теперь импортируем из подкаталогов
import p1.a  # импортирую a.py из подкаталога p1
import p1.inner.a # импортирую a.py из подкаталога p1/inner
import p2.a as A_IN_P2

print(A_IN_P2.x)

# заметим, что волшебная переменная name возвращает полное имя модуля,
# с подкаталогами: p1.inner.a

# В файлах `__init__.py` можно написать код, который будет выполняться
# при первом импортировании пакета
