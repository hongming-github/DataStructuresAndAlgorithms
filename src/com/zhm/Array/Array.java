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
	 *
	 * @param value
	 */
	public void addLastValue(E value) {
		add(size, value);
	}

	/**
	 * Add value after the last element
	 *
	 * @param value
	 */
	public void addFirstValue(E value) {
		add(0, value);
	}

	/**
	 * Add value to the specific index position
	 *
	 * @param index
	 * @param value
	 */
	public void add(int index, E value) {
		if (size == data.length) {
			throw new IllegalArgumentException("Add failed.Array is full.");
		}

		if (index < 0 || index > size) {
			throw new IllegalArgumentException("Add failed.Index >=0 and index<=size.");
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
		data[size] = null;// Loitering objects
		return result;
	}

	/**
	 * Remove the first value in array
	 *
	 * @return
	 */
	public E removeFirst() {
		return remove(0);
	}

	/**
	 * Remove the last value in array
	 *
	 * @return
	 */
	public E removeLast() {
		return remove(size - 1);
	}

	/**
	 * Remove an element
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

}
