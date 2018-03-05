package com.mzdomanska.sda.trees.letter;

public class MiddlePart implements Parameter {

    @Override
    public double calculateRatioOfBlackPixels(Letter letter) {

        boolean[][] binaryPicture = letter.createBinaryImage();

        int rows = binaryPicture.length;
        int blackPixelsInMiddlePart = 0;
        int otherBlackPixels = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < binaryPicture[0].length; j++) {
                if (binaryPicture[i][j]) {
                    if (i >= rows/3 && i <= 2*rows/3) {
                        blackPixelsInMiddlePart++;
                    }
                    else otherBlackPixels++;
                }
            }
        }
        return (double) blackPixelsInMiddlePart/(blackPixelsInMiddlePart+otherBlackPixels);
    }
}
