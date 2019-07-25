package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode16 {
    public int threeSumClosest(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        //排序
        Arrays.sort(nums);
        //与targe最接近的3个数的和
        int sum=nums[0]+nums[1]+nums[2];
        //首先固定一个数，然后另外两个数从两端往中间移动
        for (int i = 0; i < nums.length - 2; i++) {
            //判断是否是否和上一个相同
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right] + nums[i];
                if (temp - target < 0) {
                    if(Math.abs(temp-target)<Math.abs(sum-target))
                        sum = temp;
                    left++;
                }
                else if (temp -target == 0) {
                    return target;
                } else{
                    if(Math.abs(temp-target)<Math.abs(sum-target))
                        sum = temp;
                    right--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int sum = new LeetCode16().threeSumClosest(nums,1);
        System.out.println(sum);
    }
}
