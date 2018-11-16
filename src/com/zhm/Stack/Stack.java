package com.zhm.Stack;

/**
 * Created by zhm on 2018/11/15.
 */
public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
