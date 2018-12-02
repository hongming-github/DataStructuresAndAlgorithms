package com.zhm.Heap;

import com.zhm.Array.Array;

/**
 * Created by zhm on 2018/12/2.
 */
public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<E>(capacity);
    }

    public MaxHeap() {
        data = new Array<E>();
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0)
            throw new IllegalArgumentException("Index 0 doesn't have parent.");

        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public void add(E e) {
        data.addLastValue(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int index) {
        while (index > 0 && data.get(parent(index)).compareTo(data.get(index)) < 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }
    }

    public E findMax() {
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not find max if the heap is empty.");
        return data.get(0);
    }

    public E extractMax() {
        E result = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return result;
    }

    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            //j is the index of the maximum value
            //of left child and right child
            int j = leftChild(index);

            //j+1 is for checking if the right child exist
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(index);
            }

            //data[j] is the maximum value of left and right child
            if (data.get(index).compareTo(data.get(j)) > 0) {
                break;
            }

            data.swap(index, j);
            index = j;
        }
    }

}
