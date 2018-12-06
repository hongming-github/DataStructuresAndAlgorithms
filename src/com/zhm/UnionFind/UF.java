package com.zhm.UnionFind;

/**
 * Created by zhm on 2018/12/6.
 */
public interface UF {
    boolean isConnected(int p, int q);

    void unionElement(int p, int q);

    int getSize();
}
