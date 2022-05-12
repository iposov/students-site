package ru.spbu.arts.fractals;

import javafx.scene.paint.Color;

public interface Fractal {

    //для каждой точки выдаётся цвет
    Color paint(double x, double y);

}
