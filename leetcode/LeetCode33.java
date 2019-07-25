package tk.solidays.algorithm.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode33 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target)
                return mid;
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            if (left == right)
                break;
            //从left到right已经是升序
            if (nums[left] < nums[right]) {
                if (nums[mid] < target) {
                    left = mid + 1;
                    continue;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                    continue;
                } else
                    return mid;
            }
            //从left到right之间有旋转
            else {
                //left到mid是升序
                if (nums[left] < nums[mid]) {
                    //target在改区间内
                    if (nums[mid] > target && nums[left] < target) {
                        right = mid - 1;
                        continue;
                    } else {
                        left = mid + 1;
                        continue;
                    }
                }
                //mid到right是升序
                if (nums[mid] < nums[right]) {
                    //target在改区间内
                    if (nums[mid] < target && nums[right] > target) {
                        left = mid + 1;
                        continue;
                    } else {
                        right = mid - 1;
                        continue;
                    }
                }
                //不属于上述情况
                if (mid == left)
                    return -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1};
        System.out.println(new LeetCode33().search(nums, 0));
    }
}
