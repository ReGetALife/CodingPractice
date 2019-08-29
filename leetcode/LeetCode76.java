package tk.solidays.algorithm.leetcode;

/**
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode76 {
    //用 left 和 right 记录滑动窗口
    public String minWindow(String s, String t) {
        int[] targetMap = new int[128];
        int[] countMap = new int[128];
        int count = 0;
        int target = 0;
        char c;
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (targetMap[c] == 0)
                target++;
            targetMap[c]++;
        }
        int min = Integer.MAX_VALUE;
        String ans = "";
        int left = 0;
        int right = 0;
        if (s.length() == 0)
            return ans;
        while (right <= s.length()) {
            //未全部包含则移动 right
            if (count < target) {
                if (right == s.length())
                    break;
                c = s.charAt(right);
                if (targetMap[c] > 0) {
                    if (++countMap[c] == targetMap[c])
                        count++;
                }
                right++;
            }
            //否则移动left
            else {
                if (right - left < min) {
                    min = right - left;
                    ans = s.substring(left, right);
                }
                c = s.charAt(left);
                if (targetMap[c] > 0) {
                    if (countMap[c] == targetMap[c])
                        count--;
                    countMap[c]--;
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode76().minWindow("ADOBECODEBANC", "ABC"));
    }
}
