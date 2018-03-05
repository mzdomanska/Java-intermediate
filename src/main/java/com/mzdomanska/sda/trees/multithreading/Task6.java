package com.mzdomanska.sda.trees.multithreading;

public class Task6 {

    private int initialValue = 1;

    public int incrementMe(int numberOfIncrementations) {

        for (int i = 0; i < numberOfIncrementations; i++) {

            new Thread(()->initialValue++).start();
        }

        return initialValue;
    }

    public static void main(String[] args) {

        Task6 task6 = new Task6();
        System.out.println(task6.incrementMe(1000));
    }
}
