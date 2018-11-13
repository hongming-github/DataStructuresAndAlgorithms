package com.test;

import com.zhm.BST.BinarySortTree;
import com.zhm.BST.Node;

public class Main {

    public static void main(String[] args) {
        BinarySortTree binaryTree = new BinarySortTree();
        insertIntoBST(binaryTree);

        binaryTree.preOrder();

        System.out.println("");
        binaryTree.inOrder();

        System.out.println("");
        binaryTree.postOrder();

        System.out.println("");
        Node result = binaryTree.search(8);
        System.out.println(result == null ? " Not found" : " " + result.getValue() + " found");

        System.out.println("Maximum Value:" + binaryTree.findMaximumValue());

        System.out.println("Minimum Value:" + binaryTree.findMinimumValue());

    }

    private static void insertIntoBST(BinarySortTree binaryTree) {
        int[] nodes = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySortTree binarySortTree = new BinarySortTree();
        for (int node : nodes) {
            binarySortTree.insert(node);
        }
    }
}
