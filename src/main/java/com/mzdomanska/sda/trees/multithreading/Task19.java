package com.mzdomanska.sda.trees.multithreading;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Task19 {

    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String time = sdf.format(Calendar.getInstance().getTime());

        Runnable task1 = ()-> System.out.println("schedule: " + time);
        Runnable task2 = ()-> System.out.println("...atFixedRate: " + time);
        Runnable task3 = ()-> System.out.println("...withFixedDalay: " + time);

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(4);

        executor.schedule(task1,200, TimeUnit.MILLISECONDS);
        executor.scheduleAtFixedRate(task2,300,150,TimeUnit.MILLISECONDS);
        executor.scheduleWithFixedDelay(task3,400,200,TimeUnit.MILLISECONDS);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        executor.shutdown();

    }
}
