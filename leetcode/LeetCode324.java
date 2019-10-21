package tk.solidays.algorithm.leetcode;

import java.util.Arrays;

/**
 * 给定一个无序的数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1, 5, 1, 1, 6, 4]
 * 输出: 一个可能的答案是 [1, 4, 1, 5, 1, 6]
 * 示例 2:
 * <p>
 * 输入: nums = [1, 3, 2, 2, 3, 1]
 * 输出: 一个可能的答案是 [2, 3, 1, 3, 1, 2]
 * 说明:
 * 你可以假设所有输入都会得到有效的结果。
 * <p>
 * 进阶:
 * 你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-sort-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 穿插注意顺序，例如[1，2，4，4，4，6]这个数组，通过降序穿插得到[4,6,2,4,1,4]。
 * 如果顺序排列，则会得到[1,4,2,4,4,6]不满足要求。 这里是因为我们想尽量将小数部分的最大数放在边上，这样只用靠近一个大数部分的最大数。
 * <p>
 * [4,5,5,5,5,6,6,6]
 */
public class LeetCode324 {
    //找到中位数后，数组就已经以中位数为基准分成大小两个区间了
    //中位数可以通过排序找，也可通过快速选择找，最好是用快速选择的改进版bfprt算法（中位数的中位数算法，解决top k问题）
    //bfprt改进了基准了选择，采用中位数作为基准
    //下面采用快速选择方法，耗时 6ms
    private int[] nums;

    public void wiggleSort(int[] nums) {
        this.nums = nums;
        quickSelect(nums.length >> 1, 0, nums.length - 1);
    }

    //选择降序的第k个元素（因为上面提到的原因采用降序
    private void quickSelect(int k, int l, int r) {
        if (l >= r) return;
        int pivot = nums[convert(l + (int) (Math.random() * (r - l)))];
        //划分，不能采用从两端靠拢的方式，因为得把与pivot相同的聚集放到中间
        int i = l, j = r;
        int m = l;
        while (m <= r) {
            while (nums[convert(m)] < pivot) {
                int t = nums[convert(m)];
                nums[convert(m)] = nums[convert(r)];
                nums[convert(r)] = t;
                r--;
            }
            if (m <= r && nums[convert(m)] > pivot) {
                int t = nums[convert(m)];
                nums[convert(m)] = nums[convert(l)];
                nums[convert(l)] = t;
                l++;
            }
            m++;
        }
        //判断继续递归的区间
        if (k < l) quickSelect(k, i, l - 1);
        else if (k > r) quickSelect(k, r + 1, j);
    }

    //重新对应索引，免去后期穿插
    private int convert(int i) {
        return (i * 2 + 1) % (nums.length | 1);
    }

    public static void main(String[] args) {
        LeetCode324 leetCode324 = new LeetCode324();
        //leetCode324.wiggleSort(new int[]{10, 7, 7, 7, 5, 7, 7, 7, 9, 10});
        leetCode324.wiggleSort(new int[]{4, 5, 5, 5, 5, 6, 6, 6});
        System.out.println(Arrays.toString(leetCode324.nums));
    }
}
