package tk.solidays.algorithm.leetcode;

/**
 * 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。每当你戳破一个气球 i 时，你可以获得 nums[left] * nums[i] * nums[right] 个硬币。 这里的 left 和 right 代表和 i 相邻的两个气球的序号。注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * 求所能获得硬币的最大数量。
 *
 * 说明:
 *
 * 你可以假设 nums[-1] = nums[n] = 1，但注意它们不是真实存在的所以并不能被戳破。
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * 示例:
 *
 * 输入: [3,1,5,8]
 * 输出: 167
 * 解释: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *      coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//dp[i][j]指把i到j之间的气球都戳破的最大结果，对每个dp[i][j]都遍历i到j的所有可能情况找最大的
public class LeetCode312 {
    public int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        System.arraycopy(nums, 0, newNums, 1, nums.length);
        newNums[newNums.length - 1] = 1;
        int[][] dp = new int[newNums.length][newNums.length];
        int max;
        for (int i = newNums.length - 1; i >= 0; i--) {//因为当前区间依赖更小的区间，所以逆序遍历，从小到大
            for (int j = i; j < newNums.length; j++) {
                max = 0;
                for (int k = i + 1; k < j; k++) {//k是要假设戳的位置
                    max = Math.max(max, dp[i][k] + dp[k][j] + newNums[i] * newNums[k] * newNums[j]);
                }
                dp[i][j] = max;
            }
        }
        return dp[0][newNums.length - 1];
    }
}
