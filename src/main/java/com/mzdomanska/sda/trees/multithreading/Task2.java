package com.mzdomanska.sda.trees.multithreading;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {

        int[] intArray = {1,2,3,4,5};

        for (int i : intArray) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(i);
                }
            }).start();
        }

        Arrays.stream(intArray).forEach(i -> new Thread(()-> System.out.println(i)).start());
    }
}
