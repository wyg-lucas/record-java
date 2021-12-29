package com.lucas.leetcode.lru;


public class DoubleList {
    // 头尾虚节点
    private Node head, tail;
    // 大小
    private int size;
    
    public DoubleList() {
        // 初始化双链表的数据
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    // 在链表尾部添加节点 x，时间 O(1)
    public void addLast(Node x) {
        x.prev = tail.prev;
        x.next = tail;
        tail.prev.next = x;
        tail.prev = x;
        size++;
    }
    
    // 删除链表中的 x 节点（x 一定存在）
    // 由于是双链表且给的是目标 Node 节点，时间 O(1)
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }
    
    // 删除链表中第一个节点，并返回该节点，时间 O(1)
    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        
        Node tmp = head.next;
        remove(tmp);
        return tmp;
    }
    
    public int size() {return size;}
    
}
