package com.zhm.Set;

/**
 * Created by zhm on 2018/11/27.
 */
public interface Set<E> {

    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
