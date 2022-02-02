package com.lucas.concurrent.volatileDemo;

import java.util.Currency;
import java.util.concurrent.TimeUnit;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/1/26
 */


public class TestVolatile {
    public static void main(String[] args) {
        var number = new Number();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "\t" + "comming!");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            number.addTo();
            System.out.println(Thread.currentThread().getName() + "\t" + "updated!");
        }, "A").start();

        while (number.a == 0) {

        }

        System.out.println(Thread.currentThread().getName() + "\t mission is over" );
    }

}


class Number {
    public volatile int a = 0;

    public void addTo() {

        this.a = 60;
    }
}