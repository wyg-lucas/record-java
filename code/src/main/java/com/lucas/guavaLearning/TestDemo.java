package com.lucas.guavaLearning;

import com.google.common.base.Preconditions;

import javax.sound.midi.Soundbank;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/1/19
 */


public class TestDemo {

    public static void main(String[] args) {
        int i = -1;
        try {
            Preconditions.checkArgument(i >= 0, "Argument was %s but excepted nonnegative", i);
        } catch (IllegalArgumentException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
