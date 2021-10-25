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
