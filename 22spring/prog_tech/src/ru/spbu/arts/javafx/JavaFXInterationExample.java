package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXInterationExample extends Application {

    private Button button1; // первая кнопка на окне

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример обработки событий");

        Parent rootElement = initInterface();
        initInteraction(); // в этом методе будем описывать поведение интерфейса

        primaryStage.setScene(new Scene(rootElement));
        primaryStage.show();
    }

    private Parent initInterface() {
        //сохраним созданную кнопку в поле объекта
        button1 = new Button("Не нажимай эту кнопку");
        button1.setMaxWidth(100000); //много. Нужно, чтобы кнопка тянулась
        button1.setMaxHeight(Double.MAX_VALUE); //самый большой double, который бывает

        return new VBox(button1);
    }

    private void initInteraction() {
        // здесь мне требуется описать поведение button1

        //1 способ. Универсальный, так можно слушателя любого события
        //указываем, события какого типа нам инетресны. Нажатие кнопки — ActionEvent
        //сравните с javascript: button1.addEventListener("click", ...)
        //и указываем реализацию интерфейса EventHandler (=слушатель)
        //такой интерфейс можно реализовать lambda-выражением
        button1.addEventHandler(ActionEvent.ACTION, event -> {
            //переменная event содержит информацию о событии.
            System.out.println("Нельзя было нажимать на эту кнопку, пожалуйста, больше не нажимайте");
            System.out.println(event.getSource()); // можно получить объект-источник события
        });

        //события мыши, бывают разные — клик, опустить кнопку, поднять кнопку, движение, наведение, уведение
        //Что бы с мышью не случилось, информация о событии - это координаты курсора, какие кнопки
        //нажаты (левая, правая)
        button1.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            System.out.println("Нажата мышь: " + mouseEvent.getButton());
        });

        button1.addEventHandler(MouseEvent.MOUSE_MOVED, mouseEvent ->
                System.out.println("мышь движется: " + mouseEvent.getX() + ", " + mouseEvent.getY())
        );

        //2. Как еще можно реагировать на нажатие кнопки
        button1.setOnAction(actionEvent -> {
            System.out.println("Кнопка нажата (2 способ добавления слушателя)");
        });
        // этот способ короче первого, но таким образом можно добавить только одного слушателя на нажатие кнопки
        // зато легко удалить слушателя: button1.setOnAction(null)
        // в первом случае удалить слушателя тоже можно, button1.removeEventHandler(... тот же объект EventHandler,
        // что и раньше.

        // про Observables:

        //button1.widthProperty() - это Observable значение ширины кнопки
        button1.widthProperty().addListener(observable ->
                System.out.println("Ширина кнопки стала " + button1.getWidth()) // или button1.widthProperty().get()
        );
        button1.widthProperty().addListener((o, oldWidth, newWidth) ->
                System.out.println("Ширина кнопки была " + oldWidth + " и стала " + newWidth)
        );
    }
}
