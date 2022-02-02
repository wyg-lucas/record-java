package com.lucas.concurrent;

import java.util.Optional;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/1/30
 */


public class TestJoin {
    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" +i));
        });
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 1000)
                    .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Optional.of("All of tasks finish done.").ifPresent(System.out::println);
        IntStream.range(1, 1000)
                .forEach(i -> System.out.println(Thread.currentThread().getName() + "->" + i));
    }

}
