package com.zhm.LinkedList;

/**
 * Created by zhm on 2018/11/17.
 */
public class LinkedList<E> {
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add new element to linked list
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node preNode = dummyHead;

        //Because we have a dummy head, so we need to for loop 'index' time to find pre node.
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        //New node points to preNode.next node,
        //preNode next points to new node
        preNode.next = new Node(e, preNode.next);

        size++;
    }

    /**
     * Add new element to the
     * head of linked list
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

}

