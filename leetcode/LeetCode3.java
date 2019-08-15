package tk.solidays.algorithm.leetcode;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {
        int[] ascii = new int[128];//里面的元素减一可得元素出现的下标
        int max = 0;
        int count = 0;//累计长度
        int lastSamePos = -1;//上一次出现重复元素的下标
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (ascii[c] == 0) {
                count++;
            } else {
                max = count > max ? count : max;
                if (ascii[c] - 1 > lastSamePos) {//该元素上一次重复位置可以使得字串更短
                    count = i - ascii[c] + 1;
                    lastSamePos = ascii[c] - 1;
                } else {
                    count++;
                }
            }
            ascii[c] = i + 1;
        }
        max = count > max ? count : max;
        return max;
    }
}
