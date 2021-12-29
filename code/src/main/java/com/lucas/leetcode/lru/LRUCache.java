package com.lucas.leetcode.lru;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, Node> map = new HashMap<>();
    private DoubleList doubleList = new DoubleList();
    private int cap;
    
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    
    
    public void removeLeastRecently() {
        Node x = doubleList.removeFirst();
        int deletedKey = x.key;
        map.remove(deletedKey);
    }
    
    public void deleteKey(int key) {
        if (!map.containsKey(key)) {
            return;
        }
        Node x = map.get(key);
        doubleList.remove(x);
        map.remove(x);
    }
    
    public void addRecently(int key, int val) {
        Node x = new Node(key,val);
        doubleList.addLast(x);
        map.put(key, x);
    }
    
    public void makeRecently(int key) {
        Node x = map.get(key);
        doubleList.remove(x);
        doubleList.addLast(x);
    }
    
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        makeRecently(key);
        return map.get(key).key;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            deleteKey(key);
            addRecently(key,value);
            return;
        }
        if (doubleList.size() >= this.cap) {
            removeLeastRecently();
        }
        addRecently(key, value);
    }
    
    @Override
    public String toString() {
        for (Integer key : map.keySet()) {
            System.out.println("[" + key +"," + map.get(key).val + "]");
        }
        return super.toString();
    }
    
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache);
        
    }
    
}
