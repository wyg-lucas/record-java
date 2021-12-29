package com.lucas.concurrent;

import java.sql.Time;
import java.util.logging.Logger;

public class TestDemo {
    private static final Logger LOGGER = Logger.getLogger(TestDemo.class.getName());
    
    public static void main(String[] args) {
        while (true) {
            try {
                Thread.sleep(50);
                LOGGER.info(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        
    }
}
