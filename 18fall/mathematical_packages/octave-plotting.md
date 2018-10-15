---
type: tasks
---

## Plotting

### Графика в Ocatave `octave-graphics` ___понедельник 16 октября 23:59___
Don't use loops, unless the opposite is explicitly stated.

1. ***task1*** Plot the function \\(\\sin(x) + \\sin(3x)\\) from \\(-2\\pi\\) to \\(2\\pi\\). The function `task1` should
both create a plot, and return two values: `x` and `y` with coordintes of points that were passed to `plot(x,y)`.
1. ***task2*** Plot \\(\\sin(x) + \\frac1{2}\\sin(2x) +
\\frac1{3}\\sin(3x) + \\cdots + \\frac1{10}\\sin(10x)\\).
Think how to do it without loops. Remember, that `sin` accepts matrices
and evaluates results for each element separately. 
Return the result the same way you did in the previous task.
1. ***taskA*** You are given a matrix `A` of the size \\(N\\times2\\),
each row contains coordinates of one point on the plane.
In this task the function should not return results, and it
should only draw one picture consisting of the following:
    1. Draw set `A`
    1. Draw the center of mass for `A`.
    1. Create and draw the set `B` that is a translation of `A` in such a way that its
    center of mass is in \\((0, 0)\\). Remind: translated by the vector \\((dx, dy)\\),
    point \\((x, y)\\) goes to \\((x + dx, y + dy)\\).
    1. Create and draw the set `C`: a rotation of A around (0, 0) by
    \\(5^\\circ\\).
    Remind: to rotate the point \\((x, y)\\) by \\(\\varphi\\) around zero,
    one should left-multiply \\(\\begin{pmatrix}x\\\\y\\end{pmatrix}\\)
    by the matrix
    \\(\\begin{pmatrix}\\cos(\\varphi)&\\sin(\\varphi)\\\\-\\sin(\\varphi)&\\cos(\\varphi)\\end{pmatrix}\\).
    1. Create and draw the set `D`: 
    A rotation of `А` around its center of mass by \\(5^\\circ\\).
    
    Draw each set with a different color and a different marker.
1. ***task10circles*** Draw 10 concentric circles with radiuses: 1, 2, …, 10.
Use the fact, that points with coordinates \\((\\cos(\\varphi),
\\sin(\\varphi))\\) lay on a circle of radius 1, when \\(\\varphi\\)
changes from 0 to \\(2\\pi\\).
1. ***plot_line*** You are given a linear matrix `[a, b, c]`.
You are also given matrices `xrange=[xmin, xmax]` and
`yrange=[ymin, ymax]`.
Plot a line \\(ax + by + c = 0\\), and draw only that part of the line,
that is contained inside a rectangle \\(x_{min} \\leq x \leq x_{max}\\), and
\\(y_{min} \\leq y \\leq y_{max}\\). Consider all the cases, including vertical
lines.
    
    One of the ways to solve the task is as follows: intersect the line
    with each of the rectangle sides. They are horizontal and vertical, 
    so it is quite easy to find intersections. Usually, you are left with
    only two intersections, so you now can call `plot()` for the line between
    the two points.
1. ***plot_lines***. You are given a matrix `a` with lines (the same as
matrices from the block [octave-vectorization](octave-vectorization.md),
you are also given `xrange`, `yrange` with ranges to draw the lines by means
of the `plot_line` function from the previous task. Draw all of the lines
from `a`. Use a loop to call plotting for each line.
1. ***plot_lines_and_intersections*** You are given the same as in
the previous task. Draw all lines from the matrix `a` and draw all the intersections.
Remember, that you have already implemented evaluating of intersections
in the block [octave-vectorization](octave-vectorization.md).
