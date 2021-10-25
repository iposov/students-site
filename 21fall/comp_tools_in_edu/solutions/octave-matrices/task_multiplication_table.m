function a = task_multiplication_table
  a = (1:9) .* (1:9)';  % element-by-element multiplication
  % or
  % a = (1:9)' * (1:9);  % matrix multiplication
endfunction
