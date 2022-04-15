package ru.spbu.arts.javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Locale;

public class JavaFXBindingsExample extends Application {

    private TextField text;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;

    private Stage primaryStage;


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;

        primaryStage.setTitle("Пример связывания свойств");
        Parent parent = initInterface();
        primaryStage.setScene(new Scene(parent));
        initInteraction();
        primaryStage.show();
    }

    private Parent initInterface() {
        //несколько метод и поле ввода текста

        text = new TextField("вводите сюда текст");

        label1 = new Label("пока без текста 1");
        label2 = new Label("пока без текста 2");
        label3 = new Label("пока без текста 3");
        label4 = new Label("пока без текста 4");
        label5 = new Label("пока без текста 5");
        label6 = new Label("пока без текста 6");
        label7 = new Label("пока без текста 7");

        VBox vbox = new VBox(
                label1, label2, label3, label4, label5, label6, label7,
                text
        );
        vbox.setStyle("-fx-font-size: 2em");
        return vbox;
    }

    private void initInteraction() {
        //Метка 1, слушатель следит за изменением text
        //нас интересует свойство text объекта text, именно в нём
        //находится значение, введенное пользователем
        //свойство text => .textProperty()
        //.textProperty() - это Observable
        //.textProperty().get() — получить значение <=> .getText()
        text.textProperty().addListener(o -> {
            String textFromUser = text.getText();
            label1.setText(textFromUser);
        });

        //Метка 2, аналогично, но другой вид слушателя
        text.textProperty().addListener(
                (o, oldValue, newValue) -> label2.setText(newValue)
        );
        //до того, как сработает слушатель, неплохо бы сразу установить текст метке
        label2.setText(text.getText());

        //Метка 3, а теперь свяжем свойства
        //свойство text у метки 3 должно быть привязано к свойству text
        //объекта text
        label3.textProperty().bind(
                text.textProperty()
        );

        //Метка 4, а что, если хочется не напрямую копировать текст, а добавить "!"
        //Класс Bindings умеет составлять из нескольких observable новые
        //Например, можно из width, height получить area = width*height, area
        //будет изменяться при любом изменении высоты, ширины
        label4.textProperty().bind(
                //text.textProperty() + "!" - невозможно
                //concat создает String-observable, соединяя значения
                Bindings.concat(text.textProperty(), "!")
        );

        //Если в Bindings нет необходимой операции, можно реализовать произвольное
        //вычисление. Будем переводить текст в верхний регистр
        label5.textProperty().bind(
                // Bindings.uppercase() - нет такого метода

                //create ... STRING ... binding, т.е. результат вычисления — строка
                Bindings.createStringBinding(
                        () -> {  //lambda выражение без аргументов
                            //как только изменится text.textProperty(),
                            //вычислится это значение, и оно будет присвоено
                            //label5.textProperty
                            return text.getText().toUpperCase();
                        },
                        text.textProperty() // за изменением text мы следим
                )
        );

        //площадь окна в метке 6
        label6.textProperty().bind(Bindings.createStringBinding(
                () -> {
                    var width = primaryStage.getWidth();
                    var height = primaryStage.getHeight();
                    return width * height + "px^2";
                },
                primaryStage.widthProperty(), primaryStage.heightProperty()
        ));

        // слушатели — универсальный механизм реагирования на события
        // bindings — подходят для особых случаев, когда надо сделать так,
        // значения разных свойств вычислялись друг через друга.

        // bindings делается через слушателей
    }
}
