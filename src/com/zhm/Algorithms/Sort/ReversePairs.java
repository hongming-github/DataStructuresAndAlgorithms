package com.zhm.Algorithms.Sort;

import java.util.Arrays;

/**
 * Created by zhm on 2020/12/19.
 */
public class ReversePairs {
    public static void main(String[] args) {
        System.out.println("Hello MergeSort!");
        int[] arr = {7, 5, 6, 4};
        System.out.println(sort(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int sort(int[] arr) {
        int n = arr.length;
        return sort(arr, 0, n - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static int sort(int[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
        if (l >= r)
            return 0;

        int mid = (l + r) / 2;

        int left = sort(arr, l, mid);

        int right = sort(arr, mid + 1, r);

        return left + right + merge(arr, l, mid, r);

    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    // 其中aux为完成merge过程所需要的辅助空间
    private static int merge(int[] arr, int l, int mid, int r) {
        int[] aux = new int[r - l + 1];
        for (int i = l; i <= r; i++)
            aux[i - l] = arr[i];
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        int res = 0;
        for (int k = l; k <= r; k++) {
            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] <= aux[j - l]) {  // 左半部分所指元素 <= 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 > 右半部分所指元素
                arr[k] = aux[j - l];
                j++;

                res += (mid - i + 1);
            }
        }
        return res;
    }


    private static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

}
