package tk.solidays.algorithm.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 *
 * 要求算法的时间复杂度为 O(n)。
 *
 * 示例:
 *
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode128 {
    //法一：将元素存到set中，对set中每个元素先往后找，再往前找，找过的元素删去，这个过程中维护max length。
    //法二：将元素作为key存到hashmap中（value初始0），对每个元素（value>=0）往后找，更新value为往后的最大长度，找过的元素设value为-1，同时维护max length。
    //法三：将元素存到set中，如果i-1不存在，则从i开始往后找，同时维护max length。
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count;
        for (int i : set) {
            count = 0;
            if (!set.contains(i - 1)) {
                while (set.contains(i++))
                    count++;
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
