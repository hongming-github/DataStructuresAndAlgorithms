package com.zhm.BST;

/**
 * Created by zhm on 2018/11/8.
 */
public class BinarySortTree {
    public Node node;

    /**
     * Insert new node
     *
     * @param value
     */
    public void insert(int value) {
        Node newNode = new Node(value);
        if (node == null) {
            node = newNode;
        } else {
            insertNode(node, newNode);
        }
    }

    private void insertNode(Node node, Node newNode) {
        // Left child
        if (newNode.getValue() < node.getValue()) {
            if (node.left == null) {
                node.left = newNode;
            } else {
                insertNode(node.left, newNode);
            }
        }
        // Right child
        else if (newNode.getValue() > node.getValue()) {
            if (node.right == null) {
                node.right = newNode;
            } else {
                insertNode(node.right, newNode);
            }
        }
    }

    public void preOrder() {
        System.out.println("PreOrder:");
        this.preOrder(node);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.getValue() + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        System.out.println("InOrder:");
        this.inOrder(node);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.getValue() + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        System.out.println("InOrder:");
        this.postOrder(node);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.getValue() + " ");
        }
    }

    /**
     * Search the value in BST
     *
     * @param value
     * @return
     */
    public Node search(int value) {
        System.out.print("Search:" + value);
        return search(node, value);
    }

    private Node search(Node node, int value) {
        if (node != null) {
            int currentNodeValue = node.getValue();
            if (currentNodeValue == value) {
                return node;
            } else {
                if (value < currentNodeValue) {
                    return search(node.left, value);
                } else if (value > currentNodeValue) {
                    return search(node.right, value);
                }
            }
        }
        return null;
    }

    /**
     * Get the maximum value in BTS
     *
     * @return
     */
    public int findMaximumValue() {
        Node result = findMaximumValue(node);

        if (result == null) {
            return -1;
        } else {
            return result.getValue();
        }
    }

    private Node findMaximumValue(Node node) {
        if (node == null) {
            return null;
        } else {
            while (node.right != null) {
                node = node.right;
            }
            return node;
        }

    }

    /**
     * Get the minimum value in BTS
     *
     * @return
     */
    public int findMinimumValue() {
        Node result = findMinimumValue(node);

        if (result == null) {
            return -1;
        } else {
            return result.getValue();
        }
    }

    private Node findMinimumValue(Node node) {
        if (node == null) {
            return null;
        } else {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

    }
}