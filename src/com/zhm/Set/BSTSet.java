package com.zhm.Set;

import com.zhm.BST.BinarySearchTree;

/**
 * Created by zhm on 2018/11/27.
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BinarySearchTree<E> binarySearchTree;

    public BSTSet() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Override
    public void add(E e) {
        binarySearchTree.insertNew(e);
    }

    @Override
    public void remove(E e) {
        binarySearchTree.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return binarySearchTree.contains(e);
    }

    @Override
    public int getSize() {
        return binarySearchTree.size();
    }

    @Override
    public boolean isEmpty() {
        return binarySearchTree.isEmpty();
    }
}
