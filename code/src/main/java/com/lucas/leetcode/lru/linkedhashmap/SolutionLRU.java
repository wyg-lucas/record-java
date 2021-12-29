package com.lucas.leetcode.lru.linkedhashmap;

import java.util.LinkedHashMap;

public class SolutionLRU {
    
    int cap;
    LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();
    
    public SolutionLRU(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if (!cache.containsValue(key)) {
            return -1;
        }
        moveToTheFirst(key);
        return cache.get(key);
    }
    
    public void put(int key, int val) {
        if (cache.containsKey(key)) {
            cache.put(key,val);
            moveToTheFirst(key);
            return;
        }
        if (cache.size() >= cap) {
            int needRemove = cache.keySet().iterator().next();
            cache.remove(needRemove);
        }
        cache.put(key,val);
    }
    
    public void moveToTheFirst(int key) {
        int val = (int) cache.get(key);
        cache.remove(key);
        cache.put(key,val);
    }
    
    @Override
    public String toString() {
        for(Integer key : cache.keySet()) {
            System.out.println("[" + key +"," + cache.get(key) + "]");
        }
        
        return "";
    }
    
    public static void main(String[] args) {
        SolutionLRU lru = new SolutionLRU(2);
        lru.put(1,1);
        lru.put(2,2);
        System.out.println(lru);
        System.out.println("***************************");
        lru.put(1,4);
        System.out.println(lru);
        System.out.println("***************************");
        lru.put(3,3);
        System.out.println(lru);
        System.out.println("***************************");
        
    }
}
