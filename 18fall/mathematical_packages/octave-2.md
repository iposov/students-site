---
type: tasks
---

## Indexing

1. ***task1***
You are given a square matrix of even size. (you are not supposed to test that the matrix is actually even and square, just
use it). Imagine we split a matrix vertically and horizontally through the center. Return the matrix at the left-top.
1. ***task2*** You are given a matrix with an even number of rows. Return a new matrix where the top half is exchanged with the bottom half of the
initial matrix.
1. ***task3*** You are given a vector with integer numbers. Return a vector that contains only that numbers of the initial vector, that are
divisible by 3. Use the `mod` function to test divisibilty.
1. Create two functions ***filter_multiples*** and ***seive***. The first one is `filter_multiples(a, k)`, it removes all numbers from the vector `a` that are divisible
by `k`. The second one is `sieve()` and it is as follows:
    ```
    function a = sieve(n)
      a = 1:n;
      i = 2;
      while i < length(a)
        a = filter_multiples(a, a(i));
        i++
      endwhile
    endfunction
    ```
    Explain in comments, what does `sieve(n)` do and how.
1. ***task5*** You are given a matrix with two columns. Each row describes a person: his or her height and a type.
There are two types of people: 1 and 2. Return three column-matrices of size 2.  
The first one contains a sum of heights for each type of people.
The second one contains a mean height for each type.
The third one contains a mean height excluding those who a higher than 2 meters or lower than 1 meter.
1. ***task6*** Double all odd elements of a given row-matrix. For example, `[1, 2, 3] -> [2, 2, 6]`.
    * does your solution work for two dimentional matrices?
    
## Vectorization

(this text will be translated)

1. Дана матрица строка, например, `a = [1, 2, -2, 4]` и число `x`, например 1.
Строка `a` задает коэффициенты многочлена, начиная с младшего, т.е. она соответствует многочлену
\\(1 + 2x - 2x^2 + 4x^3\\). Посчитайте значение многочлена в точке `x`.
Для приведенного примера ответ будет 5. Т.е. необходимо написать выражение через `a` и `x`,
которое считает значение многочлена `a` в точке `x`.
__Замечание__: в Octave есть функция `polyval`, делающая аналогичные действия, но у нее иначе интерпретируются
аргументы. Не пользуйтесь этой функцией при решении задачи.
1. Дана матрица-столбец x. Создать квадратную матрицу такого же размера, которая в i-ой строке
и j-ом столбце содержит разность `x(i) – x(j)`.
1. Дана матрица, состоящая из трех столбцов. Предположим, что каждая строка задает прямую вида \\(ax + by + c = 0\\),
где столбцы — это, соответственно, числа `a`, `b`, `c`. Создайте матрицу, состоящую из двух столбцов с числами,
соответственно, `k` и `b`, которые описывает эти же прямые, только в виде \\(y = kx + b\\). Например, строка `[1 1 1]`
должна превратиться в строку `[-1 -1]`.
1. Функция `all2dets(x)`. Дана матрица `x` из двух столбцов. Создать квадратную матрицу,
размером в количество строчек исходной.
Элемент в i-ой строке j-ом столбце должен быть равен определителю матрицы `[x(i,:); x(j,:)]`, т.е. матрицы 2x2,
составленной из i-ой и j-ой строк исходной матрицы. Напомню, что определитель матрицы
\\(\\begin{pmatrix}a&b\\\\c&d\\end{pmatrix}\\)
равен \\(ad - bc\\).
1. Функция `all_lines_intersections(a)`. Дана матрица `а` из трех столбцов, описывающая набор прямых
(см. предыдущее задание). Если кратко сформулировать условие, то нобходимо пересечь каждую прямую с каждой.
Подробней так: каждое пересечение прямой из строки i с прямой из строки j дает две координаты пересечения x и y.
Функция должна вернуть две матрицы `x` и `y`. Первая содержит x координату этого пересечения в строчке i
и столбце j, вторая содержит, соответственно, y координату. Не обрабатывайте отдельно случаи параллельных прямых,
пусть для параллельных прямых получается произвольный ответ, скорее всего, у вас это будет NaN из-за деления 0 на 0.
Напомню формулу пересечения прямых \\(a_1x+b_1y+c_1\\) = 0 и \\(a_2x+b_2y+c_2 = 0\\):
    ```
    Δ = det([a1 b1; a2 b2])
    Δx = det([-c1 b1; -c2 b2])
    Δy = det([a1 -c1; a2 -c2])
    x = Δx / Δ
    y = Δy / Δ
    ```
Соответственно, пользуйтесь задачей 4 для решения.
