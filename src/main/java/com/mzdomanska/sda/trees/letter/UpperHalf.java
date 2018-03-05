package com.mzdomanska.sda.trees.letter;

public class UpperHalf implements Parameter {

    @Override
    public double calculateRatioOfBlackPixels(Letter letter) {

        boolean[][] binaryPicture = letter.createBinaryImage();
        int rows = binaryPicture.length;

        int blackPixelsInUpperHalf = 0;
        int otherBlackPixels = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < binaryPicture[0].length; j++) {
                if (binaryPicture[i][j]) {
                    if (i < rows/2) {
                        blackPixelsInUpperHalf++;
                    }
                    else otherBlackPixels++;
                }
            }
        }

        return (double)blackPixelsInUpperHalf/(blackPixelsInUpperHalf+otherBlackPixels);
    }
}
