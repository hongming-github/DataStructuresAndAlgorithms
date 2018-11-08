package com.zhm.BST;

/**
 * Created by zhm on 2018/11/8.
 */
public class Node {
    public Node left;
    public Node right;
    private int value;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
