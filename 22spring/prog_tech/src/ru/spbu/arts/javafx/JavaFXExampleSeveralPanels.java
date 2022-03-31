package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXExampleSeveralPanels extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое
        stage.setTitle("Пример программы с несколькими разноцветными панелями");

        //Parent — узел, который можно использовать как корень для сцены
        Parent parent = initInterface();
        stage.setScene(new Scene(parent));

        //сделать видимым
        stage.show();
    }

    private Parent initInterface() {
        HBox panel0 = new HBox();

        VBox panel12 = new VBox();
        Pane panel3 = new Pane();
        Pane panel1 = new Pane();
        Pane panel2 = new Pane();
        panel1.setStyle("-fx-background-color: blue");
        panel2.setStyle("-fx-background-color: yellow");
        panel3.setStyle("-fx-background-color: red");
        //вообще, panel12, panel0 не будет видно, но для целей отладки лучше задать
        panel12.setStyle("-fx-background-color: green");
        panel0.setStyle("-fx-background-color: black");

        panel0.getChildren().addAll(panel12, panel3);
        panel12.getChildren().addAll(panel1, panel2);

        //добавляем constraints
        //panel12 тянем в ширину, она лежит на HBox
        HBox.setHgrow(panel12, Priority.ALWAYS);
        //надо сказать panel3, что у нее есть ширина. В пикселях
        panel3.setPrefWidth(150);

        //panel1, panel2 лежат на VBox, им нужно давать ограничения для
        //VBox
        VBox.setVgrow(panel1, Priority.ALWAYS);
        VBox.setVgrow(panel2, Priority.ALWAYS);

        return panel0;
    }
}
