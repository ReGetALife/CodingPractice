package tk.solidays.algorithm.leetcode;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode4 {
    /**
     * 把两个数组，各自分成两段，使得两个数组的较小段的元素数量和等于两个数组较大段的元素数量和。
     * 如果较小段的最大值小于等于较大段的最小值，则划分的位置出现了中位数。
     * 从较小的段开始以二分方式划分。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] longer = nums1.length > nums2.length ? nums1 : nums2;
        int[] shorter = nums1.length > nums2.length ? nums2 : nums1;
        int length = nums1.length + nums2.length;
        int left = -1;
        int right = shorter.length - 1;
        if(shorter.length==0&&longer.length==1)
            return longer[0];
        while (left <= right) {
            if (check(longer, shorter, (left + right) / 2)[0] == 0) {
                if (length % 2 == 1) {
                    return check(longer, shorter, (left + right) / 2)[2];
                } else {
                    return (double)(check(longer, shorter, (left + right) / 2)[1]
                            + check(longer, shorter, (left + right) / 2)[2] )/ 2;
                }
            } else if (check(longer, shorter, (left + right) / 2)[0] > 0)
                right = (left + right) / 2 - 1;
            else
                left = (left + right) / 2 + 1;
        }
        return 0.1;
    }
    private int[] check(int[] longer, int[] shorter, int partitionShort) {// partitionS从-1到length-1。partition表示分区后较小区间的最后一个元素。若成功则返回0。太大返回1。
        int length = longer.length + shorter.length;
        int partitionLong = length / 2 - partitionShort - 2;
        int result[] = {233,233,233};// 结果，smallLast，bigFirst
        if (partitionShort == -1)
            result[1] = longer[partitionLong];
        else if (partitionLong == -1)
            result[1] = shorter[partitionShort];
        else
            result[1] = Math.max(shorter[partitionShort], longer[partitionLong]);
        if (partitionShort == shorter.length - 1)
            result[2] = longer[partitionLong + 1];
        else if (partitionLong == longer.length - 1)
            result[2] = shorter[partitionShort + 1];
        else
            result[2] = Math.min(longer[partitionLong + 1], shorter[partitionShort + 1]);
        if (result[1] <= result[2])
            result[0] = 0;
        else if (shorter[partitionShort] > result[2])
            result[0] = 1;
        else if (shorter[partitionShort + 1] < result[1])
            result[0] = -1;
        return result;
    }
}
