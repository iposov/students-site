package ru.spbu.arts.fractals;

import javafx.scene.paint.Color;

public class CircleFractal implements Fractal {
    @Override
    public Color paint(double x, double y) {
        if (x * x + y * y <= 1)
            return Color.BLACK;
        else
            return Color.YELLOW;
    }
}
