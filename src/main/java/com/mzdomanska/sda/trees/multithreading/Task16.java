package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Task16 {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        IntStream.range(0,10).boxed().forEach(i->executorService.submit(()-> System.out.println(i)));

        executorService.shutdown();
        //executorService.shutdownNow();


    }
}
