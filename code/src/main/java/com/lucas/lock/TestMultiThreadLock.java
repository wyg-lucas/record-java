package com.lucas.lock;

import java.util.stream.Stream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/1/19
 */


public class TestMultiThreadLock {
    private static volatile int a = 0;

    public static void main(String[] args) {
        TestMultiThreadLock test = new TestMultiThreadLock();
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; ++i) {
            threads[i] = new Thread(() -> {
                try {
                    for (int j = 0; j < 10; j++) {
                        //System.out.println(a++);
                        a++;
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
        System.out.println(a);

    }

}
