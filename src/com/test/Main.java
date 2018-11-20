package com.test;

import com.zhm.Array.Array;
import com.zhm.BST.BinarySearchTree;
import com.zhm.Queue.ArrayQueue;
import com.zhm.Queue.LinkedListQueue;
import com.zhm.Queue.LoopQueue;
import com.zhm.Queue.Queue;
import com.zhm.Stack.ArrayStack;
import com.zhm.Stack.LinkedListStack;
import com.zhm.Stack.Stack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        testQueuePerformance();
//        LinkedList<Integer> linkedList = new LinkedList<>();
//        for (int i = 0; i < 5; i++) {
//            linkedList.addFirst(i);
//            System.out.println(linkedList);
//        }
//
//        linkedList.add(2, 666);
//        System.out.println(linkedList);
//
//        linkedList.remove(2);
//        System.out.println(linkedList);
//
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//
//        linkedList.removeLast();
//        System.out.println(linkedList);
    }

    public static void testLoopQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    public static void testQueuePerformance() {
        int opCount = 100000;
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double t1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue t1:" + t1);

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double t2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue t2:" + t2);

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double t3 = testQueue(linkedListQueue, opCount);
        System.out.println("LinkedListQueue t3:" + t3);
    }

    private static double testQueue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void testStackPerformance() {
        int opCount = 100000;
        ArrayStack<Integer> arrStack = new ArrayStack<>();
        double t1 = testStack(arrStack, opCount);
        System.out.println("ArrayStack t1:" + t1);

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double t2 = testStack(linkedListStack, opCount);
        System.out.println("LinkedList t2:" + t2);
    }

    private static double testStack(Stack<Integer> stack, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }

    public static void testStack() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

    public static void testArray() {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLastValue(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirstValue(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);
    }

    public static void testBST() {
        BinarySearchTree binaryTree = new BinarySearchTree();
        insertIntoBST(binaryTree);

        binaryTree.preOrder();

        System.out.println("");
        binaryTree.inOrder();

        System.out.println("");
        binaryTree.postOrder();

        System.out.println("");

        System.out.println("Maximum Value:" + binaryTree.findMaximumValue());

        System.out.println("Minimum Value:" + binaryTree.findMinimumValue());


    }

    private static void insertIntoBST(BinarySearchTree binaryTree) {
        int[] nodes = new int[]{8, 3, 10, 1, 6, 14, 4, 7, 13};
        BinarySearchTree binarySortTree = new BinarySearchTree();
        for (int node : nodes) {
            binarySortTree.insert(node);
        }
    }
}
