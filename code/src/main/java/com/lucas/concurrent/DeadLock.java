package com.lucas.concurrent;

public class DeadLock {
    
    private static String A = "A";
    private static String B = "B";
    
    public static void main(String[] args) {
        new DeadLock().deadlock();
    }
    
    public void deadlock() {
        
        Thread t1 = new Thread() {
            @Override
            public void run() {
                synchronized (A) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        };
        
        Thread t2 = new Thread() {
            @Override
            public void run() {
                synchronized (B) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        };
        
        t1.start();
        t2.start();
    }
}

