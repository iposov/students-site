---
type: tasks
---

### Solve equations 
1. ***task1*** You are given  `n`, find roots of the polynomial
\\(x^n + x^{n - 1} + \\cdots + x + 1\\), that is a polynomial of degree \\(n\\),
that has all coefficints equal to 1. Return roots as one row-matrix.
    * Make the function `task1` also plot the roots on a complex plane.
    Just call `plot` for the matrix with roots.
    * comment out the `plot` that you have just made. Extract real and imaginary
    parts of the roots and then plot them again by supplying real-valued
    x and y coordinates of the roots.
1. ***task2*** Solve the equation \\(x + \\sin(x)=1\\).
1. ***task3*** solve the system of equations
      \\(\begin{cases} x + \\sin(y) = 1 \\\\ y + \\cos(x) = 1 \end{cases}\\)
1. ***task4*** You are given a real number `a`. Solve the equation
\\(e^x - e^{-x}=a\\). Return for results from the function:
    * Solve with `fsolve`.
    * Solve with `fzero`, you will need to specify a segment where to search for the solution. 
    * Solve with an explicit expression. Think, how to express `x` in terms of `a`.
    * The difference between solutions with the explicit expression and with `fsolve`.
    
    test your function on `a = 1 000 000`.
1. ***task_circles*** The circle is specified with a matrix of three values:
`[x, y, r]`, that is its center and its radius. You are given two circles.
Find their intersections. To do this, create a system of two equations,
and use `fsolve` to solve it. Your function should return a matrix
with two rows, where intersection points are defined by columns.
The function should also draw both circles and use a special marker to
mark intersections. Don't use an explicit expression for evaluating intersections and
don't do any geometry. Just use `fsolve`.
    * To start, find at least one intersection point
    * Then find both points. Think, what initial points should be specified for `fsolve`.

