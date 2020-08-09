package com.zhm.Algorithms.Search.BinarySearch;

/**
 * Created by zhm on 2020/8/8.
 */
public class BinarySearch {

    public static int binarySearch(int[] arr, int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            //(l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
