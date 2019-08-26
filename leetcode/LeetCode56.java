package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> list = new ArrayList<>();
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 0; i < intervals.length - 1; i++) {
            if (right >= intervals[i + 1][0]) {
                right = Math.max(intervals[i + 1][1], right);
            } else {
                list.add(new int[]{left, right});
                left = intervals[i + 1][0];
                right = intervals[i + 1][1];
            }
        }
        list.add(new int[]{left, right});
        return list.toArray(new int[list.size()][]);
    }
}
