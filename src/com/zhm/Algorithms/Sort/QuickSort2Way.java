import java.util.Arrays;

/**
 * Created by zhm on 2020/12/13.
 */
public class QuickSort2Way {
    public static void main(String[] args) {
        System.out.println("Hello QuickSort3Way!");
        int[] arr = {1, 5, 7, 3, 9, 6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        quickSort2Way(arr, 0, arr.length - 1);
    }

    private static void quickSort2Way(int[] arr, int l, int r) {
        if (l > r)
            return;

        int p = partition(arr, l, r);
        quickSort2Way(arr, l, p - 1);
        quickSort2Way(arr, p + 1, r);
    }

    //l...p-1 < p, p...r >p
    //[l+1...i) <= v, (j...r] >= v
    private static int partition(int[] arr, int l, int r) {

        int i = l + 1;
        int j = r;
        int v = arr[l];

        while (true) {
            while (i <= r && arr[i] < v) i++;
            while (j >= l + 1 && arr[j] > v) j--;
            if (i > j) break;
            swap(arr, i, j);
            i++;
            j--;
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
