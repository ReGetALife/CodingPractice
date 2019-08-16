package tk.solidays.algorithm.leetcode;

import java.util.regex.Pattern;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 * <p>
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * <p>
 * 说明:
 * <p>
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 * <p>
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 * 示例 3:
 * <p>
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 * 示例 4:
 * <p>
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 * 示例 5:
 * <p>
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/regular-expression-matching
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * "aaa"
 * "a*a"
 * "aa"
 * "a*"
 * "abcpa"
 * "abcp*pa"
 * "mississippi"
 * "mis*is*p*."
 * ""
 * ""
 * "a"
 * ""
 * ""
 * "s"
 * "mississippi"
 * "mis*is*ip*."
 * "ippi"
 * "ip*."
 * "ab"
 * ".*c"
 * "a"
 * "ab*"
 * ""
 * "c*c*"
 */
public class LeetCode10 {
    public boolean isMatch(String s, String p) {
        return Pattern.compile(p).matcher(s).matches();
    }

    public boolean isMatch2(String s, String p) {
        int i = 0, j = 0;//记录匹配到的位置
        while (i < s.length() && j < p.length()) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {//出现了*
                if (s.charAt(i) == p.charAt(j) || s.charAt(i) == '.')
                    return isMatch(s.substring(i), p.substring(j + 2)) || isMatch(s.substring(i + 1), p.substring(j));//通过递归匹配一个或者直接跳过
                else return isMatch(s.substring(i), p.substring(j + 2));

            } else if (s.charAt(i) == p.charAt(j) || '.' == p.charAt(j)) {//普通匹配
                j++;
                i++;
            } else {//无法匹配
                return false;
            }
        }
        //处理a*匹配空字符的情况
        while (s.length() == i && j + 1 < p.length() && p.charAt(j + 1) == '*')
            j += 2;
        return i == s.length() && j == p.length();
    }
}
