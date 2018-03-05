package com.mzdomanska.sda.trees.letter;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        String path = "src/main/resources/letter/b1.png";
        Letter letter = new Letter("c1",path);

        Predicate<Letter> pMiddle1 = new Predicate<Letter>() {
            @Override
            public boolean test(Letter letter) {
                double middle = new MiddlePart().calculateRatioOfBlackPixels(letter);
                return middle >= 0.45 && middle <= 0.55;
            }
        };

        Predicate<Letter> pUpper = new Predicate<Letter>() {
            @Override
            public boolean test(Letter letter) {
                double upper = new UpperHalf().calculateRatioOfBlackPixels(letter);
                return upper >= 0.7 && upper <= 0.8;
            }
        };

        Predicate<Letter> pLeft = new Predicate<Letter>() {
            @Override
            public boolean test(Letter letter) {
                double left = new LeftHalf().calculateRatioOfBlackPixels(letter);
                return left >= 0.6 && left <= 0.7;
            }
        };

        Predicate<Letter> pLower = new Predicate<Letter>() {
            @Override
            public boolean test(Letter letter) {
                double d1 = new LowerHalf().calculateRatioOfBlackPixels(letter);
                double d2 = new UpperHalf().calculateRatioOfBlackPixels(letter);
                return Math.abs(d1-d2) < 0.01;
            }
        };

        Predicate<Letter> pMiddle2 = new Predicate<Letter>() {
            @Override
            public boolean test(Letter letter) {
                double middle = new MiddlePart().calculateRatioOfBlackPixels(letter);
                return middle >= 0.35 && middle <= 0.45;
            }
        };

        DecisionTree<Letter,String> root = new Question<>(pMiddle1);
        DecisionTree<Letter,String> aLetter = new Answer<>("This letter is the letter A");
        DecisionTree<Letter,String> notALetter = new Question<>(pUpper);

        root.yes(aLetter);
        root.no(notALetter);

        DecisionTree<Letter,String> tLetter = new Answer<>("This letter is the letter T");
        DecisionTree<Letter,String> notTLetter = new Question<>(pLeft);

        notALetter.yes(tLetter);
        notALetter.no(notTLetter);

        DecisionTree<Letter,String> letterNotRecognized = new Answer<>("Letter not recognized");
        DecisionTree<Letter,String> checkLowerHalf = new Question<>(pLower);

        notTLetter.yes(checkLowerHalf);
        notTLetter.no(letterNotRecognized);

        DecisionTree<Letter,String > bLetter = new Answer<>("This letter is the letter B");
        DecisionTree<Letter,String> checkMiddle = new Question<>(pMiddle2);

        checkLowerHalf.yes(bLetter);
        checkLowerHalf.no(checkMiddle);

        DecisionTree<Letter,String> kLetter = new Answer<>("This letter is the letter K");
        DecisionTree<Letter,String> cLetter = new Answer<>("This letter is the letter C");

        checkMiddle.yes(kLetter);
        checkMiddle.no(cLetter);

        System.out.println(root.ask(letter));






    }
}
