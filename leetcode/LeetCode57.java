package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode57 {
    //二分查找插入位置
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = 0;
        int right = intervals.length;
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
        insertionLeft = mid;
        //找newInterval[1]的位置
        left = 0;
        right = intervals.length;
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
        insertionRight = mid;
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals).subList(0, insertionLeft));
        if(isMergeLeft&&isMergeLeft){
            list.set(list.size()-1,intervals[insertionRight][])
        }
    }
}
