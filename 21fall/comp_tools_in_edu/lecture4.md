# Testing
## Another example of a task

A task example: given a matrix, invert a sign of its first column.

The function should be called `invert_1st_column`.

Given
```
10   20  30
40   50  60
-70 -80 -90
10   20  30
```

return
```
-10  20  30
-40  50  60
 70 -80 -90
-10  20  30
```

Let's try to implement this:

```
function b = invert_1st_column(a)
    b = a;
    b(:, 1) = -b(:, 1);
endfunction
```

Then let's create a `test_everything.m` script:

```
printf("test task 2\n\n")

task_2_lines(4)
task_2_lines(7)
task_2_lines(10)
task_2_lines(1)
task_2_lines(-4)

printf("test the task about inverting the first column:\n\n")

a = [10 20 30;
        40 50 60
       -70 -80 -90
        10 20 30];
invert_1st_column(a)
invert_1st_column([10 20; 30 40])
```

## Assertion and built-in tests

Let's use the `assert` function. It get's two arguments and compares them. It they are different, the error is raised. If they are similar, nothing is printed at all.

Usually you use it like this:
```
assert(your_function(args), correct_output)
```

And here is an example of the `test_everything` file:

```
printf("test task 2\n\n")

%task_2_lines(4)
%task_2_lines(7)
assert(task_2_lines(10), [10 10 10 10 10 10 10 10 10 10 ; -10 -10 -10 -10 -10 -10 -10 -10 -10 -10])
%task_2_lines(1)
%task_2_lines(-4)

printf("test the task about inverting the first column:\n\n")

a = [10 20 30;
        40 50 60
       -70 -80 -90
        10 20 30];
a_inverted = [-10 20 30;
        -40 50 60
       70 -80 -90
        -10 20 30];
assert(invert_1st_column(a) , a_inverted)
assert(invert_1st_column([10 20; 30 40]) , [-10 20; -30 40])

```

Not mandatory by now, but please look at the link [Octave tests](https://wiki.octave.org/Tests) and see how you can include tests just inside the function code.

