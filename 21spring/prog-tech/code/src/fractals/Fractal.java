package fractals;

public interface Fractal {

    /**
     * Для каждой точки плоскости выдает число
     * от 0 до 1, которое потом можно раскрасить и
     * нарисовать.
     * @param x координата по x для точки
     * @param y координата по y для точки
     * @return число от 0 до 1, которое потом нужно
     * раскрашивать с помощью палитры.
     */
    double evaluate(double x, double y);

}