---
type: tasks
---

## Vectorization

1. ***task7***
You are given a row matrix, for example, `a = [1, 2, -2, 4]` and a number `x`, for example, 1.
The row `a` specifies coefficients of a polinomial, starting from the lowest degree, that is, the row from
the example specifies the polynomial
\\(1 + 2x - 2x^2 + 4x^3\\). Compute the value of the polinomial at the point `x`.
The answer in the example is 5.
1. ***task8***
You are given a column matrix \\(x\\). Create a square matrix of the same size, its value in the row number \\(i\\) and the column
number \\(j\\) should be equal to \\(a_{i,j} = x_i – x_j\\).
1. ***task9*** You are given a three columns matrix. Imagine, that each row specifies a line of the form \\(ax + by + c = 0\\),
whith the columns being, correspondingly, `a`, `b`, `c`. Return a matrix,
that has two columns, correspondingly, `k` и `b`, that define the same lines, but in the form \\(y = kx + b\\). For example, the row `[1 1 1]` should be converted to the row `[-1 -1]`.
1. ***all2dets(x)***. You are given a matrix `x` of two columns. Return a new square matrix with the size equal to the number of rows in `x`. An element in the row number \\(i\\) and the column
number \\(j\\) should be equal to \\(a_{i,j} = \\left|\\begin{matrix}x_{i,1}&x_{i,2}\\\\x_{j,1} &x_{j,2}\\end{matrix}\\right|\\).
This is a determinant of a matrix composed from the i-th and the j-th rows of `x`. I remind that
\\(\\left|\\begin{matrix}a&b\\\\c&d\\end{matrix}\\right|=ad - bc\\).
1. ***all_lines_intersections(a)***.
You are given a matrix `а` of three columns, it describes a set of lines (as previously). The short task statement is: intersect each line with each line. To be more specific: the intersection of the line from the i-th row and the line from j-th row has two coordinates \\(x\\) and \\(y\\). The function should return two matrices `x` and `y`. The first one contains the x-coordinate of this intersection in the row \\(i\\) and the column \\(j\\). The second one contains, correspondingly, the y-coordinate. Don't consider the case of parallel lines.

    Here is the formula for intersection of lines \\(a_1x+b_1y+c_1\\) = 0 and \\(a_2x+b_2y+c_2 = 0\\):
    
        Δ = det([a1 b1; a2 b2])
        Δx = det([-c1 b1; -c2 b2])
        Δy = det([a1 -c1; a2 -c2])
        x = Δx / Δ
        y = Δy / Δ
            
    So, you will need a prevously implemented `all2dets` function.
