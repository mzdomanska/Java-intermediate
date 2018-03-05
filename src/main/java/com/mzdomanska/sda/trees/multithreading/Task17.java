package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Task17 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<Integer> squares = new ArrayList<>();
        IntStream.range(0,100).boxed().forEach(i->executorService.submit(()-> {
            squares.add(i*i);
            System.out.println("Task " + i + ": adding " + i*i + " to list.");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executorService.shutdown();
    }
}
