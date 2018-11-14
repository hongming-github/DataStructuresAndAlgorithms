package com.zhm.Array;

/**
 * Created by zhm on 2018/11/13.
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * Constructor with capacity
     *
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Constructor without parameters, default capacity is 10
     */
    public Array() {
        this(10);
    }

    /**
     * Get the number of elements in array
     *
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Get the capacity of array
     *
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * Check if the array is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return this.size == 0;
    }

    /**
     * Add value after the last element
     * <p>
     * O(1)
     * <p>
     * Amortized time complexity: (2n+1)/2n=2, so O(1)
     *
     * @param value
     */
    public void addLastValue(E value) {
        add(size, value);
    }

    /**
     * Add value after the last element
     * <p>
     * O(n)
     *
     * @param value
     */
    public void addFirstValue(E value) {
        add(0, value);
    }

    /**
     * Add value to the specific index position
     * <p>
     * O(n/2)=O(n)
     *
     * @param index
     * @param value
     */
    public void add(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed.Index >=0 and index<=size.");
        }

        if (size == data.length) {
            resize(2 * data.length);
        }

        // Move all the elements which is after index to the next index
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        size++;
    }

    /**
     * Get value based on index
     * <p>
     * O(1)
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed.Index >=0 and index<=size.");
        }
        return data[index];
    }

    /**
     * Modify specific index value
     * <p>
     * O(1)
     *
     * @param index
     * @param value
     */
    public void set(int index, E value) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed.Index >=0 and index<=size.");
        }
        data[index] = value;
    }

    /**
     * Check if the array contains a value
     * <p>
     * O(n)
     *
     * @param value
     * @return
     */
    public boolean contains(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Find index for a value
     * <p>
     * O(n)
     *
     * @param value
     * @return
     */
    public int find(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Remove a value based on index and return removed value
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed.Index >=0 and index<=size.");
        }

        E result = data[index];

        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;// Loitering objects!= memory leak

        // 1:Lazy resize.
        // 2:Check data.length/2 != 0 is for if the result is 0, the new capacity will be 0 which is wrong
        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return result;
    }

    /**
     * Remove the first value in array
     * <p>
     * O(n)
     *
     * @return
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * Remove the last value in array
     * <p>
     * O(1)
     *
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * Remove an element
     * <p>
     * O(n/2)=O(n)
     *
     * @param value
     */
    public void removeElement(E value) {
        int index = find(value);
        if (index != -1) {
            remove(index);
        }
    }

    /**
     * Override toString method
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size %d , capacity %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    /**
     * Change the size of array
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

}
