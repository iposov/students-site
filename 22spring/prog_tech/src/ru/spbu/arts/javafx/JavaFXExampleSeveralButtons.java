package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExampleSeveralButtons extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое
        stage.setTitle("Пример программы с несколькими кнопками по вертикали");

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

        // создадим панель для расположения кнопок
        // VBox расставит кнопки по вертикали
        VBox v = new VBox(b1, b2, b3);
        // можно добавить дочерний узел не сразу в конструкторе:
        v.getChildren().add(b4);
        //возможна настройка расположения элементов
        v.setAlignment(Pos.CENTER);
        //8 пикселей между подузлами
        v.setSpacing(8);

        return v;
    }
}

// Перерыв до 14:10
