package com.zhm.Algorithms.Sort;

import java.util.Arrays;

/**
 * Created by zhm on 2020/12/13.
 */
public class NInArray {
    public static void main(String[] args) {
        System.out.println("Hello QuickSort3Way!");
        int[] arr = {1, 5, 7, 3, 9, 6};
        System.out.println(sort(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int sort(int[] arr) {
        return quickSort3Ways(arr, 0, arr.length - 1, 0);
    }


    private static int quickSort3Ways(int[] arr, int l, int r, int n) {
        if (l > r)
            return 0;

        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        int v = arr[l];

        //l+1...lt < v, lt+1...gt-1 = v , gt...r > v
        while (i < gt) {

            if (arr[i] < v) {
                swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                swap(arr, i, gt - 1);
                gt--;
            } else {// arr[j]==v
                i++;
            }

        }
        swap(arr, l, lt);

        if (n > lt) {
            return quickSort3Ways(arr, gt, r, n);
        } else if (n < lt) {
            return quickSort3Ways(arr, l, lt - 1, n);
        } else {
            return arr[n];
        }

    }


    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
