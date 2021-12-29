package com.lucas.sourcecode;

public class HashMapAbout {
    public static void main(String[] args) {
        int n = 65538; // 这个数字是2^16+2
        System.out.println("开始：\n" + Integer.toBinaryString(n));
        int res = tableSizeFor(n);
        System.out.println("最终结果：" + res);
    }
    
    static final int MAXIMUM_CAPACITY = 1 << 30;
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
