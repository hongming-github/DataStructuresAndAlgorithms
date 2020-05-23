package com.zhm.Algorithms.Sort;

import java.util.Arrays;

/**
 * Created by zhm on 2020/12/19.
 */
public class InsertionSort {
    public static void main(String[] args) {
        System.out.println("Hello InsertionSort!");
        int[] arr = {1, 5, 7, 3, 9, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        insertionSort(arr);
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int v = arr[i];
            int j;
            for (j = i; j > 0 && v < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = v;
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
