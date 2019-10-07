package tk.solidays.algorithm.leetcode;

/**
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 *
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 说明 :
 *
 * 输入的数组长度范围在 [1, 10,000]。
 * 输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

//执行用时 : 2 ms , 在所有 Java 提交中击败了 100.00% 的用户
public class LeetCode581 {
    public int findUnsortedSubarray(int[] nums) {
        //找最右的边界
        int right = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                right = i - 1;
                while (i < nums.length && nums[right] > nums[i]) i++;
                right = i - 1;
            }
        }
        //找到最左的边界
        int left = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                left = i + 1;
                while (i >= 0 && nums[left] < nums[i]) i--;
                left = i + 1;
            }
        }
        return right == left ? 0 : right - left + 1;
    }
}
