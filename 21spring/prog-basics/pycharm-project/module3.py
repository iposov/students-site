# можно перебирать все содержимое пакета или модуля:

import packet1

print("inside packet1: ", packet1.__dir__())  # перечисляет всё, что можно вызвать из пакета

# функция __dir__ волшебная, мы ее не писали, но она есть, работает
# и перечисляет всё содержимое пакета или модуля

import packet1.module3 as m3

print("inside packet1.module3", m3.__dir__())
# узнали, что внутри есть переменная 'y' и другие волшебные методы
print(m3.__name__)  # полное имя модуля с пакетами, в которых он
print(m3.__file__)  # абосолютный путь к файлу с модулем

# воспольуемся модулем module_to_run

import module_to_run  # выведется, что имя модуля module_to_run
print(module_to_run.__name__) # то же самое, имя этого модуля
print(module_to_run.useful_function(42))
