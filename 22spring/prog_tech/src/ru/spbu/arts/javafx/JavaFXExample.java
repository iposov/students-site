package ru.spbu.arts.javafx;

// Минимальный пример оконного приложения на JavaFX

// В JavaFX запускают не public static void main(Stirng[] args) метод, а
// класс, который расширяет Application.
// (public static void main метод тоже можно запускать, но лучше Application)
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFXExample extends Application {

    @Override
    public void start(Stage stage) {
        //объект Stage — это окно приложения, у него есть заголок, кнопочки,
        //содержимое

        stage.setTitle("Hello window");
        //сделать видимым
        stage.show();


    }
}
