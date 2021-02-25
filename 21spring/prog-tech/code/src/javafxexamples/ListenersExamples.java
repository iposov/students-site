package javafxexamples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ListenersExamples extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Пример про слушателей");

        Parent ui = createInterface();
        primaryStage.setScene(new Scene(ui, 640, 480));

        primaryStage.show();
    }

    private Parent createInterface() {
        Button b = new Button("Кнопка");

        //добавление слушателя. Универсальный метод.
        //b кнопка, источник событий. Причем источник разных типов событий
        //Указываем тип события и обработчик, это функция из Event в void
        //обычно переменную события называют e
        b.addEventHandler(ActionEvent.ACTION, actionEvent -> {
            //любое событие всегда имеет дополнительную информацию
            //Обязательно указыавается источник. В нашем случае это точно b
            System.out.println(actionEvent.getSource());
            System.out.println("Не нажимай больше эту кнопку");
        });
        //Mouse_entered - событие наведения
        b.addEventHandler(MouseEvent.MOUSE_ENTERED, mouseEvent -> {
            //в информации о событии есть координаты
            System.out.println("x,y = " + mouseEvent.getX() + " " + mouseEvent.getY());
            System.out.println("Уведи мышь, эту кнопку нельзя нажимать");
        });

        //еще один способ добавить событие на нажатие
        b.setOnAction(actionEvent -> {
            System.out.println("событие нажатия через свойство onAction");
        });

        //onAction - так можно для кнопки задать ровно один обработчик события.
        //addEventHandler - универсальный способ, можно задать много обработчиков,
        //а еще их можно удалять через removeEventHandler

        return b;
    }
}
