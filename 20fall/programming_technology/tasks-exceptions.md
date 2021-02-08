---
type: tasks
---

## Обработка исключений

1. Реализуйте функцию, `int readInt(String message)`, которая выводит на экран
указанное сообщение и читает с клавиатуры число, которое вводит пользователь.
Если пользователь вводит не число, требуется сказать ему, что введено не число
и снова потребовать ввод.

    Для чтения с клавиатуры создайте сканер `new Scanner(System.in)`. Обратите внимание,
   что закрывать такой сканер не нужно.
   
   Такую задачу правильно было бы решать, используя функцию сканнера `hasNextInt()`,
   чтобы определить, ввел пользователь число или нет. Но я предлагаю делать иначе,
   чтобы разобраться с обработкой исключений.
   
   Читайте введенное пользователем слово с помощью метода `next()`. Вызывайте
   `Integer.parseInt()`, чтобы превратить строку в число. Посмотрите в помощи,
   какое исключение генерирует `Integer.parseInt()`, если строка числом не
   является, и обработайте это исключение.
   
1. Реализуйте функцию `void hateOdds(int n)`, которая ничего не делает, если
получает четное число, и генерирует исключение `Exception`, если нечетное.
После этого напишите программу (в функции, естественно, как и все наши программы),
которая перебирает числа от 1 до 10 и для каждого пишет, вызвала ли функция
`hateOdds()` исключение.