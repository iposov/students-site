function a = task_chess_ver2
  b = (1:10) + (1:10)';  % this is a matrix with odd and even numbers in a chess order
  a = mod((1:10) + (1:10)', 2);
endfunction
