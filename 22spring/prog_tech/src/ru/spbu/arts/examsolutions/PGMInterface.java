package ru.spbu.arts.examsolutions;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PGMInterface extends Application {

    private final Button chooseButton = new Button("Выбрать изображение");
    private final ImageView imageView = new ImageView();
    private final Label fileLabel = new Label();
    private final FileChooser fileChooser = new FileChooser();

    @Override
    public void start(Stage stage) {
        stage.setTitle("Сохраняем ПМГ");
        VBox root = initInterface();
        stage.setScene(new Scene(root));
        initInteraction();
        stage.show();
    }

    private VBox initInterface() {
        return new VBox(chooseButton, fileLabel, imageView);
    }

    private void initInteraction() {
        chooseButton.addEventHandler(ActionEvent.ACTION, event -> {
            File fileToLoad = fileChooser.showOpenDialog(null);
            if (fileToLoad == null)
                return;

            fileLabel.setText(fileToLoad.getPath());

            // Выбираем по расширению, решать вторую часть задачи или третью:
            // превратить изображение в PGM или PGM в изображение
            try {
                if (fileToLoad.getName().toLowerCase().endsWith(".pgm"))
                    fromPGMtoPNG(fileToLoad);
                else
                    fromImageToPGM(fileToLoad);
            } catch (Exception e) {
                System.out.println("Произошла ошибка при работе с изображением " + fileToLoad);
            }
        });
    }

    private void fromImageToPGM(File fileToLoad) throws Exception {
        Image image = new Image(fileToLoad.toURI().toURL().toString());
        imageView.setImage(image);

        int width = (int)image.getWidth();
        int height = (int)image.getHeight();

        PGMImage pgm = new PGMImage(width, height);
        PixelReader reader = image.getPixelReader();
        for (int line = 0; line < height; line++)
            for (int column = 0; column < width; column++) {
                Color color = reader.getColor(column, line);
                int brightness = (int) Math.round(color.getBrightness() * 255);
                pgm.setPixel(line, column, brightness);
            }

        pgm.saveTo(fileToLoad.getAbsolutePath() + ".pgm");
    }

    private void fromPGMtoPNG(File fileToLoad) throws IOException {
        try (Scanner reader = new Scanner(fileToLoad)) {
            reader.next(); //read "P2"
            int width = reader.nextInt();
            int height = reader.nextInt();
            reader.nextInt(); // read "255"

            WritableImage image = new WritableImage(width, height);
            PixelWriter writer = image.getPixelWriter();

            for (int line = 0; line < height; line++)
                for (int column = 0; column < width; column++) {
                    int brightness = reader.nextInt();
                    writer.setColor(column, line, Color.grayRgb(brightness));
                }

            imageView.setImage(image);

            File fileToSave = new File(fileToLoad.getAbsoluteFile() + ".png");
            ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", fileToSave);
        }
    }
}


