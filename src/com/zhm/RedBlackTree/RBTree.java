package com.zhm.RedBlackTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhm on 2018/11/8.
 */
public class RBTree<E extends Comparable<E>> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public Node left;
        public Node right;
        public E value;
        public boolean color;

        public Node(E value) {
            this.value = value;
            this.left = null;
            this.right = null;
            color = RED;
        }

    }

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isRed(Node node) {
        if (node == null)
            return BLACK;
        return node.color;
    }

    private Node leftRotate(Node node) {
        Node x = node.right;

        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    /*Return root node
            node                              x
            / \                             /   \
           x   T2                          y   node
          / \         right rotate              / \
         y  T1      ------------------>        T1 T2
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }

    private void flipColor(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
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
        if (node.value.equals(value)) {
            return;
        }
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

    /**
     * Insert new node
     *
     * @param value
     */
    public void insertNew(E value) {
        root = insertNodeNew(root, value);
        root.color = BLACK;
    }

    /**
     * Insert node from root, return the root of new node
     *
     * @param node
     * @param value
     */
    private Node insertNodeNew(Node node, E value) {
        if (node == null) {
            size++;
            return new Node(value);
        }

        // Left child
        if (value.compareTo(node.value) < 0) {
            node.left = insertNodeNew(node.left, value);
        }
        // Right child
        else if (value.compareTo(node.value) > 0) {
            node.right = insertNodeNew(node.right, value);
        }

        if (isRed(node.right) && !isRed(node.left))
            node = leftRotate(node);

        if (isRed(node.left) && isRed(node.left.left))
            node = rightRotate(node);

        if (isRed(node.left) && isRed(node.right))
            flipColor(node);

        return node;
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

    /**
     * None recursive pre order
     */
    public void preOrderNoneRecursive() {
        System.out.println("PreOrderNoneRecursive:");
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            System.out.print(currentNode.value + " ");

            if (currentNode.right != null)
                stack.push(currentNode.right);
            if (currentNode.left != null)
                stack.push(currentNode.left);
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

    public void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null)
                queue.add(currentNode.left);
            if (currentNode.right != null)
                queue.add(currentNode.right);
        }
    }

    /**
     * Check if the BST contains given value
     *
     * @param value
     * @return
     */
    public boolean contains(E value) {
        System.out.print("Search:" + value);
        return contains(root, value);
    }

    private boolean contains(Node node, E value) {
        if (node != null) {
            E currentNodeValue = node.value;
            if (value.equals(currentNodeValue)) {
                return true;
            } else {
                if (value.compareTo(currentNodeValue) < 0) {
                    return contains(node.left, value);
                } else if (value.compareTo(currentNodeValue) > 0) {
                    return contains(node.right, value);
                }
            }
        }
        return false;
    }

    /**
     * Get the maximum value in BTS
     *
     * @return
     */
    public E findMaximumValueNR() {
        Node result = findMaximumValueNR(root);

        if (result == null) {
            return null;
        } else {
            return result.value;
        }
    }

    private Node findMaximumValueNR(Node node) {
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
     * Get the minimum value in BTS none recursive
     *
     * @return
     */
    public E findMinimumNR() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        Node result = findMinimumNR(root);

        if (result == null) {
            return null;
        } else {
            return result.value;
        }
    }

    private Node findMinimumNR(Node node) {
        if (node == null) {
            return null;
        } else {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    public E findMinimum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return findMinimum(root).value;
    }

    private Node findMinimum(Node node) {
        if (node.left == null)
            return node;

        return findMinimum(node.left);
    }

    public E findMaximum() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }

        return findMaximum(root).value;
    }

    private Node findMaximum(Node node) {
        if (node.right == null)
            return node;

        return findMaximum(node.right);
    }

    public E removeMin() {
        E result = findMinimum();
        root = removeMin(root);
        return result;
    }

    /**
     * Remove the minimum node, and return the new root of the deleted node
     *
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {
        E result = findMaximum();
        root = removeMax(root);
        return result;
    }

    /**
     * Remove the maximum node, and return the new root of the deleted node
     *
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E value) {
        root = remove(root, value);
    }

    private Node remove(Node node, E value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.value) < 0) {
            node.left = remove(node.left, value);
            return node;
        } else if (value.compareTo(node.value) > 0) {
            node.right = remove(node.right, value);
            return node;
        } else// Equal
        {
            // Left child is null
            if (node.left == null) {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // Right child is null
            if (node.right == null) {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            // If both left and right child are not empty,
            // find the smallest node that bigger than deleted node
            // which means finding the smallest node in the right children
            Node successor = findMinimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }

}