package javafxexamples;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ImagesExample extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Примеры работы с изображениями");
        Parent root = initInterface();
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private Parent initInterface() throws MalformedURLException {
        //Разделение данных и представления
        //Класс Image — данные. В объектах Image хранятся изображения, т.е. по
        //объекту можно понять, какого размера изображение, какие пиксели,
        //каких цветов там есть.
        //Класс ImageView — это элемент интерфейса, он умеет показывать изображения.
        //Кстати, можно сделать два ImageView, которые показывают одно и то же
        //изображение. Разные ImageView могут показывать разные части изображения.

        //URL изображения. URL - ... resource location. URL устроен так:
        // ПРОТОКОЛ://РАСПОЛОЖЕНИЕ
        // HTTP://www.
        // HTTPS://www.
        // FILE://C:/Windows/notepad.exe
        // TG://
        // ...
//        String catUrl = "file:///home/ilya/programming/students-site/21spring/prog-tech/code/images/Zunge_raus.JPG";
//        Image cat1 = new Image(catUrl);
        Path catPath = Paths.get("images", "Zunge_raus.JPG"); //Paths.get("images/Zunge_raus.JPG")
        String catUrl = catPath.toUri().toURL().toString();
        Image cat1 = new Image(catUrl);

        ImageView catView1 = new ImageView(cat1);
        System.out.println(cat1.isError());
        System.out.println(catUrl);

        ImageView catView2 = new ImageView(cat1);
        catView2.setFitHeight(200); //пусть впишется в 200 пикселей в высоту
        catView2.setFitWidth(300); //300 ширину
        catView2.setPreserveRatio(true); //не искажать

        //после загрузки сожми картинку до размера 300 на 200, сохрани соотношение сторон
        //smooth - более хороший, но более медленный алгоритм уменьшения размера
        Image cat2 = new Image(catUrl, 300, 400, true, true);

        ImageView catView3 = new ImageView(cat2);
        catView3.setX(200); //указываем положение, 200 пикселей направо

        // cat1 занимает в памяти много места, это огромная картинка
        // cat2 — мало, она сжата до размеров 300 на 400

        /* Image позволяет загрузить уже существующую картинку. Но часто хочется
        рисовать картинку программно. Для этого есть наследник Image: WritableImage.
        Можно создать картинку указанного размера, в пикселях
        - WritableImage хранит информацию в памяти, в виде массива пикселей.
        - Image хранит информацию очень по-разному, он постепенно читает пиксели
          из изображения.
         */
        WritableImage writableCat = new WritableImage(200, 200);

        ImageView catView4 = new ImageView(writableCat);
        catView4.setX(600);

        /*
        Как же рисовать на изображении? Нужен отдельный объект, рисователь.
        */
        final PixelWriter catWriter = writableCat.getPixelWriter();
        // то, что мы будем рисовать на catWriter, будет появляться на изображении
        // writableCat
        //устанавливаем цвет отдельного пикселя. Координаты с левого верхнего угла.
        //argb это 4 байтовое значение, первый байт это a (непрозрачность 255 =
        //не прозрачно) r (красный от 0 до 255) и т.д.
        catWriter.setArgb(0, 0, 0xFF112233);
        //---------------------------------aarrggbb
        //             0xFF * 256 * 256 * 256 + 0x11 * 256 * 256 + 0x22 * 256 + 33
        // a = 0xFF = 255, r = 0x11 = 17, g = 0x22 = 2*16 + 2 = 34, b = 0x33 = 3*16+3 = 51
        for (int y = 0; y < 200; y++)
            catWriter.setArgb(1, y, 0xFFFF0000);

        //еще один способ установить пиксели
        catWriter.setColor(10, 10, Color.ANTIQUEWHITE);
        catWriter.setColor(10, 10, Color.color(0.5, 1, 0));
        catWriter.setColor(10, 10, Color.rgb(255, 0, 0));
        catWriter.setColor(10, 10, Color.gray(0.6)); //серый 60%

        Pane panelForImages = new Pane();
        panelForImages.getChildren().addAll(catView2, catView3, catView4);
        return panelForImages;
    }
}
