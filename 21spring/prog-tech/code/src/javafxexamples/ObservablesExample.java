package javafxexamples;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableIntegerValue;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public class ObservablesExample {

    public static void main(String[] args) {
        //Наблюдаемые значения
        int x = 1;
        x = 2; // может ли кто-то в этом месте узнать,
               // что x изменился?

        //значение типа Integer (int), которое при
        //изменении сообщает всем желающим, что оно
        //изменилось.
        // SimpleIntegerProperty extends ... ObservableIntegerValue
        SimpleIntegerProperty ox = new SimpleIntegerProperty(42);
        //свойства - это наблюдаемые значения с дополнительными возможностями
        //ox = 42

        //1 тип слушателя, InvalidationListener, он узнает только, что значение
        //изменилось
        ox.addListener(value -> {
            System.out.println("значение изменилось, теперь оно " + ox.get());
        });

        //2 тип слушателя. ChangeListener, дополнительно узнает, какое значение было
        ox.addListener((value, oldValue, newValue) -> {
            System.out.println(
                    "значение изменилось, оно было " + oldValue + ", " +
                            "теперь оно " + newValue
            ); //newValue == ox.get()
        });

        //Делаем присваивание, оба слушателя будут уведомлены об изменении.
        ox.setValue(123);
        //ox = 123

        //Наблюдаемые списки. Создадим список строк, за изменениями которого
        //можно наблюдать. FXCollection - вспомогательный класс, который помогает
        //создавать наблюдаемые коллекции
        ObservableList<String> ol = FXCollections.observableArrayList();

        //1. InvalidationListener знает только, что случилось какое-то изменение
        //иногда по лямбда выражению непонятен его тип, в этом случае Java
        //надо подсказать и написать явное приведение типа
        ol.addListener((InvalidationListener) value -> {
            System.out.println("Список как-то изменился, теперь он: " + ol);
        });

        ol.addListener((ListChangeListener<String>) c -> {
            //внутри c есть информация о том, что именно изменилось в списке
            System.out.println("Список изменен:");
            while (c.next()) {
                System.out.println("  добавлено элементов:" + c.getAddedSize());
                System.out.println("  удалено элементов:" + c.getRemovedSize());
            }
        });

        ol.add("line 1");
        ol.add("line 2");
        ol.addAll("line3", "line4", "line5");
    }

}
