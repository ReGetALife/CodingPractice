package tk.solidays.algorithm.leetcode;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 * 示例 2:
 * <p>
 * 输入: n = 13
 * 输出: 2
 * 解释: 13 = 4 + 9.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode279 {
    //法一：dp
    public int numSquares(int n) {
        int sqrRoot = (int) Math.sqrt(n);
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i - 1] + 1;
            for (int j = 1; j <= sqrRoot; j++) {
                if (i - j * j >= 0)
                    ans[i] = Math.min(ans[i], ans[i - j * j] + 1);
            }
        }
        return ans[n];
    }

    //法二：所有的自然数都可以表示不超过4个平方数的和，并且，当自然数的形式不是4^k*(8n+7)时，不超过3个平方数
    private boolean check(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }

    public int numSquares2(int n) {
        if (check(n))
            return 1;
        while (n % 4 == 0)
            n /= 4;
        if (n % 8 == 7)
            return 4;
        int m = 1;
        while (m * m < n) {
            if (check(n - m * m))
                return 2;
            m++;
        }
        return 3;
    }

}
