package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;

public class Task7a {

    private int initialValue = 1;

    private synchronized void increment() {
        initialValue++;
    }

    public int incrementMe(int numberOfIncrementations) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfIncrementations; i++) {
            threads.add(new Thread(()-> increment()));
            threads.get(i).start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return initialValue;
    }

    public static void main(String[] args) {

        Task7a task7a = new Task7a();
        System.out.println(task7a.incrementMe(1000));

        Task7b task7b = new Task7b();
        System.out.println(task7b.increment(1000));
    }
}
