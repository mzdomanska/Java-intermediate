package com.mzdomanska.sda.trees.multithreading;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task9 {

    public Map<Integer,Integer> createSquaresMap(int n) {

        Map<Integer,Integer> squaresMap = new HashMap<>(n);
        List<Integer> keyList = IntStream.range(1,n).boxed().collect(Collectors.toList());

        for (Integer i : keyList) {
            new Thread(()->squaresMap.put(i,i^2)).start();
        }

        return squaresMap;
    }

    public static void main(String[] args) {

        System.out.println(new Task9().createSquaresMap(10000).size());
    }
}
