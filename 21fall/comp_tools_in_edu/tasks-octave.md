---
type: tasks
---

# Octave tasks

## Create matrices

Solve tasks from this block in a folder named `octave-matrices`. Name files as written in the beginning of each task, files should have the `.m` extension.

Each task asks you to create a certain matrix. Please, use only methods that were discussed at the lecture or in lecture notes available on this site. That is, for example, don't use loops and functions such as `repmat`. And try to find a short solution, especially, don't enter all the values manually.

1. **task_10x10**

   The \\(10\\times10\\) matrix:

   \\(  \\begin{pmatrix}
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\ %
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0
   \\end{pmatrix} \\)

3. **task_border**

Create a border-matrix \\(10\\times10\\), it should have 0s everywhere except 1s at the border:

   \\(  \\begin{pmatrix}
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ % 
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\ %
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1
   \\end{pmatrix} \\)

4. **task_2_5x5**

   The \\(5\\times5\\) matrix:

   \\(  \\begin{pmatrix}
   2 & 2 & 2 & 2 & 2 \\\\ 2 & 2 & 2 & 2 & 2 \\\\ %
   2 & 2 & 2 & 2 & 2 \\\\ %
   2 & 2 & 2 & 2 & 2 \\\\ %
   2 & 2 & 2 & 2 & 2
   \\end{pmatrix} \\)

5. **task_0123**

   The \\(10\\times10\\) matrix:

   \\(  \\begin{pmatrix}
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\ 0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\ %
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\ %
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\ %
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\ %
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\ 2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\ %
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\ %
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\ %
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3
   \\end{pmatrix} \\)

6. **task_chess**

   The \\(10\\times10\\) matrix with the chess-board order of 0's and 1's:

   \\(  \\begin{pmatrix}
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\ %
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\ %
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\ %
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\ %
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0    
   \\end{pmatrix} \\)

7. **task_1_to_9_lines**

   The \\(9\\times9\\) matrix:

   \\(  \\begin{pmatrix}
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 \\\\ 2 & 2 & 2 & 2 & 2 & 2 & 2 & 2 & 2 \\\\ 3 & 3 & 3 & 3 & 3 & 3 & 3 & 3 & 3 \\\\ 4 & 4 & 4 & 4 & 4 & 4 & 4 & 4 & 4 \\\\ 5 & 5 & 5 & 5 & 5 & 5 & 5 & 5 & 5 \\\\ 6 & 6 & 6 & 6 & 6 & 6 & 6 & 6 & 6 \\\\ 7 & 7 & 7 & 7 & 7 & 7 & 7 & 7 & 7 \\\\ 8 & 8 & 8 & 8 & 8 & 8 & 8 & 8 & 8 \\\\ 9 & 9 & 9 & 9 & 9 & 9 & 9 & 9 & 9
   \\end{pmatrix} \\)

8. **task_1_to_100**

   The \\(10\\times10\\) matrix with a range of numbers from 1 to 100:

   \\(  \\begin{pmatrix}
   1 & 2 & 3 & 4 & 5 & 6 & 7 & 8 & 9 & 10 \\\\ 11 & 12 & 13 & 14 & 15 & 16 & 17 & 18 & 19 & 20 \\\\ 21 & 22 & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & 99 & 100
   \\end{pmatrix} \\)

9. **task_multiplication_table**

   The \\(9\\times9\\) matrix with a "multiplication table". That is, the element
   `a(i, j) = i * j`:

   \\(  \\begin{pmatrix}
   1 & 2 & 3 & 4 & 5 & 6 & 7 & 8 & 9\\\\ 2 & 4 & 6 & 8 & 10 & 12 & 14 & 16 & 18 \\\\ 3 & 6 & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & 56 & . \\\\ . & . & . & . & . & . & . & . & . \\\\ . & . & . & . & . & . & . & 72 & 81
   \\end{pmatrix} \\)

10. **task_3_diags**

    You are given numbers `n`, `a`, `b`. Create a matrix of size $n\times n$,
    that has `a` on the main diagonal, `b` strictly below and above the main
    diagonal, and 0 in all other places.
    Here is an example for arguments (4, 1, 2):
    ```
    1 2 0 0
    2 1 2 0
    0 2 1 2
    0 0 2 1
    ``` 
11. **task_double_chess**

    This task is similar to the chess-board task, but the size of matrix should
    be $20\times20$, and cells with ones or zero should have size $2\times2$:

     ```
     0 0 1 1 0 0 .....
     0 0 1 1 0 0 .....
     1 1 0 0 1 1 .....
     1 1 0 0 1 1 .....
     .................
     ``` 
12. **task_chukh**.

    You are given a number `n`. Create the matrix of size $n\times n$ of the
    following structure: Its main diagonal has numbers 1 and 2 that go. Дальше от каждой клетки главной диагонали направо и вниз расставляется то же числа, что и в самой этой клетке. Пример для аргумента (5):
    ```
    1 1 1 1 1
    1 2 2 2 2
    1 2 1 1 1
    1 2 1 2 2
    1 2 1 2 1
    ```
    Try to avoid loops.
    Additional question. What is a determinant of this matrix? Can you explain,
    why the determinant is as it is?

13. **task_domino**. Based on [http://www.math.cornell.edu/~levine/18.312/alg-comb-lecture-18.pdf](http://www.math.cornell.edu/~levine/18.312/alg-comb-lecture-18.pdf)

   **Additional task**. You may use loops in this task. 

   You are given natural numbers $m$ and $n$, they are the size of a rectangles made of
cells. There are $m\times n$ cells, they are numbered from $1$ to $m\cdot n$.

   Create a matrix $A$ of size $m\cdot n\times m\cdot n$, in which the element at $i,j$ contains:
   
    * 1, if cells $i$ and $j$ are next to each other horizontally,
    * complex unit ($\texttt i$), if cells $i$ and $j$ are next to each other vertically,
    * 0 otherwise

    Evaluate the determinant of $A$ and take the square root of it.
    You will get the number of domino tilings of a $m\times n$ rectangle. 

## Indexing `octave-indexing`

1. **task_left_top**
   You are given a square matrix of an even size. (you are not supposed to test that the matrix is actually even and square, just
   use it). Imagine we split a matrix vertically and horizontally through the center. Return the matrix at the left-top.
1. **task_bottom_half**
   You are given a matrix with an even number of rows. Return a new matrix where the top half is exchanged with the bottom half of the
   initial matrix.
1. **task_mod_3**
   You are given a vector with integer numbers. Return a vector that contains only that numbers of the initial vector, that are
   divisible by 3. Use the `mod` function to test divisibilty.
1. **task_div_by_2** Given a vector of integer numbers, return a vector with the same
   numbers, but where even numbers are divided by 2. Will your solution work if
   the matrix is 2 dimensional?
1. Create two functions **filter_multiples** and **seive**. The first one is `filter_multiples(a, k)`,
   it removes all numbers from the vector `a` that both are divisible by `k` and are strictly greater than `k`. For example, `filter_multiples([1 2 3 4 5 6 7 8 9 10], 3)` yields `[1 2 3 4 5 7 8 10]`.

   The second one is `sieve(n)`, and it implements [the Sieve of Eratosthenes](https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes).
   You will probably need to use the while loop.
1. **task_animals** You are given a matrix with two columns. Each column describes
   an animal: its height in meters and weight in kg.
   Return the following set of answers:
   * sum of animals' heights
   * mean height of animals
   * mean height of animals that are higher than 100 kg
   * one column matrix with the body mass index (BMI) of animals. BMI is equal to
     weight divided by the square of height.
   * two columns matrix with animals, that are higher than 10 meters, and heaver than 100 kg.

## Vectorization `octave-vectorization`

1. **task_polyval**
   You are given a row matrix, for example, `a = [1, 2, -2, 4]` and a number `x`, for example, 1.
   The row `a` specifies coefficients of a polinomial, starting from the lowest degree, that is, the row from
   the example specifies the polynomial
   \\(1 + 2x - 2x^2 + 4x^3\\). Compute the value of the polinomial at the point `x`.
   The answer in the example is 5.
1. **task_sub_ij**
   You are given a column matrix \\(x\\). Create a square matrix of the same size, its value in the row number \\(i\\) and the column
   number \\(j\\) should be equal to \\(a_{i,j} = x_i – x_j\\).
1. **task_convert_line_equations** You are given a three columns matrix. Imagine, that each row specifies a line of the form \\(ax + by + c = 0\\),
   whith the columns being, correspondingly, `a`, `b`, `c`. Return a matrix,
   that has two columns, correspondingly, `k` и `b`, that define the same lines, but in the form \\(y = kx + b\\). For example, the row `[1 1 1]` should be converted to the row `[-1 -1]`.
1. **task_all_dets**. You are given a matrix `x` of two columns. Return a new square matrix with the size equal to the number of rows in `x`. An element in the row number \\(i\\) and the column
   number \\(j\\) should be equal to \\(a_{i,j} = \\left|\\begin{matrix}x_{i,1}&x_{i,2}\\\\x_{j,1} &x_{j,2}\\end{matrix}\\right|\\).
   This is a determinant of a matrix composed from the i-th and the j-th rows of `x`. I remind that
   \\(\\left|\\begin{matrix}a&b\\\\c&d\\end{matrix}\\right|=ad - bc\\).
1. **task_all_lines_intersections**.
   You are given a matrix `а` of three columns, it describes a set of lines (as previously). The short task statement is: intersect each line with each line. To be more specific: the intersection of the line from the i-th row and the line from j-th row has two coordinates \\(x\\) and \\(y\\). The function should return two matrices `x` and `y`. The first one contains the x-coordinate of this intersection in the row \\(i\\) and the column \\(j\\). The second one contains, correspondingly, the y-coordinate. Don't consider the case of parallel lines.

   Here is the formula for intersection of lines \\(a_1x+b_1y+c_1\\) = 0 and \\(a_2x+b_2y+c_2 = 0\\):

        Δ = det([a1 b1; a2 b2])
        Δx = det([-c1 b1; -c2 b2])
        Δy = det([a1 -c1; a2 -c2])
        x = Δx / Δ
        y = Δy / Δ

   So, you will need a previously implemented `all2dets` function.

## Plotting `octave-plotting`

Don't use loops, unless the opposite is explicitly stated. Your functions
will have the side effect: they draw some plot. They should not return
anything.

1. **task_house** Draw a house. You should draw just a few lines, of the house
   body, its roof, may be a window or a door. Don't draw a lot to not spend
   a lot of time for this task.
1. **task_plot_sin** Plot the function \\(\\sin(x) + \\sin(3x)\\) from \\(-2\\pi\\) to \\(2\\pi\\).
1. **task_plot_10_sin** Plot \\(\\sin(x) + \\frac1{2}\\sin(2x) +
   \\frac1{3}\\sin(3x) + \\cdots + \\frac1{10}\\sin(10x)\\).
   Think how to do it without loops. Remember, that `sin` accepts matrices
   and evaluates results for each element separately.
1. **task_plot_A** You are given a matrix `A` of the size \\(N\\times2\\),
   each row contains coordinates of one point on the plane.
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
1. **task_10circles** Draw 10 concentric circles with radiuses: 1, 2, …, 10.
   Use the fact, that points with coordinates \\((\\cos(\\varphi),
   \\sin(\\varphi))\\) lay on a circle of radius 1, when \\(\\varphi\\)
   changes from 0 to \\(2\\pi\\).
1. **task_plot_line** __this is a hard task__ You are given a linear matrix `[a, b, c]`.
   You are also given matrices `xrange=[xmin, xmax]` and
   `yrange=[ymin, ymax]`.
   Plot a line \\(ax + by + c = 0\\), and draw only the part of the line,
   that is contained inside a rectangle \\(x_{min} \\leq x \leq x_{max}\\), and
   \\(y_{min} \\leq y \\leq y_{max}\\). Consider all the cases, including vertical
   lines.

   One of the ways to solve the task is as follows: intersect the line
   with each of the rectangle sides. They are horizontal and vertical,
   so it is quite easy to find intersections. Usually, you are left with
   only two intersections, so you now can call `plot()` for the line between
   the two points.
1. **task_plot_intersections**. You are given a matrix with lines as in the task 3
   from octave-vectorization. Plot all intersections of these lines (do not draw lines),
   use the function `all_lines_intersections()` from octave-vectorization.
1. **task_plot_lines**. You are given a matrix `a` with lines (the same as
   matrices from the block octave-vectorization,
   you are also given `xrange`, `yrange` with ranges to draw the lines by means
   of the `plot_line` function from the previous task. Draw all of the lines
   from `a`. Use a loop to call plotting for each line.
1. **task_plot_lines_and_intersections** You are given the same as in
   the previous task. Draw all lines from the matrix `a` and draw all the intersections.
   Remember, that you have already implemented evaluating of intersections
   in the block octave-vectorization.

## Some fun with random numbers

1. **task_random_walk_2d** Random walk on a plane. You are given an integer `steps`. Generate `steps` times a pair of numbers, this pair may be either (1 0), (-1 0), (0 1), or (0 -1). Put all this pairs in one matrix with two columns, so you get a matrix of size $size \times 2$. This pairs correspond to movements of a point on a plane, a pair is a change for x and y coordinates correspondingly. That is a point moves either up, left, right or down. Finally, sum all x coordinates, then sum all y coordinates, and you will get two coordinates of where a point had come after its random walk.
    
   you could additionaly try to plot this walk.

2. **task_kinder_surprise** There are `n` possible toys inside a kinder surprise. How many kinder surprises should one buy in average to get all the toys? Make 10000 experiments, where you repeat opening kinder surprises until you get all the toys. Then compute an average number of steps you needed to finish.
