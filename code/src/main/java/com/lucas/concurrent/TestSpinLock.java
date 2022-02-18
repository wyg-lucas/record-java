package com.lucas.concurrent;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/2/5
 */


public class TestSpinLock {
    volatile int number = 0;
    private void add() {
        this.number =  60;
    }

    public static void main(String[] args) {
        TestSpinLock test = new TestSpinLock();
        new Thread(() -> {
            try {
                Thread.sleep(60);
                test.add();
                System.out.println(Thread.currentThread().getName() + "\t" + test.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        while (test.number == 0) {

        }
        System.out.println(Thread.currentThread().getName() + "\t" + test.number );
        System.out.println("---------");
        int[] dp = new int[10];
        System.out.println(dp[1]);
    }
}
