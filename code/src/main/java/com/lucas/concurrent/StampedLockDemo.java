package com.lucas.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.StampedLock;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/2/1
 */


public class StampedLockDemo {

    public static final StampedLock STAMPED_LOCK = new StampedLock();

    private static Integer DATA = 0;

    public static void write() {
        long stamp = -1;
        try {
            stamp = STAMPED_LOCK.writeLock(); // 获取写锁
            DATA++;
            System.out.println("写--->" + DATA);
        } finally {
            STAMPED_LOCK.unlockWrite(stamp); // 释放写锁
        }
    }

    public static void read() {
        long stamp = -1;
        try {
            stamp = STAMPED_LOCK.readLock(); // 获取悲观读锁
            System.out.println("读--->" + DATA);
        } finally {
            STAMPED_LOCK.unlockRead(stamp); // 释放悲观读锁
        }
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(10);
        // 读任务
        Runnable readTask = () -> {
            for (;;) {
                read();
            }
        };
        // 写任务

        Runnable writeTask = () -> {
            for (;;) {
                write();
            }
        };

        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(readTask);
        ex.submit(writeTask);
    }



}
