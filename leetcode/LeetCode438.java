package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len = p.length();
        if (s.length() < len) return ans;
        int[] charsP = new int[128];
        int[] charsS = new int[128];
        //获得目标p的计数
        for (int i = 0; i < len; i++) charsP[p.charAt(i)]++;
        //初始计数
        for (int i = 0; i < len; i++) charsS[s.charAt(i)]++;
        //比对不同的个数
        int count = 0;
        for (int i = 0; i < 128; i++)
            if (charsP[i] != charsS[i]) count++;
        if (count == 0) ans.add(0);
        int left = 0, right = len;//先移动一步，left是上一次的开始位置，right代表下一次的结束位置
        char l, r;
        len = s.length();
        while (right < len) {
            l = s.charAt(left);
            r = s.charAt(right);
            if (charsS[l] == charsP[l]) {
                charsS[l]--;
                count++;
            } else {
                charsS[l]--;
                if (charsS[l] == charsP[l]) count--;
            }
            if (charsS[r] == charsP[r]) {
                charsS[r]++;
                count++;
            } else {
                charsS[r]++;
                if (charsS[r] == charsP[r]) count--;
            }
            left++;
            if (count == 0) ans.add(left);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode438().findAnagrams("cbaebabacd", "abc"));
    }
}
