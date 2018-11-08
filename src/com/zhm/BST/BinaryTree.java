package com.zhm.BST;

/**
 * Created by zhm on 2018/11/8.
 */
public class BinaryTree {
    public Node node;

    public void insert(int value) {
        Node newNode = new Node(value);
        if (node == null) {
            node = newNode;
        } else {
            insertNode(node, newNode);
        }
    }

    public void insertNode(Node node, Node newNode) {
        //Left child
        if (newNode.getValue() < node.getValue()) {
            if (node.left == null) {
                node.left = newNode;
            } else {
                insertNode(node.left, newNode);
            }
        }
        //Right child
        else if (newNode.getValue() > node.getValue()) {
            if (node.right == null) {
                node.right = newNode;
            } else {
                insertNode(node.right, newNode);
            }
        }
    }
}
