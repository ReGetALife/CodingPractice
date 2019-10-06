package tk.solidays.algorithm.leetcode;

/**
 * 给定一个非负整数数组，a1, a2, ..., an, 和一个目标数，S。现在你有两个符号 + 和 -。对于数组中的任意一个整数，你都可以从 + 或 -中选择一个符号添加在前面。
 *
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
 *
 * 示例 1:
 *
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 *
 * -1+1+1+1+1 = 3
 * +1-1+1+1+1 = 3
 * +1+1-1+1+1 = 3
 * +1+1+1-1+1 = 3
 * +1+1+1+1-1 = 3
 *
 * 一共有5种方法让最终目标和为3。
 * 注意:
 *
 * 数组非空，且长度不会超过20。
 * 初始的数组的和不会超过1000。
 * 保证返回的最终结果能被32位整数存下。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode494 {
    //变形的背包问题，每个数可以是正或负，所以有两条路径可以到达
    //dp[i][j]，i是前i个数，j是和为j
    //因为每个数都可能是正的或者负的，所以出现和为S和-S的方法数是一样的，因此只需处理正数即可
    //[1,2,7,9,981]
    //1000000000
    //[0,0,0,0,0,0,0,0,1]
    //1
    //[1,999]
    //998
    public int findTargetSumWays(int[] nums, int S) {
        if (Math.abs(S) > 1000) return 0;//S可能很大
        int[][] dp = new int[nums.length][1001];
        dp[0][nums[0]] = nums[0] == 0 ? 2 : 1;//是0的时候有两种方法
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= 1000; j++) {
                int low = Math.abs(j - nums[i]);
                if (low <= 1000) dp[i][j] += dp[i - 1][low];
                int high = j + nums[i];
                if (high <= 1000) dp[i][j] += dp[i - 1][high];
            }
        }
        return dp[nums.length - 1][Math.abs(S)];
    }

    public static void main(String[] args) {
        new LeetCode494().findTargetSumWays(new int[]{1, 999}, 998);
    }
}
