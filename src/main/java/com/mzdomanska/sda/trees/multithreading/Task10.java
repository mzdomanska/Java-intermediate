package com.mzdomanska.sda.trees.multithreading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task10 {

    public Map<Integer,Integer> createSquaresMap(int n) {

        Map<Integer,Integer> squaresMap = new ConcurrentHashMap<>(n);
        List<Integer> keyList = IntStream.range(0,n).boxed().collect(Collectors.toList());

        List<Thread> threads = new ArrayList<>();
        for (Integer i : keyList) {
            threads.add(new Thread(()->squaresMap.put(i,i^2)));
            threads.get(i).start();
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        return squaresMap;
    }

    public static void main(String[] args) {

        System.out.println(new Task10().createSquaresMap(10000).size());
    }
}
