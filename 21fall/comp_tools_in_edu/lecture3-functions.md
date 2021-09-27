# Some thoughts about solutions I got

'+'
'++'

imaging a task: create 10x10 matrix of 1s.

solution for ++ looks like this: `ones(10, 10)`
solution for +:
```
a = [1 1 1 1 1 1 1 1 1 1]
b = [a; a; a; a; a; a; a; a; a; a]
```
There are some tricks. See broadcasting from prev lecture. 

`[1 2 3] + [0 0 0]'`

```
           0
[1 2 3] +  0
           0
```

broadcasting

```
[1 2 3]    0 0 0
[1 2 3] +  0 0 0
[1 2 3]    0 0 0
```

the result is:

```
[1 2 3]
[1 2 3]
[1 2 3]
```

* linespace(1, 1, 10)  # from 1 to 1, make 10 numbers:
the result is `[1 1 1 1 1 1 1 1 1 1]`,
the same results is from `ones(1, 10)`
linespace(2, 2, 10)  # from 1 to 1, make 10 numbers:
`[2, 2, 2, 2, 2, 2, 2, 2, 2, 2]`
2 * ones(1, 10)

*
`[1:10]` ok, this is `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]`
but
1:10 is the same `[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]`
you don't need square brackets:
`[1:10 ; 1:10]`

* hints for a chess.
Almost everybody do:
```
a = [1 0; 0 1]
chess = [a a a a a; a a a a a; a a a a a; ...]
```

ideas:

1st:
```
mod(1:10, 2) = mod([1 2 3 4 5 6 7 8 9 10], 2) =
[1, 0, 1, 0, 1, 0, 1, 0, 1, 0]
```
2nd:

```
a = [1 2 3 4; 1 2 3 4; 1 2 3 4; 1 2 3 4]

            1 +2  3  +4
            1  2  3  4
            1 +2  3  +4
            1 +2  3  +4
a([1,3,4], [2, 4]) = 0

            1 0 3 0
            1 2 3 4
            1 0 3 0
            1 0 3 0
            
1:10 = [1 2 3 4 5 6 7 8 9 10]
1:2:10 = [1 3 5 7 9]
2:2:10 = [2 4 6 8 10]
```

a(2:4:10, 2:2:10)

# Writing functions in Octave

Functions have:
input values (0 or many)
output values (0 or many)
side effects

Let's write only two types of functions:
 - pure functions: no side effect
 - commands: no output (only side effect)

Examples:
 - task_chess could be a pure function. It takes matrix size and returns a matrix
 - print function is a command, it does not evaluate anything, it is called only for the side effect of printing.

Consider an example of task: create a square matrix of ones.

to create a function, create a file
 - call it the same as want to call your function, for example, `task_ones.m`. Use '.m' extension.
 - write the following. In general

```
function [output values] = funcion_name(input values)
    % indent 4 lines inside, write the actual code
endfunction 
```

for example

```
function [matrix] = task_ones(n)
    matrix = ones(n, n);
endfunction
```

To use this function, just call by name:

```
% a gets the output value
a = task_ones(10);
```


To call this function, just call it by name:

Another example, two outputs:

```
function [m1, m2] = fun_example_1(a, b)
  m1 = a + b;
  m2 = a - b;
endfunction
```

to call it:

```
[aa, bb] = fun_example_1(10, 20)
% aa gets 30, bb gets -10

aa = fun_example_1(10, 20)
% aa is 30, and -10 is discarded
```

Variable names have meaning only inside the function they are used. Outside of `fun_example_1` names `m1`, `m2`, `a`, `b` mean nothing.

Notes on syntax:
 * you can skip [] if there is only one output:
`function m1 = fun(...)`
 * you can skip output at all
`function fun(...)`
 * you can also skip arguments, and even
 don't write ()
 `function m1 = fun` or
 `function fun`

About a semicolon `;`

It supress output from the statement. If you don't put `;` at the end of some statement, you see an output of it. If you omit it inside a function, the function gets a side effect of printing.

**I ask to write all tasks as pure functions (no side effect, just get data and return evaluation)**

This is not obligatory for the first block of tasks, but this is obligatory for the next tasks.

If you write a pure_function, it is easy to test it.

Imagine a task example: given a number `a`, create a matrix 2x10, with the fist
line consisting of `a` and the second line
consisting of `-a`.

`task_2_lines(4)` should be
```
 4  4  4  4  4  4  4  4  4  4
-4 -4 -4 -4 -4 -4 -4 -4 -4 -4
```

Solution:

```
function matrix = task_2_lines(a)
  first_row = a * ones(1, 10);
  second_row = -first_row;
  matrix = [first_row ; second_row];
  
  % matrix = [a; -a] + zeros(2, 10)
endfunction
```

To test it there are two good ways:

1. Write a file called `test_task_2_lines.m`:
```
task_2_lines(4)
task_2_lines(5)
task_2_lines(-4)
task_2_lines(0)
```

2. built-in testing features of octave
