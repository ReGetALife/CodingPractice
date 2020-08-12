package tk.solidays.algorithm.leetcode;

/**
 * 给定一个字符串 s ，找到其中最长的回文子序列，并返回该序列的长度。可以假设 s 的最大长度为 1000 。
 * <p>
 *  
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * "bbbab"
 * 输出:
 * <p>
 * 4
 * 一个可能的最长回文子序列为 "bbbb"。
 * <p>
 * 示例 2:
 * 输入:
 * <p>
 * "cbbd"
 * 输出:
 * <p>
 * 2
 * 一个可能的最长回文子序列为 "bb"。
 * <p>
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode516 {
    /*
     * 动态规划，设子序列开始于start，结束于end
     * dp[start][end] = s[start] == s[end] ? sp[start + 1][end -1] + 2 : max(dp[start + 1][end], dp[start][end - 1])
     * 从二维数组的对角线开始迭代
     */
    public int longestPalindromeSubseq(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        int start, end;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                start = j;
                end = i + j;
                if (start == end) {
                    dp[start][end] = 1;
                } else if (s.charAt(start) == s.charAt(end)) {
                    dp[start][end] = dp[start + 1][end - 1] + 2;
                } else {
                    dp[start][end] = Math.max(dp[start + 1][end], dp[start][end - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
