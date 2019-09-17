package tk.solidays.algorithm.leetcode;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * <p>
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode309 {
    /*
     * 从buy状态经过至少一天可以进入sell状态（因为经过0天等于0收入，不予考虑），
     * 从sell状态经过一天进入cool状态
     * 从cool状态经过至少1天进入buy状态
     * 换种描述
     * 从buy经过一天可以进入buy或者sell
     * 从sell经过一天必然进入cool
     * 从cool经过一天可以进入cool或者buy
     * 所以
     * b[i] = max(c[i-1]-p[i],b[i-1])
     * c[i] = max(s[i-1],c[i-1])
     * s[i] = b[i-1]+p[i]
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
        int b = -prices[0];
        int s = 0;
        int c = 0;
        int t;
        for (int i = 1; i < prices.length; i++) {
            t = b;
            b = Math.max(c - prices[i], b);
            c = Math.max(s, c);
            s = t + prices[i];
        }
        return Math.max(s, c);
    }
}
