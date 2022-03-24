package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class JavaFXExampleGridPane extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое
        stage.setTitle("Пример программы с grid pane");

        //Parent — узел, который можно использовать как корень для сцены
        Parent parent = initInterface();
        stage.setScene(new Scene(parent));

        //сделать видимым
        stage.show();
    }

    private Parent initInterface() {
        GridPane panel0 = new GridPane();

        Pane panel1 = new Pane();
        Pane panel2 = new Pane();
        Pane panel3 = new Pane();
        panel1.setStyle("-fx-background-color: blue");
        panel2.setStyle("-fx-background-color: yellow");
        panel3.setStyle("-fx-background-color: red");

        panel0.setStyle("-fx-background-color: black");

        //добавляем панели 1, 2, 3 на grid pane
        panel0.add(panel1, 0, 0);
        panel0.add(panel2, 0, 1);
        //colspan сколько колонок занять, rowspan — сколько строк
        panel0.add(panel3, 1, 0, 1, 2);
        //методы add позволяют не указывать ограничения в явном виде
        //GridPane.setColumnIndex(panel1, 0);

        //надо настроить столбцы, строки, чтобы показать, кто тянется, кто
        //какую имеет высоту или ширину. Нужны ограничения на строки и столбцы

        ColumnConstraints c1 = new ColumnConstraints();
        c1.setHgrow(Priority.ALWAYS); //1 столбец тянется
        ColumnConstraints c2 = new ColumnConstraints();
        c2.setPrefWidth(150); //2 столбец 150 пикселей

        panel0.getColumnConstraints().addAll(c1, c2);

        //1 и 2 строки тянутся
        RowConstraints r1 = new RowConstraints();
        r1.setVgrow(Priority.ALWAYS);
        RowConstraints r2 = new RowConstraints();
        r2.setVgrow(Priority.ALWAYS);

        panel0.getRowConstraints().addAll(r1, r2);

        return panel0;
    }

}
