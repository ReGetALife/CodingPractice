package tk.solidays.algorithm.leetcode;

/**
 * 给定长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 *
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/product-of-array-except-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length == 0)
            return nums;
        int[] output = new int[nums.length];
        //将每一位累乘后的结果存起来
        output[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            output[i] = output[i - 1] * nums[i];
        }
        //从后往前得到答案
        int multiResultOfTail = 1;
        for (int i = nums.length - 1; i > 0; i--) {
            output[i] = output[i - 1] * multiResultOfTail;
            multiResultOfTail *= nums[i];
        }
        output[0] = multiResultOfTail;
        return output;
    }
}
