module ru.spbu.arts.javafx {
    requires javafx.base; // другие модули, которые используем
    requires javafx.graphics;
    requires javafx.controls;

    //разрешаем библиотеке javafx исследовать содержимое нашего пакета с кодом
    opens ru.spbu.arts.javafx;
}
