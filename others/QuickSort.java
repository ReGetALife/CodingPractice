package tk.solidays.algorithm.others;

import java.util.Arrays;

/**
 * 从左右两端开始向内遍历以实现分区的快速排序
 * 来源：https://zh.wikipedia.org/wiki/快速排序
 *
 * 注意该算法分区后，基准不一定刚好位于两个分区的分界处，但可以保证左分区的元素全部小于等于右分区
 * 例如：{1, 2, 3, 7, 0, 8}
 * 取基准 3
 * 分区后得到 {1, 2, 0, 7, 3, 8}
 */
public class QuickSort {
    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 7, 0, 8};
//        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        qSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
