package tk.solidays.algorithm.others;

import java.util.Arrays;

public class HeapSort {
    private void heapify(int[] heap, int i, int len) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        if (left >= len)
            return;
        int max = left;
        if (right < len && heap[right] > heap[left])
            max = right;
        if (heap[max] > heap[i]) {
            int t = heap[max];
            heap[max] = heap[i];
            heap[i] = t;
            heapify(heap, max, len);
        }
    }

    private void sort(int[] nums) {
        //建立堆
        int last = (nums.length >> 1) - 1;
        for (int i = last; i >= 0; i--) {
            heapify(nums, i, nums.length);
        }
        //交换堆顶元素并调整堆
        for (int i = nums.length - 1; i > 0; i--) {
            int t = nums[0];
            nums[0] = nums[i];
            nums[i] = t;
            heapify(nums, 0, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        new HeapSort().sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
