package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFXExampleOneButton extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое
        stage.setTitle("Hello window");

        Button b = new Button("Нажми меня");
        //создаём сцену, говорим, что корневой узел это кнопка b
        Scene scene = new Scene(b);
        stage.setScene(scene);

        //сделать видимым
        stage.show();
    }
}
