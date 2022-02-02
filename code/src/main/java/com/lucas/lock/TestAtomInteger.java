package com.lucas.lock;

import java.util.TreeMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/1/19
 */


public class TestAtomInteger {

    private static volatile AtomicInteger a = new AtomicInteger();

    public static void main(String[] args) {
        TestAtomInteger test = new TestAtomInteger();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; ++i) {
            threads[i] = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        a.getAndIncrement();
                        Thread.sleep(1);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            threads[i].start();
        }
        Stream.of(threads).forEach(s -> {
            try {
                s.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(a.get());
    }
}
