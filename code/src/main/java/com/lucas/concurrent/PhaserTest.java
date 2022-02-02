package com.lucas.concurrent;

import javax.management.MBeanAttributeInfo;
import java.awt.*;
import java.lang.ref.PhantomReference;
import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/2/1
 */


public class PhaserTest {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        final Phaser phaser = new Phaser();
        // 创建5个线程
        IntStream.rangeClosed(1,5).boxed().map(i -> phaser).forEach(Task::new);
        // 主线程也注册进去
        phaser.register();

        phaser.arriveAndAwaitAdvance(); // main线程，到达并等待完成
        System.out.println("All of works are finished");


    }

    static class Task extends Thread {
        private final Phaser phaser;

        Task(Phaser phaser) {
            this.phaser = phaser;
            phaser.register();
            start();
        }

        @Override
        public void run() {
            System.out.println("The worker [" + getName() + "] " + "is working");
            try {
                TimeUnit.SECONDS.sleep(RANDOM.nextInt(5));
            } catch (Exception e) {
                e.printStackTrace();
            }
            phaser.arriveAndAwaitAdvance(); // 自己线程完成，等待其他线程完成。到达并等待完成。
        }
    }
}
