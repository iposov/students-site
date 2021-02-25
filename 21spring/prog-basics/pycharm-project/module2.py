print("hello from module2")

# Хочу пользоваться функциями из module1. Используем import:

import module1
import module1 as m1  # переназвал модуль

print(module1.x)  # пользуюсь import module1
print(m1.x)  # пользуюсь import module1 as m1
print(m1.hello("Ilya"))

x = 123  # это x из этого модуля
m1.x = 123  # x из module1
print(m1.x)  # мы изменили x из другого модуля. Лучше так не делать,
# чтобы не усложнять отладку.

# или можно брать отдельные имена из модулей:
from module1 import x
from module1 import x as externalX  # переназываем при импорте

print("Это x из module1", x)  # теперь не надо писать module1.x
print("Это x из module1", externalX)  # аналогично

from module1 import hello

print(hello(42))  # это тоже hello из module1

# обращение к модулям из других пакетов:

import packet1.module3
import packet1.module3 as m3
print(packet1.module3.y)
print(m3.y)

import packet1.packet2.module4 as m4
from packet1.packet2.module4 import z

print("z from module4", z)