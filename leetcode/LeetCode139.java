package tk.solidays.algorithm.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 *
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 *
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 *
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 * 示例 3：
 *
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode139 {
    //法一：去掉匹配的头部，同时递归匹配头部之后的字符串，同时记住已经得到的结果
    //优点是可以提前结束，递归到true即返回结束，但不设置memo会导致重复计算。
    private Set<String> set;
    private boolean[] memo;
    private String s;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new boolean[s.length()];
        this.s = s;
        return recursion(0);
    }

    private boolean recursion(int pos) {
        if (pos == s.length())
            return true;
        if (memo[pos])
            return false;
        for (int i = pos; i < s.length(); i++) {
            if (set.contains(s.substring(pos, i + 1)) && recursion(i + 1)) {
                return true;
            }
        }
        memo[pos] = true;//为true则表示失败
        return false;
    }

    //法二：动态规划 if dp[i]=true and set contains s.substring(i+1,j) -> dp[j]=true
    //优点是不会有重复计算，并且可以加个判断使它提前返回。
    public boolean wordBreak2(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1]) {
                for (int j = i; j <= n; j++) {
                    if (set.contains(s.substring(i - 1, j))) {
                        dp[j] = true;
                        if (j == n)
                            return true;
                    }
                }
            }
        }
        return dp[n];
    }
}
