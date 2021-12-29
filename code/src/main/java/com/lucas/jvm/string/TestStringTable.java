package com.lucas.jvm.string;

/**
 * @version V1.0
 * @Title:
 * @Package
 * @Description:
 * @author: lucas_w
 * @date: 2021/12/21
 */


public class TestStringTable {

    public void test01() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        
        String s4 = s1 + s2;
        /**
         * 如下的s1 + s2 的执行细节：(变量s是我临时定义的）
         *         ① StringBuilder s = new StringBuilder();
         *         ② s.append("a")
         *         ③ s.append("b")
         *         ④ s.toString()  --> 约等于 new String("ab")，但不等价
         */
        // String 中遇到变量就会调用StringBuilder()  同时生成堆中实例 与 字符串常量池中不同。
        System.out.println(s4 == s3);
        System.out.println(s4.equals(s3));
        
    }
    
    public static void main(String[] args) {
        TestStringTable testStringTable = new TestStringTable();
        testStringTable.test01();
    }
}
