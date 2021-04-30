package fractals;

import javafx.scene.paint.Color;

public class SimplePalette implements Palette {
    @Override
    public Color colorize(double v) {
        if (v == 0.5)
            return Color.RED;
        else
            return Color.BLUE;
    }
}
