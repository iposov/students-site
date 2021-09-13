# Примеры кода на Python

Эти примеры нужны, чтобы начать решать первые задачи, пока мы еще не успели полноценно начать изучать язык.

```python
# комментарии после диеза
x = 10 # присваивание переменной
print(x) # распечатать значение переменной
print(x * 2 + 1) # или выражения
if x == 10:  #условие
    print("икс равно десять") # после отступа в 4 пробела
    print("икс точно не двадцать") # все, что после отступа находится внутри if
print("это уже не внутри if") # это выполнится всегда

# вариант с else:
if x == 10:  # == это операция сравнения (в PASCAL это будет = )
             # = это операция присваивания (в PASCAL это будет := )
    print("x равен 10")								   
else: # обратите внимание еще на двоеточие
    print("x не равен 10")
	
# деление
print(100 / 5) # 20.0
print(101 / 5) # 20.2 это вещественные числа
print(100 // 5) # 20 целое число
print(101 // 5) # 20 целочисленное деление
print(101 % 5) # 1. остаток от деления.
print(100 % 15) # 10. остаток от деления на 15.
                # 100 = 15*6 + 10

# логические связки
if x > 10 and x % 10 == 2:
    print("x больше 10 и дает остаток 2 при делении на 10")
	
if x > 10 or x % 10 == 2:
    print("x больше 10 или дает остаток 2 при делении на 10")

# можно группировать выражения скобками
if x == 1 and (y == 2 or y == 3):
    print("x равен один, а y равно 2 или 3")
  
y = 100  # введем еще одну переменную    

# Вложенное условие
if x > 10:
    if y > 20:
        print("x>10, y>20")
    else:
        print("x>10, y<=20")
else: # к первому if		
    if y > 20:
        print("x<=10, y>20")
    else:
        print("x<=10, y<=20")
```