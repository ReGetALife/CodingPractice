package tk.solidays.algorithm.leetcode;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "*"
 * 输出: true
 * 解释: '*' 可以匹配任意字符串。
 * 示例 3:
 *
 * 输入:
 * s = "cb"
 * p = "?a"
 * 输出: false
 * 解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
 * 示例 4:
 *
 * 输入:
 * s = "adceb"
 * p = "*a*b"
 * 输出: true
 * 解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
 * 示例 5:
 *
 * 输入:
 * s = "acdcb"
 * p = "a*c?b"
 * 输入: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wildcard-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode44 {
    //动态规划，dp[i][j]表示长为i的模式串是否能与长为j的字符串匹配，耗时7ms
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '*') {//全部匹配
                for (int j = 0; j <= s.length(); j++) {
                    if (dp[i][j]) {
                        for (int k = j - 1; k < s.length(); k++) {
                            dp[i + 1][k + 1] = true;
                        }
                        break;
                    }
                }
            } else if (c == '?') {
                for (int j = 0; j < s.length(); j++) {
                    if (dp[i][j]) dp[i + 1][j + 1] = true;
                }
            } else {
                for (int j = 0; j < s.length(); j++) {
                    if (dp[i][j] && c == s.charAt(j)) dp[i + 1][j + 1] = true;
                }
            }
        }
        return dp[p.length()][s.length()];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode44().isMatch("adceb", "*a*b"));
        System.out.println(new LeetCode44().isMatch("acdcb", "a*c?b"));
        System.out.println(new LeetCode44().isMatch("aa", "a"));
        System.out.println(new LeetCode44().isMatch("aa", "*"));
        System.out.println(new LeetCode44().isMatch("cb", "?a"));
        System.out.println(new LeetCode44().isMatch("", ""));
        System.out.println(new LeetCode44().isMatch("a", ""));
        System.out.println(new LeetCode44().isMatch("", "*"));
    }
}
