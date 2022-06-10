module ru.spbu.arts.javafx {
    requires javafx.base; // другие модули, которые используем
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.swing;

    //разрешаем библиотеке javafx исследовать содержимое нашего пакета с кодом
    opens ru.spbu.arts.javafx;
    opens ru.spbu.arts.javafx.images;
    opens ru.spbu.arts.fractals;
    opens ru.spbu.arts.multithreading;
}
