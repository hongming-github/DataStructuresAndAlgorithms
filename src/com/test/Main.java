package com.test;

import com.zhm.BST.BinaryTree;

public class Main {

    public static void main(String[] args) {

        insertIntoBST();
    }

    private static void insertIntoBST() {
        int[] nodes = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinaryTree binaryTree = new BinaryTree();
        for (int node : nodes) {
            binaryTree.insert(node);
        }
    }
}
