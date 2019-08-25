package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode49 {
    //关键是将异位词映射到同一个键上。映射方法可以是字符计数；可以是字符数组排序；也可以先将字母映射到特定质数，然后再将质数相乘
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        int[] mark = new int[26];
        for (int i = 0; i < strs.length; i++) {
            Arrays.fill(mark, 0);
            for (int j = 0; j < strs[i].length(); j++) {
                mark[strs[i].charAt(j) - 97]++;
            }
            String s = new String(mark, 0, mark.length);
            System.out.println(s);
            if (!ans.containsKey(s)) {
                ans.put(s, new ArrayList<>());
            }
            ans.get(s).add(strs[i]);
        }
        return new ArrayList<>(ans.values());
    }

    public static void main(String[] args) {
        System.out.println((int) 'a');//97
        System.out.println((int) 'z');//122
    }
}
