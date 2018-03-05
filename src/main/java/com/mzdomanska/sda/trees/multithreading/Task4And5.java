package com.mzdomanska.sda.trees.multithreading;

import java.util.Arrays;
import java.util.List;

public class Task4And5 {

    public List changeList(List<Double> list) {

        if (list.isEmpty()) throw new IllegalArgumentException("List given to changeList() cannot be empty");

        Thread t1 = new Thread(()-> {
            for (Double element : list) {
                int index = list.indexOf(element);
                if (index < list.size()/2)
                    list.set(index,Math.pow(element,2));

            }
        });

        t1.start();

        /*
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        */
        Thread t2 = new Thread(()-> {
            for (Double element : list) {
                int index = list.indexOf(element);
                if (index >= list.size()/2)
                    list.set(index,Math.sqrt(element));
            }
        });

        t2.start();

        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        return list;
    }

    public static void main(String[] args) {

        List<Double> list = Arrays.asList(1.0,3.0,5.0,7.0,4.0,16.0,81.0,100.0);

        List<Double> newList = new Task4And5().changeList(list);
        for (Double d : newList) {
            System.out.println(d);
        }

    }
}
