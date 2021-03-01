print("module to run has name:", __name__)  # это имя модуля.


# Если модуль запущен как обычный файл, то его имя "__main__".

# вводим полезную функцию
def useful_function(x):
    return x * (x + 1)

# проверка, что это не импортирование,
# а модуль запущен напрямую
if __name__ == "__main__":
    print("test function")
    for i in range(10):
        print(i, useful_function(i))
