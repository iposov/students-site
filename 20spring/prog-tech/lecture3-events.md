# События

Программирование интерфейса - это написание кода,
который срабатывает при возникновении различных событий:
1. Нажата кнопка
1. Изменен текст в поле ввода текста
1. Изменен размер окна
1. Окно развернуто на весь экран
1. Изменено значение в слайдере (компонент, где
можно двигать ползунок)
1. Выбран новый элемент списка или выпадающего списка.

События более низкого уровня
1. События клавиатуры
    1. Кнопка нажата
    1. Кнопка отпущена
    1. Кнопка сработала (нажали, потом буква повторяется)
1. События мыши
    1. Кнопку нажата
    1. Кнопка отпущена
    1. Двойной щелчок
    1. Мышь подвинулась
    1. Мышь наведена на какой-то компонент (кнопку)
    1. Мышь увели с компонента

Событие, например, "нажата кнопка" (button) может
произойти как результат события "нажата кнопка мыши",
когда мышь была поверх button. Либо как результат
нажатия на пробел на клавиатуре, когда кнопка была
выделена.

Понятия
 * Событие - объект с информаций о некотором событии,
например, если это событие мыши, то в информации будут
координаты мыши, какие кнопки мыши нажаты. Если это
событие клавиатуры, то какая кнопка клавиатуры нажата или
отпущена, какие при этом нажаты модификаторы (ctrl, shift).
Если изменилось какое-то значение, допустим,
ширина окна, то информация содержит старое и новое значение.
 * Источник события. У каждого события есть источники,
 например, при нажатии на кнопку, кнопка - источник события.
 При клике по компоненту, этот компонент источник 
 события "клик мыши".
 
     *Всегда* в информации о событии известно, кто был источником
события (target). Т.е. если нажали на кнопку, будет
известно, какую именно кнопку нажали.

 * Слушатель (listener) или обработчик (handler) - 
 это объект, заинтересованный в реагировании на событие.
 Можно обратиться к источнику событий и попросить его
 зарегистрировать слушателя. Теперь каждый раз при
 возникновении события слушатель будет об этом узнавать.
 
 
Примерный код регистрации слушателя:

```
источник.addListener(Какое событие, Слушатель)
источник.addListenerТакоготоСобытия(Слушатель)
```

Конкретно для кнопки. Кнопка является источником разных
событий, в частности, как и другие компоненты она умеет
реагировать на нажатие мыши, на наведение мыши.
Нажатие кнопки - это событие ActionEvent. Чтобы его
обработать:

```
EventHandler<ActionEvent> listener = ae -> {
    //ae - тот самый объект события, т.е. с информацией
    //о событии
    sout("Меня нажали");
};
myButton.addEventHandler(ActionEvent.ACTION, listener)
//                           тип события


// Короче можно так:
myButton.addEventHandler(ActionEvent.ACTION, ae -> {
    sout("Меня нажали");
});

//а как реагировать на мышь
myButton.addEventHandler(MouseEvent.MOUSE_ENTERED, me -> {
    sout("На кнопку наведена мышь");
    //me - это объект класса MouseEvent, в нем есть
    //me.getX(), me.isAltDown() и т.п. 
});

myButton.addEventHandler(MouseEvent.MOUSE_EXITED, me -> {
    sout("Мышь уведена с кнопки мышь");
    //me - опять объект класса MouseEvent
});
```

## Свойства

В JavaFX у многих объектов есть "свойства". Это какие-то значения,
влияющие на работу объекта, и за этими значениями можно следить,
т.е. можно устанавливать слушателей, которые следят за
измененениями значений. Примеры свойств:

* У почти всех элементов интерфейса и у самого окна есть свойства
высота и ширина (width, height)
* У многих элементов интерфейса есть свойство font (шрифт)
* disable - элемент недоступен для взаимодействия (серая кнопка)
* У TextField есть свойство text - это введенный в нее текст
* В списке элементов (ListView) есть свойство "номер выделенного
элемента"

Как пользоваться свойствами:
```
объект.имяСвойстваProperty() // это свойство
объект.имяСвойстваProperty().getValue() // узнать значение
объект.имяСвойстваProperty().setValue() // иногда можно установить
объект.getИмяСвойства()  // эквивалентно предыдущему,
объект.setИмяСвойства()  // но короче
```

Например
```
//свойство text для TextField
myTextField.setText("---")
myTextField.textProperty().setValue("---")
sout(myTextField.getText());
sout(myTextField.textProperty().getValue());
```

Как следить за изменением свойств. Добавлением на них слушателей!

1 способ, можно узнать только то, что свойство изменилось:

```
myTextField.textProperty().addListener(o -> {
    //o - это то свойство, которое изменилось. Обычно не интересно
    sout("Текст изменился")
});
```

2 способ, можно узнать старое и новое значение.
```
myTextField.textProperty().addListener((o, oldVal, newVal) -> {
    sout("Текст изменился, было " + oldVal + "стало " + newVal);
});
```

## Связывание значений свойств

```java
package su.spbu.arts.java.javafx;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFxListenersBindings extends Application {

    private TextField input;
    private Label label1;
    private Label label2;
    private Label label3;
    private Label label4;
    private Label label5;
    private Label label6;
    private Label label7;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(initInterface()));
        primaryStage.show();

        initInteraction();
    }

    private VBox initInterface() {
        input = new TextField("Введите что-нибудь");
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();
        label6 = new Label();
        label7 = new Label();

        VBox vBox = new VBox(
                input,
                label1,
                label2,
                label3,
                label4,
                label5,
                label6,
                label7
        );
        vBox.setStyle("-fx-font-size: 26px");
        return vBox;
    }

    private void initInteraction() {
        //1. Слушатель на свойство text.
        //Такой слушатель знает только то, что значение изменилось
        input.textProperty().addListener(
                o -> {
                    String newText = input.getText();
                    label1.setText(newText);
                }
                //o -> label1.setText(input.getText())
        );
        //этот код выполняется один раз при запуске
        label1.setText(input.getText());

        //2. Слушатель на свойство text.
        //Такой слушатель знает новое (и даже старое!) значение
        input.textProperty().addListener(
                (o, oldValue, newValue) -> label2.setText(newValue)
        );
        label2.setText(input.getText());

        //3. Связывание значений (binding)
        // Хотим, чтобы значение свойства text у метки label3
        // всегда было равно значению свойства text у input.
        //Метка, пусть твое св-во text будет привязано к значению
        //свойства text у input
        label3.textProperty().bind(input.textProperty());
        //label3.setText("...") это приведет к ошибке

        //4. Добавим в конец метки восклицательный знак.
        //со слушателями это делается элементарно:
        input.textProperty().addListener(o -> {
            String newText = input.getText() + "!";
            label4.setText(newText);
        });
        //TODO правда, надо чтобы при запуске тоже метка соответствовала

        //5. Как вычислять с помощью bindings
        label5.textProperty().bind(
                input.textProperty() //см. ниже обсуждение
                    .concat("!")
        );
        /*
        input.textProperty() - это Observable, т.е. величина, за изменением
        значений которой можно наблюдать.
        String text = "hello";
        ...
        text = "buy"; //пердставьте, что в этот момент мы можем
                      //узнать, что значение переменной изменилось
                      //и сразу на это отреагировать.

        По аналогии, input.textProperty() - это String, про который можно
        сразу узнать, если он изменился.
        input.textProperty() - класс ObservableString...., к нему
        не приделать "!" через +.
         */

        //а если восклицательный знак в начале?
        label6.textProperty().bind(
                Bindings.concat( //см. ниже
                        "!",
                        input.textProperty()
                )
        );
        /*
        Вспомогательный класс Bindings, в нем есть много обычных
        операций, но над Observable. В результате опять получается
        Observable
         */

        //А если хочется сделать вычисление, которое не доступно
        //через возможности Bindings. Допустим - привести к верхнему
        //регистру
        label7.textProperty().bind(
                Bindings.createStringBinding( // (1)
                        () -> input.getText().toUpperCase(),  // (2)
                        input.textProperty() // (3)
                )
        );

        /*
        (1) create***Binging - это произвольное вычисление, создает
        Observable из других Observable.
        createStringBinding потому что textProperty() имеет тип String
        (2) произвольное вычисление в виде лямбда выражения, без аргументов
        Должно возвращать String (в данном случае)
        (3) когда перевычилять наш новый Observable? Список других Observable,
        на основе которых вычисляется наш.
         */
    }
}
```

Еще раз про слушателей и bindings. Их не надо путать.
Слушатели универсальны, с ними можно реализовать любую
интерактивность. Иногда бывает, что удобно воспользоваться
связыванием свойств. Но
 - связывания реализованы через слушателей, поэтому без связываний
 всегда можно обойтись. Хотя связывания могут быть очень удобны.
 - Не путайте связывания и слушателей, всегда осознанно выбирайте,
 что из них использовать.
