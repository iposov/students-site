package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveOpenDialogsExample extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое

        stage.setTitle("Hello window");
        //сделать видимым
        stage.show();

        //Диалог сохранения файла
        //создавайте один такой диалог в программе, лучше хранить его
        //полем класса.
        FileChooser fc = new FileChooser();
        //вызываем функцию — показать диалог открытия файла
        //аргумент может быть окном, тогда диалог появится в середине
        //окна. Можно передать null, диалог появится в середине экрана
        File fileToOpen = fc.showOpenDialog(stage);
        if (fileToOpen == null)
            System.out.println("Вы ничего не выбрали");
        else
            System.out.println("Вы выбрали файл " + fileToOpen);

        //Как сохранять картинку в файл.
        WritableImage image = new WritableImage(100, 100);

        // в module info необходимо дописать использование модуля
        // javax.swing: requires javax.swing;
        BufferedImage swingImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(swingImage, "png" /*"jpeg"*/, fileToOpen);
        } catch (IOException e) {
            System.out.println("Не удалось записать");
        }
    }

}
