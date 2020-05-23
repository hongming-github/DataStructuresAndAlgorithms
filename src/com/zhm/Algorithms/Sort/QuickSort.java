package com.zhm.Algorithms.Sort;

import java.util.Arrays;

/**
 * Created by zhm on 2020/12/13.
 */
public class QuickSort {
    public static void main(String[] args) {
        System.out.println("Hello QuickSort!");
        int[] arr = {1, 5, 7, 3, 9, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l > r)
            return;

        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    //l...j < v, j+1...r > v
    private static int partition(int[] arr, int l, int r) {

        int j = l;
        int v = arr[l];
        //l+1...j < v, j+1...i-1 > v
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                swap(arr, j + 1, i);
                j++;
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
