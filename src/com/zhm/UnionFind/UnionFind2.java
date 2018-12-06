package com.zhm.UnionFind;

/**
 * Created by zhm on 2018/12/6.
 */

/**
 * Quick union
 */
public class UnionFind2 implements UF {
    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    /**
     * O(h),h is the height of the tree
     *
     * @param p
     * @return
     */
    private int find(int p) {
        if (p < 0 && p >= parent.length)
            throw new IllegalArgumentException("p is out of bound");

        while (p != parent[p])
            p = parent[p];

        return p;
    }

    /**
     * O(h)
     *
     * @param p
     * @param q
     * @return
     */
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * O(h)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
