function a = task_double_chess
  m = mod(0:19, 4) >= 2; % 0 0 1 1 0 0 1 1 0 0 1 1 ...
  a = m ~= m';
  % или 
  % a = xor(m, m');  
  % или 
  % a = m + m' - 2 * m .* m';
endfunction
