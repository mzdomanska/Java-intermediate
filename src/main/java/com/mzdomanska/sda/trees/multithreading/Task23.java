package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task23 {

    public List<Integer> changeListTwo() {

        ExecutorService executor = Executors.newCachedThreadPool();

        List<Integer> firstHalf = IntStream.range(0,9).boxed().collect(Collectors.toList());
        List<Integer> secondHalf = IntStream.range(10,19).boxed().collect(Collectors.toList());

        List<Callable<Integer>> tasks = new ArrayList<>(20);

        for (Integer i : firstHalf) {
            tasks.add(()->i*i);
        }
        for (Integer i : secondHalf) {
            tasks.add(()->i*i);
        }

        List<Integer> result = new ArrayList<>();

        try {
            List<Future<Integer>> futureList = executor.invokeAll(tasks);
            for (Future<Integer> f : futureList) {
                try {
                    result.add(f.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;

    }

    public static void main(String[] args) {

        Task23 task23 = new Task23();
        System.out.println(task23.changeListTwo());
    }



}
