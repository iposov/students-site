---
type: tasks
---

## Indexing

1. ***task1***
You are given a square matrix of an even size. (you are not supposed to test that the matrix is actually even and square, just
use it). Imagine we split a matrix vertically and horizontally through the center. Return the matrix at the left-top.
1. ***task2***
You are given a matrix with an even number of rows. Return a new matrix where the top half is exchanged with the bottom half of the
initial matrix.
1. ***task3***
You are given a vector with integer numbers. Return a vector that contains only that numbers of the initial vector, that are
divisible by 3. Use the `mod` function to test divisibilty.
1. Create two functions ***filter_multiples*** and ***seive***. The first one is `filter_multiples(a, k)`, it removes all numbers from the vector `a` that are divisible
by `k` and are strictly greater than `k`. For example, `filter_multiples([1 5 10], 5)` yields `[1 5]`

    The second one is `sieve()` and it is as follows:
  
    ```
        function a = sieve(n)
          a = 1:n;
          i = 2;
          while i < length(a)
            a = filter_multiples(a, a(i));
            i++;
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