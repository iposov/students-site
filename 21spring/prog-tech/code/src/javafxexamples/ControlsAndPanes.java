package javafxexamples;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.List;

public class ControlsAndPanes extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про панельки и элементы управления");

        //сцена создается на основе Parent, это может быть почти что угодно,
        //в частности, любая панель
        Parent ui = createInterface();
        //высота и ширина, если не указаны, используются как preferred size для ui
        primaryStage.setScene(new Scene(ui, 640, 480));
//        primaryStage.setScene(new Scene(ui));

        primaryStage.show();
    }

    private Parent createInterface() {
        GridPane mainGridPain = new GridPane();
        VBox vb1 = new VBox();
        VBox vb2 = new VBox();
        HBox hb = new HBox();
        BorderPane bp = new BorderPane();

        //у grid pane метод add добавляет один элемент на сетку
        mainGridPain.add(vb1, 0, 0);
        mainGridPain.add(vb2, 1, 1);
        mainGridPain.add(hb, 0, 1);
        mainGridPain.add(bp, 1, 0);
        mainGridPain.setStyle("-fx-font-size: 3em");

        // изменение цвета панелей
        // способ 1. CSS. Не забываем -fx- в начале
        vb1.setStyle("-fx-background-color: red");
        // Background, как и в CSS, может быть очень разным
        vb2.setBackground(new Background(new BackgroundFill( // Fill - цвет
                Color.GREEN, // Color extends Paint
                new CornerRadii(0), // border radius
                null // это padding (или margin??) элемента
        )));
        hb.setStyle("-fx-background-color: blue");
        bp.setStyle("-fx-background-color: #800069");

        // начнем добавлять элементы на панели, а то пока их не видно
        // Добавляем на vb1
        vb1.getChildren() //получаем доступ к списку детей. Это почти как List
                .add(new Button("Первая кнопка"));
        vb1.getChildren().addAll(
                new Button("Вторая кнопка"),
                new Button("?!"),
                new Label("Это метка с текстом")
        );

        // Теперь настроим vb2
        final Button smallButton = new Button("?!");
        vb2.getChildren().addAll(
                new Button("Первая кнопка"),
                new ColorPicker(),
                smallButton,
                new Label("Это метка с текстом")
        );

        //теперь hbox
        hb.getChildren().addAll(
                new Button("Кн 1"),
                new Label("к. текст"),
                new Button("Кнопка 2")
        );

        // TODO добавить элементы на BorderPane

        // давайте добавим ограничения элементам, начнем с GridPane.
        // Пусть она всегда растягивает два столбца на 50% от ширины
        ColumnConstraints col1 = new ColumnConstraints(); // можно сразу указать
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints(); // можно сразу указать
        col2.setPercentWidth(50);
        //получаем список всех ограничений на столбцы и добавляем
        mainGridPain.getColumnConstraints().addAll(col1, col2);

        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        //Ctrl + Shift + Space - самая умная подсказка
        //Ctrl + Space - просто подсказка
        //Ctrl + Alt + Space - подсказка, которая ищет в классах без import
        row2.setVgrow(Priority.ALWAYS); //указываем для второй строки растягиваемость по вертикали
        //ALWAYS - растягивай всегда
        mainGridPain.getRowConstraints().addAll(row1, row2);

        //Ограничения для правого VBox, немного настроим его отображение
        //setAlignment мы указываем для всех элементов сразу
        //все элементы будут выровнены именно так
        vb2.setAlignment(Pos.BOTTOM_RIGHT); //выравнивание по правому низу
                                            // Ctrl + Shift + Space
        //как задать расположение конкретного элемента. Нужно добавить
        //ограничение, связанное с элементом. Универсальный способ добавлять
        //ограничения на элементы интерфейса.
        VBox.setVgrow(smallButton, Priority.ALWAYS);
        //Не растягивается кнопка !!
        //Возможно, дело в том, что у кнопки установлена максимальная ширина
        smallButton.setMaxWidth(Double.MAX_VALUE); //это самое большое число
        VBox.setMargin(vb2.getChildren().get(2),
                new Insets(8) // отступы со всех сторон
        );
        //Класс контейнера.setОграничение(элемент-интерфейса, значения ограничения)
        //Само vb2 мы даже не упоминаем. vb2, позиционируя элемент, обнаружит
        //его ограничение и воспользуется им.

        //Border pane
        final Button bottom = new Button("снизу");
        final Button left = new Button("слева");
        final Button right = new Button("справа");
        final Button top = new Button("сверху");
        final Button center = new Button("в центре");

        BorderPane.setAlignment(bottom, Pos.CENTER);
        bp.setBottom(bottom);
        bp.setLeft(left);
        bp.setRight(right);
        bp.setTop(top);
        bp.setCenter(center);

        for (Button b : List.of(bottom, left, right, top, center)) {
            b.setMaxWidth(Double.MAX_VALUE);
            b.setMaxHeight(Double.MAX_VALUE);
        }

        return mainGridPain; //возвращаем созданный grid pane (ui из start())
    }
}
