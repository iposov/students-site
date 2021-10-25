function a = task_2_5x5_ver2
  % create a matrix of the size we need, and then reassign all values
  a = zeros(5);
  a(:, :) = 2;  % or a(:) = 2
  
  % and now for something very tricky.
  % we index a matrix '2' with a square matrix of ones
  % a = 2(ones(5));
endfunction
