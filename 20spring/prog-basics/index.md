# Основы программирования, Java

## Сайт с упражнениями

[Codingbat](http://codingbat.com)

Зарегистрируйтесь на этом сайте и решайте задачи из разделов
`Warmup-*`, `String-*`, `Logic-*`, `String-*`, `Array-*`.
Из каждого раздела необходимо решить хотя бы $6 - x$ задач, где
$x$ это сложность раздела, например, у раздела `String-3` она равна 3.  

## Материалы
* [Базовый синтаксис](basic-syntax.md)
* [Типы и литералы](lecture1-types-literals.md)
* [Строки, управление, массивы](lecture2-strings-if-for-functions-arrays.md)
* [Чтение и запись файлов](lecture3-io.md)

## Bat файл для запуска программ
Рекомендую использовать следующий bat файл для запуска программ. В нем настроены кодировки так, чтобы в ваших программах
корректно работал русский язык. Убедитесь только, что вы пишете свою программу в кодировке utf-8.

    del *.class
    set PATH=путь до каталога установки java/bin;%PATH%
    javac.exe -encoding utf8 YourClass.java
    java.exe -Dfile.encoding=CP866 YourClass
    pause

Еще одна версия bat файла, в ней не нужно указывать имя класса. Файл `HelloWorld.bat` будет запускать класс `HelloWorld`,
а если его переименовать в `Abc.bat`, он будет запускать класс `Abc`.

    del *.class
    set PATH=путь до каталога установки java/bin;%PATH%
    javac.exe -encoding utf8 %~n0.java
    java.exe -Dfile.encoding=CP866 %~n0
    pause
