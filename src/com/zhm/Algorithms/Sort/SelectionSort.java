package com.zhm.Algorithms.Sort;

import java.util.Arrays;

/**
 * Created by zhm on 2020/12/19.
 */
public class SelectionSort {
    public static void main(String[] args) {
        System.out.println("Hello SelectionSort!");
        int[] arr = {1, 5, 7, 3, 9, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
