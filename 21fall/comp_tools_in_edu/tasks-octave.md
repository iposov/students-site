---
type: tasks
---

# Octave tasks

## Create matrices

Solve tasks from this block in a folder named `octave-matrices`.

Please, use only methods that were discussed at the lecture or in lecture notes available on this site. That is, for example, don't  use loops and functions such as `repmat`. And try to find a short solution, especially, don't  enter all the values manually.

1. **task_10x10**

   The \\(10\\times10\\) matrix:

   \\(  \\begin{pmatrix}
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 \\\\ 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 \\\\
   0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0
   \\end{pmatrix} \\)

2. **task_border**

Create a border-matrix \\(10\\times10\\), it should have 0s everywhere except 1s at the border:

   \\(  \\begin{pmatrix}
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 \\\\ 1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 0 & 1 \\\\
   1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1 & 1
   \\end{pmatrix} \\)

4. **task_2_5x5**

   The \\(5\\times5\\) matrix:

   \\(  \\begin{pmatrix}
   2 & 2 & 2 & 2 & 2 \\\\ 2 & 2 & 2 & 2 & 2 \\\\
   2 & 2 & 2 & 2 & 2 \\\\
   2 & 2 & 2 & 2 & 2 \\\\
   2 & 2 & 2 & 2 & 2
   \\end{pmatrix} \\)

5. **task_0123**

   The \\(10\\times10\\) matrix:

   \\(  \\begin{pmatrix}
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\ 0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\
   0 & 0 & 0 & 0 & 0 & 1 & 1 & 1 & 1 & 1 \\\\
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\ 2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3 \\\\
   2 & 2 & 2 & 2 & 2 & 3 & 3 & 3 & 3 & 3
   \\end{pmatrix} \\)

6. **task_chess**

   The \\(10\\times10\\) matrix with the chess-board order of 0's and 1's:

   \\(  \\begin{pmatrix}
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\
   0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 \\\\ 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 & 1 & 0 \\\\
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
