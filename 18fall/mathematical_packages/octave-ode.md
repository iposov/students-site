1. **task1** Solve an inhomogeneous linear ordinary differential equation with constant coefficients: \\(y' + 2y = x + \\frac12, y(0) = 1\\). Get a solution for `x = linspace(0, 1, 100)`. Do it in two ways:
    * `y1` is a solution with the `lsode` function.
    * `y2` is an explicit solution. You may either remember, how to solve such equations, or ask [WolframAlpha](wolframalpha.com) for the solution.
    
    After all, plot the two solutions and make sure that they are the same.

1. **task2** Solve the ODE \\(y''(x) + y(x) * (cos(x) + 1) = 0, y(0)=-1, y'(0)=1\\) on the segment \\(0\leq x \\leq 10\\), plot the solution.

    * Create a function `task2a` that solves the same equation, but has the three parameters: `x` coordinates, value for `y(0)`, and a value for `y(1)`. This should work as follows:
    
               x = linspace(0, 10, 1000);
               y1 = linspace(x, -1, 1)
               y2 = linspace(x, -1
               
   

1. [Система Хищник-Жертва](http://goo.gl/sIsk5u).
Изучите статью по ссылке, в ней описывается система дифференциальных уравнений, моделирующая изменения популяций лис и кроликов, когда они живут вместе и едят друг друга. Создайте функцию, которая на вход получается параметры системы (альфа, бета, гамма, дельта), и рисует графики нескольких решений уравнений, соответствующих начальным данным, вокруг точки равновесия \\((\\overline{x}, \\overline{y})\\). Для этого возьмите начальные данные вида \\(x(0) = \\overline{x}, y(0) = \\overline{y} + ks\\). Здесь \\(k\\) — это целое число от 0 до 5, \\(s\\) - это величина, которая указывается еще одним (пятым) аргументом функции, получается, что на одном графике необходимо нарисовать шесть кривых для каждого значения \\(k\\). Функция должна только рисовать график в координатах x и y (не используйте координату t при рисовании), и ничего не должна возвращать. Убедитесь, что вы понимаете кривые, изображенные на графике.
