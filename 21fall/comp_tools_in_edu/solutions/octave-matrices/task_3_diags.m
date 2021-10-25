function m = task_3_diags(n, a, b)
  % use the diag function. diag([1 2 3 4 5], 1) creates a matrix with 12345 on the 1st diagonal near the main one
  row_of_n_1_b = b * ones(1, n - 1); % [b, b, b, b, b, ...] n-1 times
  row_of_n_a = a * ones(1, n);       % [a, a, a, a, a, ...] n times
  m = diag(row_of_n_1_b, 1) + diag(row_of_n_1_b, -1) + diag(row_of_n_a);
endfunction
