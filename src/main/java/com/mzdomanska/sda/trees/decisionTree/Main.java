package com.mzdomanska.sda.trees.decisionTree;

public class Main {
    public static void main(String[] args) {
        /*
        DecisionTree<Integer, String> root = new Question<>(i -> i >= 0);
        DecisionTree<Integer, String> isEven = new Question<>(i -> i %2 == 0);
        DecisionTree<Integer, String> answerIsNegative = new Answer<>("Number is negative");
        DecisionTree<Integer, String> answerIsPositive = new Answer<>("Number is positive");
        root.setNo(answerIsNegative);
        root.setYes(answerIsPositive);
        */
        DecisionTree<Integer, String> root = new Question<>(i -> i >= 0);
        DecisionTree<Integer, String> isEven = new Question<>(i -> i %2 == 0);
        DecisionTree<Integer, String> isGreaterThan10 = new Question<>(i -> i > 10);

        DecisionTree<Integer, String> answerIsNegative = new Answer<>("Number is negative");
        root.setNo(answerIsNegative);

        root.setYes(isEven);
        DecisionTree<Integer,String> numberIsOdd = new Answer<>("Number is odd");
        isEven.setNo(numberIsOdd);

        isEven.setYes(isGreaterThan10);
        DecisionTree<Integer,String> numberIsGreaterThan10 = new Answer<>("Number is positive, even & greater than 10");
        DecisionTree<Integer,String> numberIsSmallerThan10 = new Answer<>("Number is even but < 10");
        isGreaterThan10.setYes(numberIsGreaterThan10);
        isGreaterThan10.setNo(numberIsSmallerThan10);

        System.out.println(root.ask(-5));
        System.out.println(root.ask(5));
        System.out.println(root.ask(8));
        System.out.println(root.ask(16));
    }
}
