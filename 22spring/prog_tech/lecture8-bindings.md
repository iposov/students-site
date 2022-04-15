# Связывание свойств

Наблюдаемые значения можно связывать друг с другом. Связывание означет, что одно значение зависит от другого. Например, можно связать значение свойства value у метки (т.е. текст, который написан на метке) с свойством ширина объекта окна. Тогда при каждом изменении ширины окна, текст на метке тоже будет изменяться. В данном случае просто присваивание значений невозможно, потому что ширина — число, а текст — String, но можно делать преобразование числа в String.

[JavaFXBindingsExample](https://github.com/iposov/students-site/blob/master/22spring/prog_tech/src/ru/spbu/arts/javafx/JavaFXBindingsExample.java)

## Момент выполнения кода

[JavaFXCodeTimeExample](https://github.com/iposov/students-site/blob/master/22spring/prog_tech/src/ru/spbu/arts/javafx/JavaFXCodeTimeExample.java)
