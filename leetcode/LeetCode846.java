package tk.solidays.algorithm.leetcode;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * 爱丽丝有一手（hand）由整数数组给定的牌。
 *
 * 现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *
 * 如果她可以完成分组就返回 true，否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：hand = [1,2,3,6,2,3,4,7,8], W = 3
 * 输出：true
 * 解释：爱丽丝的手牌可以被重新排列为 [1,2,3]，[2,3,4]，[6,7,8]。
 * 示例 2：
 *
 * 输入：hand = [1,2,3,4,5], W = 4
 * 输出：false
 * 解释：爱丽丝的手牌无法被重新排列成几个大小为 4 的组。
 *
 *
 * 提示：
 *
 * 1 <= hand.length <= 10000
 * 0 <= hand[i] <= 10^9
 * 1 <= W <= hand.length
 */
public class LeetCode846 {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0)
            return false;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {//构建树
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else map.put(i, 1);
        }
        while (map.size() > 0) {
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            Map.Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 1)
                entry.setValue(entry.getValue() - 1);
            else iterator.remove();
            for (int i = 1; i < W; i++) {
                if (map.containsKey(entry.getKey() + i)) {
                    if (map.get(entry.getKey() + i) > 1)
                        map.put(entry.getKey() + i, map.get(entry.getKey() + i) - 1);
                    else map.remove(entry.getKey() + i);
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,6,2,3,4,7,8};
        System.out.println(new LeetCode846().isNStraightHand(A,3));
    }
}
