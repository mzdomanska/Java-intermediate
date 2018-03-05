package com.mzdomanska.sda.trees.multithreading;

import com.mzdomanska.sda.trees.time.Time;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Task20 {

    public static void main(String[] args) {

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);
        Future<Integer> result = executor.submit(()->{
            try {
                TimeUnit.MILLISECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 5*10;

        });
        try {
            System.out.println("Future result: " + result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
