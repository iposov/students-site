# ALl solutions to octave matrices

All functions should be defined in the file that is named the same as the function name.

```
function a = task_10x10
  a = [ones(1, 10) ; zeros(9, 10)];
endfunction
```

```
function a = task_10x10_ver2
  a = zeros(10);
  a(1, :) = 1;
endfunction
```

```
function a = task_border
  a = ones(10);
  a(2:9, 2:9) = 0;
endfunction
```

```
function a = task_2_5x5
  a = 2 * ones(5);
  % the same:
  % a = 2 + zeros(5);
  % a = 1 + ones(5);
endfunction
```

```
function a = task_2_5x5_ver2
  % create a matrix of the size we need, and then reassign all values
  a = zeros(5);
  a(:, :) = 2;  % or a(:) = 2
  
  % and now for something very tricky.
  % we index a matrix '2' with a square matrix of ones
  % a = 2(ones(5));
endfunction
```

```
function a = task_0123_ver2
  % create a matrix of the size we need, and then 
  a = zeros(10);
  a(1:5, 6:10) = 1;
  a(6:10, 1:5) = 2;
  a(6:10, 6:10) = 3;
  
  % or
  % a = zeros(10);
  % a(6:10, :) = 2;
  % a(:, 6:10) += 1;    or    a(:, 6:10) = a(:, 6:10) + 1
endfunction
```

```
function a = task_0123
  b = zeros(5);
  
  a = [b, b + 1 ; b + 2, b + 3];
endfunction
```

```
function a = task_chess
  a = zeros(10);
  a(2:2:10, 1:2:10) = 1;
  a(1:2:10, 2:2:10) = 1;
endfunction
```

```
function a = task_chess_ver2
  b = (1:10) + (1:10)';  % this is a matrix with odd and even numbers in a chess order
  a = mod((1:10) + (1:10)', 2);
endfunction
```

```
function a = task_1_to_9_lines
  a = zeros(9) + (1:9)';
endfunction
```

```
function a = task_1_to_100
  x = 1 : 10;
  y = (0:10:90)';
  a = x + y;
endfunction
```

```
function a = task_multiplication_table
  a = (1:9) .* (1:9)';  % element-by-element multiplication
  % or
  % a = (1:9)' * (1:9);  % matrix multiplication
endfunction
```

```
function m = task_3_diags(n, a, b)
  % use the diag function. diag([1 2 3 4 5], 1) creates a matrix with 12345 on the 1st diagonal near the main one
  row_of_n_1_b = b * ones(1, n - 1); % [b, b, b, b, b, ...] n-1 times
  row_of_n_a = a * ones(1, n);       % [a, a, a, a, a, ...] n times
  m = diag(row_of_n_1_b, 1) + diag(row_of_n_1_b, -1) + diag(row_of_n_a);
endfunction
```

```
function m = task_3_diags_ver2(n, a, b)
  x = (1:n) - (1:n)';  % this is a matrix with 0 on the main diagonal and with +-1 near the main diagonal
  
  m = zeros(n);
  m(x == 0) = a;
  m(abs(x) == 1) = b;
endfunction
```

```
function a = task_double_chess
  m = mod(0:19, 4) >= 2; % 0 0 1 1 0 0 1 1 0 0 1 1 ...
  a = m ~= m';
  % или 
  % a = xor(m, m');  
  % или 
  % a = m + m' - 2 * m .* m';
endfunction
```

```
function a = task_double_chess_ver2
  n = 20;
  ind12 = [1:4:n , 2:4:n];  % indexes 1,2, 5,6
  % or ind12 = find(mod(0:n-1, 4) <= 2);
  % or ind12 = mod(0:n-1, 4) <= 2;
  ind34 = [3:4:n , 4:4:n];  % или ind34 = 2 + ind12
  
  a = zeros(n, n);
  a(ind12, ind34) = 1;
  a(ind34, ind12) = 1;
endfunction
```

```
function m = task_chukh(n)
  % we need some logical expression to select 1 or 2 depending on
  % line index (i) and column index (j)
  
  i = zeros(n) + (1:n)'; % n by n matrix, each cell has line index
  j = zeros(n) + (1:n);  % ... column index
  
  m = min(i, j);  % select minimum of line and column
  % m looks like
  % 1 1 1 1 1
  % 1 2 2 2 2
  % 1 2 3 3 3
  % 1 2 3 4 4
  % 1 2 3 4 5
  
  m = mod(m, 2);
  % now m looks like
  % 1 1 1 1 1
  % 1 0 0 0 0
  % 1 0 1 1 1
  % 1 0 1 0 0
  % 1 0 1 0 1
  
  m = 2 - m;  % convert 0 to 2, 1 to 1
endfunction
```

## Now we test all the functions

This code you may put in a file named any way you like, such as `test_all_tasks.m`:

```
disp("===============================")
disp("10 x 10")
disp("===============================")
task_10x10
task_10x10_ver2

disp("===============================")
disp("border")
disp("===============================")
task_border

disp("===============================")
disp("2 5x5")
disp("===============================")
task_2_5x5
task_2_5x5_ver2

disp("===============================")
disp("0123")
disp("===============================")
task_0123
task_0123_ver2

disp("===============================")
disp("chess")
disp("===============================")
task_chess
task_chess_ver2

disp("===============================")
disp("1 to 9 lines")
disp("===============================")
task_1_to_9_lines

disp("===============================")
disp("1 to 100")
disp("===============================")
task_1_to_100

disp("===============================")
disp("3 diags")
disp("===============================")
task_3_diags(10, 4, 2)
task_3_diags_ver2(10, 5, 1)

disp("===============================")
disp("double chess")
disp("===============================")
task_double_chess
task_double_chess_ver2

disp("===============================")
disp("chukh")
disp("===============================")
task_chukh(5)
```
