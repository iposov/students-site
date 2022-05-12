package ru.spbu.arts.fractals;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FractalViewerFirstVersion extends Application {

    //final - неизменяемое значение, public static final поля принято
    //называть заглавными буквами с подчеркиваниями между слов
    //см. Math.PI, Integer.MAX_VALUE - наибольше значение в типе int
    public final static int W = 600;
    public final static int H = 500;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Просмотр фигур");

        Pane root = initInterface();
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }

    private Pane initInterface() {
        WritableImage img = new WritableImage(W, H);
        PixelWriter pixelWriter = img.getPixelWriter();

        double x0 = -4;
        double y0 = 5;
        double d = 8 / 600.0; // вещественное деление

        for (int xPixel = 0; xPixel < W; xPixel++)
            for (int yPixel = 0; yPixel < H; yPixel++) {
                double x = x0 + d * xPixel;
                double y = y0 - d * xPixel;

                //если точка в круге, она черная. Иначе белая
                if (x * x + y * y <= 1)
                    pixelWriter.setColor(xPixel, yPixel, Color.BLACK);
                else
                    pixelWriter.setColor(xPixel, yPixel, Color.YELLOW);
            }

        ImageView imageView = new ImageView(img);
        return new Pane(imageView);
    }
}
