package fractals;

import javafx.scene.paint.Color;

public interface Palette {

    /**
     * Определяет цвет для числа в диапазоне от 0 до 1
     * @param v число от 0 до 1
     * @return цвет числа
     */
    Color colorize(double v);

    // более эффективно сделать не Color, а int

}
