package com.zhm.UnionFind;

/**
 * Created by zhm on 2018/12/6.
 */
public class UnionFind1 implements UF {
    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];

        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    private int find(int p) {
        if (p < 0 && p >= id.length)
            throw new IllegalArgumentException("p is out of bound");
        return id[p];
    }

    /**
     * O(1)
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
     * O(n)
     *
     * @param p
     * @param q
     */
    @Override
    public void unionElement(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID)
            return;

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID)
                id[i] = qID;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
