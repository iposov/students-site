function m = task_3_diags_ver2(n, a, b)
  x = (1:n) - (1:n)';  % this is a matrix with 0 on the main diagonal and with +-1 near the main diagonal
  
  m = zeros(n);
  m(x == 0) = a;
  m(abs(x) == 1) = b;
endfunction
