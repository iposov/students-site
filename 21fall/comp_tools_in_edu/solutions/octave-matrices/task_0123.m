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
