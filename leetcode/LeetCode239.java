package tk.solidays.algorithm.leetcode;

import java.util.LinkedList;

/**
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 *
 *  
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 *  
 *
 * 提示：
 *
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
 *
 *  
 *
 * 进阶：
 *
 * 你能在线性时间复杂度内解决此题吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode239 {
    //单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (k == 1)
            return nums;
        LinkedList<Integer> queue = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];
        //初始化
        for (int i = 0; i < k - 1; i++) {
            if (queue.size() == 0 || nums[queue.peekLast()] > nums[i]) {
                queue.offer(i);
            } else {
                while (queue.size() > 0 && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.offer(i);
            }
        }
        //移动窗口
        for (int i = k - 1; i < nums.length; i++) {
            if (nums[queue.peekLast()] > nums[i]) {
                queue.offer(i);
            } else {
                while (queue.size() > 0 && nums[queue.peekLast()] <= nums[i]) {
                    queue.pollLast();
                }
                queue.offer(i);
            }
            if (queue.peek() == i - k)
                queue.poll();
            ans[i - k + 1] = nums[queue.peek()];
        }
        return ans;
    }
}
