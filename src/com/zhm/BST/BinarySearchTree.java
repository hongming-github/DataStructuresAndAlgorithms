package com.zhm.BST;

/**
 * Created by zhm on 2018/11/8.
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private class Node {
        public Node left;
        public Node right;
        public E value;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    private Node root;
    private int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert new node
     *
     * @param value
     */
    public void insert(E value) {
        if (root == null) {
            root = new Node(value);
            size++;
        } else {
            insertNode(root, value);
        }
    }

    /**
     * Insert node from root
     *
     * @param node
     * @param value
     */
    private void insertNode(Node node, E value) {
        if (node.value.equals(value))
            return;

            // Left child
        else if (value.compareTo(node.value) < 0) {
            if (node.left == null) {
                node.left = new Node(value);
                size++;
            } else {
                insertNode(node.left, value);
            }
        }
        // Right child
        else if (value.compareTo(node.value) > 0) {
            if (node.right == null) {
                node.right = new Node(value);
            } else {
                insertNode(node.right, value);
            }
        }
    }

    public void preOrder() {
        System.out.println("PreOrder:");
        this.preOrder(root);
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder() {
        System.out.println("InOrder:");
        this.inOrder(root);
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.value + " ");
            inOrder(node.right);
        }
    }

    public void postOrder() {
        System.out.println("InOrder:");
        this.postOrder(root);
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.value + " ");
        }
    }

    /**
     * Search the value in BST
     *
     * @param value
     * @return
     */
    public Node search(E value) {
        System.out.print("Search:" + value);
        return search(root, value);
    }

    private Node search(Node node, E value) {
        if (node != null) {
            E currentNodeValue = node.value;
            if (currentNodeValue.equals(value)) {
                return node;
            } else {
                if (value.compareTo(currentNodeValue) < 0) {
                    return search(node.left, value);
                } else if (value.compareTo(currentNodeValue) > 0) {
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
    public E findMaximumValue() {
        Node result = findMaximumValue(root);

        if (result == null) {
            return -1;
        } else {
            return result.value;
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
    public E findMinimumValue() {
        Node result = findMinimumValue(root);

        if (result == null) {
            return -1;
        } else {
            return result.value;
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