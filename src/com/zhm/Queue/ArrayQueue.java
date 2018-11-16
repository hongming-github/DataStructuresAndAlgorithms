package com.zhm.Queue;

import com.zhm.Array.Array;

/**
 * Created by zhm on 2018/11/17.
 */

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    /**
     * O(1)
     */
    @Override
    public int getSize() {
        return array.getSize();
    }

    /**
     * O(1)
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * O(1)
     */
    @Override
    public void enqueue(E e) {
        array.addLastValue(e);
    }

    /**
     * O(n)
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * O(1)
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }

}
