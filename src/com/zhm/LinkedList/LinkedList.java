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

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }

        Node currentNode = dummyHead.next;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }

        Node currentNode = dummyHead.next;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        currentNode.e = e;

    }

    public boolean contains(E e) {
        Node currentNode = dummyHead.next;

        while (currentNode != null) {
            if (currentNode.e == e) {
                return true;
            }
            currentNode = currentNode.next;

        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }

        Node preNode = dummyHead;

        //Because we have a dummy head, so we need to for loop 'index' time to find pre node.
        for (int i = 0; i < index; i++) {
            preNode = preNode.next;
        }

        Node delNode = preNode.next;
        preNode.next = delNode.next;
        delNode.next = null;

        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node currentNode = dummyHead.next;

        while (currentNode != null) {
            res.append(currentNode + "->");
            currentNode = currentNode.next;
        }
        //Another way
        // for(Node cur=dummyHead.next;cur!=null;cur=cur.next)
        res.append("NULL");
        return res.toString();
    }
}

