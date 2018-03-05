package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task14And15 {

    private Map<Integer,List<Integer>> cache = new ConcurrentHashMap<>();

    public List<Integer> createSquaresList(int n) {

        List<Integer> numbers = IntStream.range(0,n).boxed().collect(Collectors.toList());

        return cache.computeIfAbsent(n, newList -> {

            List<Integer> squares = new CopyOnWriteArrayList<>();
            List<Thread> threads = new ArrayList<>();

            for (Integer i : numbers) {
                threads.add(new Thread(()->squares.add(i^2)));
                threads.get(i).start();
            }

            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return Collections.unmodifiableList(squares);
        });

    }

    public static void main(String[] args) {

        Task14And15 task14 = new Task14And15();

        List<Integer> result1 = task14.createSquaresList(5);
        System.out.println(result1);
        result1.clear();
        List<Integer> result2 = task14.createSquaresList(5);
        System.out.println(result1);
        System.out.println(result2);



    }
}
