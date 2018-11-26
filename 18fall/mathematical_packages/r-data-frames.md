1. Create a script  (not a function) `task1.R` with the following computations:
    1. Save dataframe `Cars93` from the library `MASS` to the variable `cars`.
    1. Add the column `kpl` (kilometers per liter) to the dataframe, use a column `MPG.city` (miles per gallon)
    1. Select all cars with `Horsepower` greater than 200.
    1. Plot Horsepower vs kpl. Make informative labels for axes.
        * add a linear regression line, if you manage to find out, how to do this with the `lm` function.
    1. Make a copy of the `cars` dataframe, that has only columns `Horsepower`, `kpl`, and `wt` (weight in tonns, use the original `Weight` column that has weights in pounds). Pass this copy as the only argument for the `plot` function. What do you see on this plot?
1. Create a script (not a function) `task2.R`.
    1. Create a new dataframe about balls, you will use random values for it. It should have two columns`size` and `color`. The first one is a factor with levels "big" and "small", the second one is a factor with three levels "red", "green", "blue". Use `sample` to create a create a vector of 1000 random values.
    1. Apply the following functions to this dataframe: `table`, `summary`, `plot`. How many big green balls are there?
    1. Add the column `weight` this should be normally distributed random numbers with different means for different balls sizes.
    1. Call the functions `table`, `summary`, `plot` again. What do they show?
1. Not finished. Process [Google Play Apps dataset](https://www.kaggle.com/lava18/google-play-store-apps)
