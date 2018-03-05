package com.mzdomanska.sda.trees.multithreading;

public class Task1 {

    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());

        // sposob pierwszy
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };

        // sposob drugi - lepiej tworzyc watki w ten sposob lub przy pomocy lambdy
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });

        Thread thread3 = new Thread(() -> System.out.println(Thread.currentThread().getName()));

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
