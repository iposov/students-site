---
type: tasks
---

# R basics.

Please, create functions for each of the tasks. Functions shouls be named as task names, usually, as `task1`, `task2`, etc.
Here are some function examples:

```R
fun1 <- function(x, y) { # here are arguments in the brackets
  x + y # the result of the function is its last expression
}

# let's now call the function
fun1(10, 20) # this is 30

# another example
fun2 <- function(n) {
   c(1:n, n:1)
}

# let's test the function
fun2(5) # this is a vector 1, 2, 3, 4, 5, 5, 4, 3, 2, 1

fun3 <- function() {
    x <- rbinom(20, size=1, prob=0.5)  # toss a coin 20 times
    mean(x) # this is the result of a function, because this is the last expression
}

fun3() # the result is always different, but it should be about 0.5
```

1. **task1** Read help about the `rep` function (type `help(rep)`). Then use it to produce a vector of repeating numbers 1, 2, and 3: \\(1, 2, 3, 1, 2, 3, 1, 2, 3, \\ldots\\). The length of the vector should be 40.
    * **task1a**  You are given integers `n` and `size`, create a vector of repeating numbers from `1` to `n` of size `size`, for example, `task1a(3, 10)` should return `c(1, 2, 3, 1, 2, 3, 1, 2, 3, 1)`.
1. **task2** You are given integers `n` and `size`. Using the function `sample` (read help if needed) generate a vector of size `size` consisting of random integers from `1` to `n`, and return it. For example, `task2(3, 5)` may return `1, 3, 2, 3, 3`.
    * **task2a** call task2a with the arguments n=5 and size=100, then use functions `table` to find out, how many times each number was generated, use print to print the table from inside the function.
1. **filter.k** You are given a vector `x` and a number `k`. Return a new vector, that is a copy of `x` but without elements equal to `k`. For example, `filter.k(c(1, 2, 3, 4, 3, 2, 1), 3)` should return `1, 2, 4, 2, 1`.
1. **random.walk.1d** You are given an integer `steps`, generate a random vector of size `steps` consisting of numbers 1 and -1. Return the sum of its elements.
1. **mixed.distribution**. You are given an integer `size`. Generate a vector of size `size` using the following algorithm: to generate the next number, toss a coin (50%/50% of head and tails). If you get heads, generate a number from distribution\\(N(0, 1)\\). Otherwise, from a uniform distribution with `min=-1` and `max=1`.

translating...

1. А теперь случайное блуждание на плоскости. Дано целое число steps. Сгенерируйте матрицу размера 2 на steps.
   Каждый столбик может быть одним из четырех вариантов: (1 0), (-1 0), (0 1), (0 -1). Теперь получите сумму чисел в первой
   строке, и сумму чисел во второй строке. Это координаты того, куда приблуждало блуждание. Верните вектор из двух этих чисел
1. Дано целое число n, запустите предыдущую задачу n раз, получите n точек и изобразите их на графике.
