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
