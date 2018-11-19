1. **task1** Solve an inhomogeneous linear ordinary differential equation with constant coefficients: \\(y' + 2y = x + \\frac12, y(0) = 1\\). Get a solution for `x = linspace(0, 1, 100)`. Do it in two ways:
    * `y1` is a solution with the `lsode` function.
    * `y2` is an explicit solution. You may either remember, how to solve such equations, or ask [WolframAlpha](wolframalpha.com) for the solution.
    
    After all, plot the two solutions and make sure that they are the same. So, you should implement a function that does not have arguments, does not return anything, and just plots a function.

1. **task2** Solve the ODE \\(y''(x) + y(x) * (cos(x) + 1) = 0, y(0)=-1, y'(0)=1\\) on the segment \\(0\leq x \\leq 10\\), plot the solution.

    * Create a function `task2a` that solves the same equation, but allows to change initial values. It should have the three parameters: `x` coordinates, value for `y(0)`, and a value for `y'(0)`. Create the function `task2b` to test the function `task2a`, it should have the following code inside:
    
               x = linspace(0, 10, 1000);
               plot(x, task2a(x, -1, 1));
               hold on
               plot(x, task2a(x, 0, 1));
               plot(x, task2a(x, 1, 1));
               plot(x, task2a(x, -1, 0));
               plot(x, task2a(x, 0, 0));
               plot(x, task2a(x, 1, 0));
               plot(x, task2a(x, -1, -1));
               plot(x, task2a(x, 0, -1));
               plot(x, task2a(x, 1, -1));
               
1. [The Predator-Prey Model](https://en.wikipedia.org/wiki/Lotka%E2%80%93Volterra_equations).
The link leads to an article about a predator-prey model, that models population changes of, for example, foxes and rabbits when they live together and eat each other. The equation is given in the first paragraph.

   Implement a function that gets \\(\\alpha\\), \\(\\beta\\), \\(\\gamma\\) ,\\(\\delta\\) as parameters, evaluates a non-zero equlibrium point \\((\\overline{x}, \\overline{y})\\) (find it in the article), and then plots six plots with initial values \\(x(0) = \\overline{x}, y(0) = \\overline{y} + ks\\), where \\(k\\) is an integer from 0 to 5, and \\(s\\) is a value given as the fifth argument of a function. So, you should have a plot with 6 lines on it. Do not return any result. Make sure that you understand what do these plots mean.
