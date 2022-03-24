package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExampleHBoxConstraints extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое
        stage.setTitle("Пример программы с HBox");

        //Parent — узел, который можно использовать как корень для сцены
        Parent parent = initInterface();
        stage.setScene(new Scene(parent));

        //сделать видимым
        stage.show();
    }

    private VBox initInterface() {
        Button b1 = new Button("Нажми меня");
        Button b2 = new Button("И меня");
        Button b3 = new Button("Нет, меня");
        Button b4 = new Button("Но не меня");
        VBox v = new VBox(b1, b2, b3, b4);

        //добавим на вертикальную панель еще горизонтальную с несколькими элементами:
        Label l1 = new Label("Здесь ничего не написано");
        TextField tf = new TextField();
        Slider s = new Slider(0, 10, 20);
        HBox h = new HBox(l1, tf, s);

        v.getChildren().add(h);

        //возможна настройка расположения элементов
        v.setAlignment(Pos.CENTER);
        //8 пикселей между подузлами
        v.setSpacing(8);

        //для отладки часто хочется покрасить панельки, чтобы понимать,
        //где они находятся.
        //h.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        h.setStyle("-fx-background-color: red");

        return v;
    }
}
