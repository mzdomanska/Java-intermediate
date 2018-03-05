package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task8 {

    private AtomicInteger number = new AtomicInteger(1);

    public int increment(int numberOfIncrementation) {

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfIncrementation; i++) {
            threads.add(new Thread(()->number.incrementAndGet()));
            threads.get(i).start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return number.get();
    }

    public static void main(String[] args) {

        Task8 task8 = new Task8();
        System.out.println(task8.increment(1000));
    }
}
