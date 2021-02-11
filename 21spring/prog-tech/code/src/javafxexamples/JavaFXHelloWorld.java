package javafxexamples;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/*
Чтобы создать оконное javaFX приложение, наследуем класс от javafx.application.Application
 */
public class JavaFXHelloWorld extends Application {

    /*
    Этот метод обязательно надо реализовать. С него запускается программа.
    В метод нам будет передан mainStage - это само окно
     */
    @Override
    public void start(Stage mainStage) {
        //устанавливаем заголовок окна
        mainStage.setTitle("Hello from JavaFX");

        //внутри окна (Stage) расположена сцена (Scene), на ней все элементы управления
        //Сцены создаются долго, нужно много кода, чтобы написать, какие
        //элементы есть на сцене, поэтому создадим интерфейс со всеми элементами
        //сцены отдельным методом initInterface();
        Button button = initInterface();
        //при создании сцены указываем элементы интерфейса на ней и,
        //при желании, размер.
        mainStage.setScene(new Scene(button, 640, 480));

        //отображаем окно на экране. Это нельзя забывать
        mainStage.show();
    }

    private Button initInterface() {
        Button pressMe = new Button("Нажми меня");
        pressMe.setOnAction(e -> System.out.println("Не нажимайте больше эту кнопку"));
        return pressMe;
    }
}
