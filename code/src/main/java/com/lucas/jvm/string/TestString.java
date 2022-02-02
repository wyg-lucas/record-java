package com.lucas.jvm.string;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2022/1/27
 */


public class TestString {

    public static void main(String[] args) {
        String s1 = new String("ab");
        s1.intern();
        String s2 = "ab";
        System.out.println(s2 == s1);
        
    }
}
