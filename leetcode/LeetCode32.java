package tk.solidays.algorithm.leetcode;

/**
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 * 示例 2:
 *
 * 输入: ")()())"
 * 输出: 4
 * 解释: 最长有效括号子串为 "()()"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode32 {
    public int longestValidParentheses(String s) {
        int max = 0;
        int left = 0;
        int right = 0;
        //从左往右
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                left++;
            else right++;
            //右括号太多，断掉
            if (right > left) {
                max = Math.max(max, left * 2);
                right = 0;
                left = 0;
            } else if (right == left) {
                max = Math.max(max, left * 2);
            }
        }
        left = 0;
        right = 0;
        //从右往左
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                left++;
            else right++;
            //左括号太多，断掉
            if (right < left) {
                max = Math.max(max, right * 2);
                right = 0;
                left = 0;
            } else if (right == left) {
                max = Math.max(max, left * 2);
            }
        }
        return max;
    }
}
