package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class JavaFXConstraintsExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример программы с примерами ограничений");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
    }

    private Parent initInterface() {
        HBox hbox = new HBox();

        Button button1 = new Button("Нажми меня 1");
        Button button2 = new Button("Нажми меня 2");
        Button button3 = new Button("Нажми меня 3");

        // добавляем ограничения на кнопки
        // ограничение хранится в самой кнопке, а HBox его найдет
        // и воспользуется им
        // Добавленное ограничение подойдет для любого HBox

        //ограничение hgrow = always означает, что надо всегда
        //растягиваться на максимальную ширину
        HBox.setHgrow(button1, Priority.ALWAYS);
        HBox.setHgrow(button2, Priority.ALWAYS);
        //установим кнопке 2 отступ по 4 пикселя с каждой стороны
        HBox.setMargin(button2, new Insets(4));
        //кнопочки при создании имеют максимальную ширину,
        //надо от нее избавиться
        button1.setMaxWidth(100000);
        button2.setMaxWidth(100000);

        hbox.getChildren().addAll(button1, button2, button3);
        hbox.setStyle("-fx-background-color: red");

        return hbox;
    }
}


