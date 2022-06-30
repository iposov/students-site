package ru.spbu.arts.examsolutions;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class PGMImage {

    // Поля в классе — приватные
    // Мы даже можем сделать их финальными, т.е. они не будут изменяться после создания объекта
    private final int width;
    private final int height;
    private final int[][] picture;

    public PGMImage(int width, int height) {
        this.width = width;
        this.height = height;

        // в этом массиве первый индекс будет номер строки, поэтому первых индексов у нас указано
        // height штук, второй индекс — номер столбца, их width штук.
        this.picture = new int[height][width];
    }

    /**
     * Устанавливаем цвет пикселя в указанной строке, указанном столбце
     *
     * @param line   номер строки
     * @param column номер столбца
     * @param color  цвет пикселя
     */
    public void setPixel(int line, int column, int color) {
        picture[line][column] = color;
    }

    /**
     * Сохранить в файл
     *
     * @param fileName имя файла для сохранения
     * @throws Exception если при работе с файлом возникла ошибка
     */
    public void saveTo(String fileName) throws Exception {
        try (PrintStream outFile = new PrintStream(fileName, StandardCharsets.UTF_8)) {
            outFile.println("P2");
            outFile.println(width + " " + height + " 255");

            // перебираем строки картинки, каждая строка — это массив цветов пикселей
            for (int[] line : picture)
                // перебираем все пиксели в строке
                for (int pixel : line)
                    outFile.print(pixel + " ");
        }
    }
}