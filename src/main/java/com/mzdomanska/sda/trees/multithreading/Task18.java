package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Task18 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();
        IntStream.range(0,30).boxed().forEach(i->executorService.submit(()-> System.out.println("Task " + i)));

        executorService.shutdown();
    }
}
