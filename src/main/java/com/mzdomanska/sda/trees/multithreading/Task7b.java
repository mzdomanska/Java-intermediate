package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;

public class Task7b {

    private int initialValue = 1;

    public int increment(int numberOfIncrementations) {

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < numberOfIncrementations; i++) {
            threads.add(new Thread(() -> {
                synchronized (this) {
                    initialValue++;
                }
            }));
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
}
