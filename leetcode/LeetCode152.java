package tk.solidays.algorithm.leetcode;

/**
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 示例 1:
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * 示例 2:
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode152 {
    //跳过0，重复的负数合并，左右各一遍
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int pre = 1;
        int mul = 1;
        for (int num : nums) {
            max = Math.max(max, mul *= num);
            if (mul < 0) {
                if (pre < 0) {
                    max = Math.max(max, mul *= pre);
                    pre = 1;
                } else {
                    pre = mul;
                    mul = 1;
                }
            } else if (mul == 0) {
                pre = 1;
                mul = 1;
            }
        }
        pre = 1;
        mul = 1;
        for (int i = nums.length-1; i >=0; i--) {
            max = Math.max(max, mul *= nums[i]);
            if (mul < 0) {
                if (pre < 0) {
                    max = Math.max(max, mul *= pre);
                    pre = 1;
                } else {
                    pre = mul;
                    mul = 1;
                }
            } else if (mul == 0) {
                pre = 1;
                mul = 1;
            }
        }
        return max;
    }
}
