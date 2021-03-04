package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ObservablesInTheInterfaceExample extends Application {

    private TextField textInput; // поле ввода текста
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private ListView<String> listView; //компонент для показывания элементов списка

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Примеры наблюдаемых значений");
        Parent parent = initInterface(); //этот метод создает интерфейс
        primaryStage.setScene(new Scene(parent));
        primaryStage.show();
        initInteraction(); //этот метод наделяет элементы поведением
    }

    private Parent initInterface() {
        textInput = new TextField("-- введите текст --");
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        listView = new ListView<>();
        final VBox vBox = new VBox(textInput, label1, label2, label3, label4, label5, listView);
        vBox.setStyle("-fx-font-size: 2em");
        return vBox;
    }

    private void initInteraction() {
        //Хотим, чтобы метка 1 показывала текст, вводимый в поле ввода.
        //Она будет показывать текст только после подтверждения окончания ввода

        //Будем слушать события от поля ввода. Как только поле ввода сообщит, что
        //введенный текст изменился, мы скопируем его в метку.
        //Слушаем ActionEvent, как у кнопки. Оно срабатывает при нажатии Enter
        textInput.addEventHandler(ActionEvent.ACTION, e -> {
            String textFromUser = textInput.getText();
            label1.setText(textFromUser);
        });

        //label2 аналогично, но только давайте найдем событие, которое срабатывает
        //при каждом изменении текста.
        //Такое событие есть, но ...
        //У javafx-объектов, в частности у элементов интерфейса, бывают свойства.
        //это наблюдаемые значения о какой-то особенности объекта. Например,
        //у кнопок, меток есть ширина. у текстового поля есть свойство "введенный текст",
        //у метки есть свойство - текст, который на ней написан. У кнопки есть свойство,
        //активна она или нет.
        //объект.имясвойстваProperty()
        //свойство text у textInput - это введенный пользователем текст
        //с этим свойством можно 1) get/set - установить или узнать значение
        //2) можно добавлять слушателей
        textInput.textProperty().addListener((value, oldValue, newValue) ->
                label2.setText(newValue)
        );
        //textProperty - это Observable, как и любое другое свойство
        //textInput.textProperty().set(""); - установить значение
        //textInput.textProperty().get(); -- узнать значение
        //textInput.setText(""); //эквивалентно textInput.textProperty().set("")
        //textInput.getText(); //эквивалентно textInput.textProperty().get()
        //label1.widthProperty().addListener(...); // ширина метки

        //Можно было бы вместо слушателя на textProperty() сделать
        //слушатель событий клавиатуры
        textInput.addEventHandler(KeyEvent.ANY, e -> {
            String textFromUser = textInput.getText();
            label3.setText(textFromUser);
            System.out.println("сработало событие клавиатуры");
        });

        // Подбирайте события правильно. Изменение введенного текста не всегда
        // результат событий клавиатуры

        // Это было использование слушателей, чтобы узнать об изменении текста в
        // поле ввода.
        // Есть еще один подход к решению задачи, как сделать так, чтобы текст в метке
        // соответствовал введенному тексту.
        // Хотим сказать, чтобы свойство Text метки всегда было равно свойству
        // Text поля ввода. Т.е. мы хотим «связать» эти свойства.
        // Это можно сделать без всяких слушателей одной командой
        label4.textProperty().bind(textInput.textProperty());
        //реально bind делает следующее:
        //1) добавляет слушателя, который следит за изменениями textInput.textProperty
        //2) запрещает явное изменение label4.textProperty, т.е. теперь нельзя
        // делает label4.setText()
        //3) сразу без всяких событий копирует значение свойства

        //prop1.bind(prop2) - делает так, что всегда при любых обстоятельствах
        //значение prop1 было равно prop2

        //дальше надо научиться связывать так, чтобы можно было чуть поменять значение,
        //например, показывать в метке введенный текст в верхнем регистре.
    }

}
