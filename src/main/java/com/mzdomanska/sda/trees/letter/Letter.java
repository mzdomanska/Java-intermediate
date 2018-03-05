package com.mzdomanska.sda.trees.letter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Letter {

    private String name;
    private String path;
    private boolean[][] binaryImage;

    public Letter(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public boolean[][] getBinaryImage() {
        return binaryImage;
    }

    public boolean[][] createBinaryImage() {

        BufferedImage image = null;

        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        int xmin = image.getWidth();
        int xmax = 0;
        int ymin = image.getHeight();
        int ymax = 0;

        for (int i = 0; i < image.getWidth(); i++) {
            for (int j = 0; j < image.getHeight(); j++) {

                if (image.getRGB(i, j) == Color.black.getRGB()) {

                    if (i < xmin) xmin = i;
                    if (i > xmax) xmax = i;
                    if (j < ymin) ymin = j;
                    if (j > ymax) ymax = j;
                }
            }
        }

        binaryImage = new boolean[ymax - ymin][xmax - xmin];

        for (int i = ymin; i < ymax; i++) {
            for (int j = xmin; j < xmax; j++) {

                if (image.getRGB(j,i) != Color.white.getRGB()) {
                    binaryImage[i-ymin][j-xmin] = true;
                }
            }
        }

        return binaryImage;

    }

    public void printBinaryImage(boolean[][] binaryImage) {

        System.out.println(name);

        for (boolean[] x : binaryImage)
        {
            for (boolean y : x)
            {
                if (y == true) System.out.print("*");
                else System.out.println(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        String path = "src/main/resources/c1.png";
        Letter letter = new Letter("c1",path);
        System.out.println(new UpperHalf().calculateRatioOfBlackPixels(letter));
        System.out.println(new LowerHalf().calculateRatioOfBlackPixels(letter));
        System.out.println(new MiddlePart().calculateRatioOfBlackPixels(letter));
        System.out.println(new LeftHalf().calculateRatioOfBlackPixels(letter));
    }

}
