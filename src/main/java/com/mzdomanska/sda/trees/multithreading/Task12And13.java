package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task12And13 {

    private Map<Integer,List<Integer>> cache = new HashMap<>();

    public Map<Integer, List<Integer>> getCache() {
        return cache;
    }

    public synchronized List<Integer> createSquaresList(int n) {

        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        else {
            List<Integer> numbers = IntStream.range(0,n).boxed().collect(Collectors.toList());
            List<Integer> squaresList = new CopyOnWriteArrayList<>();
            List<Thread> threads = new ArrayList<>();
            for (Integer i : numbers) {
                threads.add(new Thread(()->squaresList.add(i^2)));
                threads.get(i).start();
            }

            for (Thread t : threads) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            cache.put(n, squaresList);
            return squaresList;
        }

    }

    public static void main(String[] args) {

        new Task12And13().createSquaresList(10);
        new Task12And13().createSquaresList(15);
    }
}
