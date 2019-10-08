package tk.solidays.algorithm.leetcode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode647 {
    //法一：manacher算法
    //法二：中心扩展法
    public int countSubstrings(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('#');
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }
        int[] rs = new int[sb.length()];//不包括自身的半径
        int maxRight = 0, maxP = 0, mirrorP, r, ans = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (i < maxRight) {
                mirrorP = 2 * maxP - i;
                if (i + rs[mirrorP] >= maxRight) {
                    r = maxRight - i;
                    while ((i - r - 1) >= 0 && (i + r + 1) < sb.length() && sb.charAt(i - r - 1) == sb.charAt(i + r + 1))
                        r++;
                } else r = rs[mirrorP];
            } else {
                r = 0;
                while ((i - r - 1) >= 0 && (i + r + 1) < sb.length() && sb.charAt(i - r - 1) == sb.charAt(i + r + 1))
                    r++;
            }
            rs[i] = r;
            if (i + r > maxRight) {
                maxRight = i + r;
                maxP = i;
            }
        }
        for (int r1 : rs) ans += (r1 + 1 >> 1);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode647().countSubstrings("aaa"));
        System.out.println(new LeetCode647().countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg"));
    }
}
