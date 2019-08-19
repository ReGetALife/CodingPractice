package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出: [[1,5],[6,9]]
 * 示例 2:
 *
 * 输入: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出: [[1,2],[3,10],[12,16]]
 * 解释: 这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode57 {
    //二分查找插入位置
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0;
        int right = intervals.length - 1;
        int mid = 0;
        int insertionLeft;
        boolean isMergeLeft = false;
        int insertionRight;
        boolean isMergeRight = false;
        //找newInterval[0]的位置
        while (left <= right) {
            mid = (left + right) / 2;
            if (intervals[mid][0] > newInterval[0]) {
                right = mid - 1;
            } else if (intervals[mid][1] < newInterval[0]) {
                left = mid + 1;
            } else {
                isMergeLeft = true;
                break;
            }
        }
        insertionLeft = isMergeLeft ? mid : left;
        //找newInterval[1]的位置
        left = 0;
        right = intervals.length - 1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (intervals[mid][0] > newInterval[1]) {
                right = mid - 1;
            } else if (intervals[mid][1] < newInterval[1]) {
                left = mid + 1;
            } else {
                isMergeRight = true;
                break;
            }
        }
        insertionRight = isMergeRight ? mid : left;
        List<int[]> list = new ArrayList<>();
        if (isMergeLeft && isMergeRight) {
            list.addAll(Arrays.asList(intervals).subList(0, insertionLeft + 1));
            list.get(list.size() - 1)[1] = intervals[insertionRight][1];
            list.addAll(Arrays.asList(intervals).subList(insertionRight + 1, intervals.length));
        } else if (!isMergeLeft && !isMergeRight) {
            list.addAll(Arrays.asList(intervals).subList(0, insertionLeft));
            list.add(newInterval);
            list.addAll(Arrays.asList(intervals).subList(insertionRight, intervals.length));
        } else if (isMergeLeft) {
            list.addAll(Arrays.asList(intervals).subList(0, insertionLeft + 1));
            list.get(list.size() - 1)[1] = newInterval[1];
            list.addAll(Arrays.asList(intervals).subList(insertionRight, intervals.length));
        } else {
            list.addAll(Arrays.asList(intervals).subList(0, insertionLeft + 1));
            list.get(list.size() - 1)[0] = newInterval[0];
            list.get(list.size() - 1)[1] = intervals[insertionRight][1];
            list.addAll(Arrays.asList(intervals).subList(insertionRight + 1, intervals.length));
        }
        return list.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 2}
                , {3, 4}
                , {6, 7}
                , {8, 10}
                , {13, 16}
        };
        int[] newInterval = {4, 8};
        int[] newInterval2 = {11, 12};
        int[] newInterval3 = {4, 11};
        int[] newInterval4 = {5, 9};
//        System.out.println(Arrays.deepToString(new LeetCode57().insert(intervals, newInterval)));
//        System.out.println(Arrays.deepToString(new LeetCode57().insert(intervals, newInterval2)));
//        System.out.println(Arrays.deepToString(new LeetCode57().insert(intervals, newInterval3)));
        System.out.println(Arrays.deepToString(new LeetCode57().insert(intervals, newInterval4)));
    }
}
