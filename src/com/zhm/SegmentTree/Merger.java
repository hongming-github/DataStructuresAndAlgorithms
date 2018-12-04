package com.zhm.SegmentTree;

/**
 * Created by zhm on 2018/12/4.
 */
public interface Merger<E> {
    E merge(E a, E b);
}
