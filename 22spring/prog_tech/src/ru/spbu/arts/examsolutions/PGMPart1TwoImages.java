package ru.spbu.arts.examsolutions;

import java.util.Random;

public class PGMPart1TwoImages {

    public static void main(String[] args) throws Exception {
        PGMImage randomImage = createRandomImage();
        PGMImage gradientImage = createGradientImage();

        randomImage.saveTo("random.pgm");
        gradientImage.saveTo("gradient.pgm");
    }

    private static PGMImage createRandomImage() {
        PGMImage randomImage = new PGMImage(80, 60);
        Random random = new Random();
        for (int line = 0; line < 60; line++)
            for (int column = 0; column < 80; column++)
                randomImage.setPixel(line, column, random.nextInt(256));
        return randomImage;
    }

    private static PGMImage createGradientImage() {
        PGMImage randomImage = new PGMImage(80, 60);
        for (int line = 0; line < 60; line++)
            for (int column = 0; column < 80; column++)
                randomImage.setPixel(line, column, (line + column) % 256);
        return randomImage;
    }

}
