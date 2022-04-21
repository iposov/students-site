package ru.spbu.arts.javafx.images;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedWriter;
import java.lang.reflect.InaccessibleObjectException;
import java.net.URL;
import java.nio.file.Path;

public class ImagesExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример работы с изображениями");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        initInteraction();
        primaryStage.show();
    }

    private void initInteraction() {
    }

    private Parent initInterface() {
        // Image - это класс, который хранит изображения
        // При создании изображения можно указать URL к файлу с изображением.
        // URL может указывать в Интернет, может на диск.
        Image googleImage = new Image("https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png");

        //отображаем с помощью компонента ImageView
        //Image хранит данные, а ImageView умеет показывать эти данные
        ImageView viewer1 = new ImageView(googleImage);

        //как получить URL для файла на диске
        //Создаём путь к файлу, относительный путь
        Path catPath = Path.of("images/cat219090.png");
        String catURL = catPath.toUri().toString();
        System.out.println("cat url: " + catURL);
        Image catImage = new Image(catURL);
        ImageView viewer2 = new ImageView(catImage);

        //2. Или еще можно, пояснения см. позже
//        try (InputStream fin = new FileInputStream("images/cat219090.png")) {
//            catImage = new Image(fin);
//        } catch (IOException e) {
//            System.out.println("Не удалось загрузить изображение");
//        }

        //другие параметры загрузки изображений
        Image catImageSmall = new Image(
                catURL,
                100, 100, //хотим при загрузке изменить размер до 100x100
                true, // хотим сохранить пропорции
                true // сглаживание результата включено
                     // сглаживать — красиво, но более ресурсоёмко
                );
        ImageView viewer3 = new ImageView(catImageSmall);

        //для картинки с котом можно сделать еще один просмотр
        ImageView viewer4 = new ImageView(catImage);
        //указываем размеры, в которое надо вписать изображение
        viewer4.setFitWidth(150);
        viewer4.setFitHeight(200);
        viewer4.setPreserveRatio(false); // не сохраняем пропорции

        //Обратите внимание, у ImageView нет своих размеров,
        //мы не можем устанавливать ему ширину и высоту, мы не можем
        //даже установить предпочитаемую высоту и ширину. Высота и
        //ширина зависят от содержимого и настроек fitWidth, fitHeight,
        //preserveRatio
        //см. сами, можно показать часть картинки
        //viewer4.setViewport(new Rectangle2D());

        // Теперь попробуем создать своё собственное изображение
        // у класса Image есть наследник WritableImage.
        // Создадим картинку 200 на 200 пикселей.
        WritableImage myPainting = new WritableImage(200, 200);
        //напрямую нельзя изменять пиксели, узнавать цвета пикселей, нужны отдельные объекты
        //для изменения пикселей нужнен PixelWriter
        PixelWriter pixelWriter = myPainting.getPixelWriter();
        //при установке пикселя указываем координаты, x слева направо, y сверху вниз.
        //0, 0 — левый верхний угол.
        //Цвет пикселя — это 4 байта, A - R - G - B, каждый байт от 0 до 255 или в 16-ой
        //от 0 до FF.
        // int a = 42; эквивалентно
        // int a = 0x2A;
        // в 16-ой системе счисления байт — две цифры
        for (int x = 0; x < 200; x++)
            for (int y = 0; y < 10; y++) {
//                pixelWriter.setArgb(x, y, 0xFF00FF00);

                //Класс Color хранит информацию о цвете
//                pixelWriter.setColor(x, y, Color.ROYALBLUE);
                //можно создавать цвет, укаызвая % красного, зеленого, синего
                //лучше было сделать переменную Color myColor = Color.color(0.5, 0.4, 0)
                //до цикла
//                pixelWriter.setColor(x, y, Color.color(0.5, 0.4, 0));
                //значения от 0 до 255
//                pixelWriter.setColor(x, y, Color.rgb(0, 255, 0));
                //серый наполовину между черным и белым
//                pixelWriter.setColor(x, y, Color.gray(0.5));
                //оттенок (от 0 до 359), насыщенность, яркость (от 0 до 1)
                pixelWriter.setColor(x, y, Color.hsb(200, 1, 1));
            }

        ImageView viewer5 = new ImageView(myPainting);

        //Сможем ли мы записать картинку в файл?
        //... потом

        return new FlowPane( // панелька выставляет друг за другом, слева направо, сверху вниз
                viewer1,
                viewer2,
                viewer3,
                viewer4,
                viewer5
        );

        //Перерыв до 14.05
    }
}
