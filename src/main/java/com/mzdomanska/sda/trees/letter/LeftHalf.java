package com.mzdomanska.sda.trees.letter;

public class LeftHalf implements Parameter {

    @Override
    public double calculateRatioOfBlackPixels(Letter letter) {

        boolean[][] binaryPicture = letter.createBinaryImage();

        int columns = binaryPicture[0].length;

        int blackPixelsInLeftHalf = 0;
        int otherBlackPixels = 0;

        for (int i = 0; i < binaryPicture.length; i++) {
            for (int j = 0; j < columns; j++) {
                if (binaryPicture[i][j]) {
                    if (j < columns/2) {
                        blackPixelsInLeftHalf++;
                    }
                    else otherBlackPixels++;
                }
            }
        }

        return (double)blackPixelsInLeftHalf/(blackPixelsInLeftHalf+otherBlackPixels);
    }
}
