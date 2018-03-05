package com.mzdomanska.sda.trees.multithreading;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task3 {

    public static void main(String[] args) {

        Stream.of(1,2,3,4,5).forEach(i -> new Thread(()-> System.out.println(i)).start());

        IntStream.of(10,20,30,40,50).boxed().forEach(i->new Thread(()-> System.out.println(i)).start());
        IntStream.range(100,110).boxed().forEach(i->new Thread(()-> System.out.println(i)).start());
        IntStream.rangeClosed(1,10).boxed().forEach(i->new Thread(()-> System.out.println(i)).start());

    }
}
