package tk.solidays.algorithm.leetcode;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode31 {
    //使用字典序排序算法
    public void nextPermutation(int[] nums) {
        if (nums.length < 2)
            return;
        int pre = 0;
        int post = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pre = i;
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] > nums[pre]) {
                        post = j;
                        break;
                    }
                }
                int t = nums[post];
                nums[post] = nums[pre];
                nums[pre] = t;
                //其实翻转即可。
                Arrays.sort(nums, pre + 1, nums.length);
                break;
            }
        }
        if (post == pre)
            Arrays.sort(nums);
    }
}
