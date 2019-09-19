package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * 说明：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode347 {
    //法一：hashmap计数，堆找前K个
    //法二：桶排序
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else map.put(num, 1);
            max = Math.max(max, map.get(num));
        }
        List[] buckets = new List[max + 1];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (buckets[entry.getValue()] == null)
                buckets[entry.getValue()] = new ArrayList();
            buckets[entry.getValue()].add(entry.getKey());
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = max; i > 0 && k > 0; i--) {
            if (buckets[i] != null && buckets[i].size() > 0) {
                for (int j = buckets[i].size() - 1; j >= 0 && k > 0; j--) {
                    ans.add((Integer) (buckets[i].get(j)));
                    k--;
                }
            }
        }
        return ans;
    }
}
