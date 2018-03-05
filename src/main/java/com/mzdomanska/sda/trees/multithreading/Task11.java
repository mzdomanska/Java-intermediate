package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Task11 {

    public List<Integer> createSquaresList(int n) {

        List<Integer> squaresList = new CopyOnWriteArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int number = i;
            threads.add(new Thread(()->squaresList.add(number^2)));
            threads.get(i).start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return squaresList;
    }

    public static void main(String[] args) {

        System.out.println(new Task11().createSquaresList(10000).size());
    }
}
