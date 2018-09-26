---
type: tasks
---

## Indexing

1. ***0task1***
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

1. You are given a row matrix, for example, `a = [1, 2, -2, 4]` and a number `x`, for example, 1.
The row `a` specifies coefficients of a polinomial, starting from the lowest degree, that is, the row from
the example specifies the polynomial
\\(1 + 2x - 2x^2 + 4x^3\\). Compute the value of the polinomial at the point `x`.
The answer in the example is 5.
1. You are given a column matrix \\(x\\). Create a square matrix of the same size, its value in the row number \\(i\\) and the column
number \(j\\) should be equal to \\(a_{i,j} = x_i – x_j\\).
1. You are given a three columns matrix. Imagine, that each row specifies a line of the form \\(ax + by + c = 0\\),
whith the columns being, correspondingly, `a`, `b`, `c`. Return a matrix,
that has two columns, correspondingly, `k` и `b`, that define the same lines, but in the form \\(y = kx + b\\). For example, the row `[1 1 1]` should be converted to the row `[-1 -1]`.
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
