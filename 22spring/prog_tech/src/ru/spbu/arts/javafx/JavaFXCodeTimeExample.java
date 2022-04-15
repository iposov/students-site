package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class JavaFXCodeTimeExample extends Application  {

    private Button button1;
    private int pressCount = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Пример обработки событий");
        System.out.println("Этот код выполняется в момент запуска");

        Parent rootElement = initInterface();
        initInteraction();

        primaryStage.setScene(new Scene(rootElement));
        primaryStage.show();
    }

    private Parent initInterface() {
        System.out.println("Этот код выполняется в момент запуска");
        button1 = new Button("press me");
        button1.setStyle("-fx-font-size: 2em");
        return button1;
    }

    private void initInteraction() {
        System.out.println("Этот код выполняется в момент запуска");

        //эта переменная создана в момент запуска программы
        //эта переменная станет недоступна, когда программа выйдет
        //из обрамляющих фигурных скобок, в данном случае, после выхода
        //из метода initInteraction
        int x = 42;

        System.out.println("При запуске добавляется слушатель");
        button1.addEventHandler(ActionEvent.ACTION, e -> {
            System.out.println("Этот код выполняется при нажатии на кнопку");
            //при выполнении этого кода, метод initInteraction уже завершен
            //значит, переменной x тоже нет....

            //мы имеем доступ только к неизменяемым переменным.
            System.out.println(x);

            //на самом деле, если вы хотите пользоваться какой-то внешней
            //изменяемой переменной, это не может быть локальная переменная
            //в методе initInteraction. Почти всегда логично просто завести поле.

            //это доступ к полю объекта, объект живёт, пока живет программа.
            pressCount++;
            System.out.println("Кнопка была нажата раз: " + pressCount);
        });
//        x = 123; //после такого присваивавания x станет недоступна в слушателе

        System.out.println("Этот код выполняется в момент запуска");
    }
}
