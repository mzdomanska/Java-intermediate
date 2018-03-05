package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task22 {

    public List<Integer> changeList() {

        List<Integer> firstHalf = IntStream.range(0,9).boxed().collect(Collectors.toList());
        List<Integer> secondHalf = IntStream.range(10,19).boxed().collect(Collectors.toList());
        ExecutorService executor = Executors.newCachedThreadPool();


        Future<List<Integer>> result1 = executor.submit(()->firstHalf.
                stream().
                map(i->i^2).
                collect(Collectors.toList()));

        Future<List<Integer>> result2 = executor.submit(()->secondHalf.
                stream().
                map(i->i*2).
                collect(Collectors.toList()));

        try {
            List<Integer> twoListsCombined = new ArrayList<>(result1.get());
            twoListsCombined.addAll(result2.get());
            return twoListsCombined;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public static void main(String[] args) {

        Task22 task22 = new Task22();
        System.out.println(task22.changeList());
    }


}
