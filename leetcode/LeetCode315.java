package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-smaller-numbers-after-self
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

// 将数据处理成等效但值的区间更小的数组。初始化一个全0数组，用线段树辅助表示。
// 从右往左，把每个元素作为下标去更新对应全0数组使其加1，求0到该下标的区间和
public class LeetCode315 {
    private int[] tree;
    private int[] nums;
    private int index;
    private int val;

    public List<Integer> countSmaller(int[] nums) {
        //先将数组预处理，使数值紧凑为0到n-1之间
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        for (int n : sorted) {
            if (!map.containsKey(n)) {
                map.put(n, i++);
            }
        }
        for (int j = 0; j < nums.length; j++) {
            nums[j] = map.get(nums[j]);
        }

        this.nums = sorted;
        int s = 1;
        while (s < sorted.length) s <<= 1;
        tree = new int[2 * s - 1];

        //把线段树置为全0
        Arrays.fill(sorted, 0);
        //全0的数组不需要建树
        //buildTree(0, sorted.length - 1, 0);
        int[] ans = new int[nums.length];
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] == 0) ans[j] = 0;
            else ans[j] = query(0, nums[j] - 1);
            update(nums[j], this.nums[nums[j]] + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (int k : ans) list.add(k);
        return list;
    }

    public int query(int left, int right) {
        return recursion(left, right, 0, nums.length - 1, 0);
    }

    private int recursion(int leftTarget, int rightTarget, int leftCurrent, int rightCurrent, int treeNode) {
        if (rightTarget < leftCurrent) return 0;
        if (leftTarget > rightCurrent) return 0;
        if (leftTarget == leftCurrent && rightCurrent == rightTarget) return tree[treeNode];
        int mid = (leftCurrent + rightCurrent) / 2;
        int ans = 0;
        if (leftTarget <= mid)
            ans += recursion(leftTarget, Math.min(mid, rightTarget), leftCurrent, mid, treeNode * 2 + 1);
        if (rightTarget >= mid + 1)
            ans += recursion(Math.max(mid + 1, leftTarget), rightTarget, mid + 1, rightCurrent, treeNode * 2 + 2);
        return ans;
    }

    public void update(int index, int val) {
        this.nums[index] = val;
        this.index = index;
        this.val = val;
        recursion2(0, nums.length - 1, 0);
    }

    private int recursion2(int left, int right, int treeNode) {
        if (index == left && left == right) return tree[treeNode] = val;
        int mid = (left + right) / 2;
        if (index <= mid) return tree[treeNode] = recursion2(left, mid, treeNode * 2 + 1) + tree[treeNode * 2 + 2];
        return tree[treeNode] = recursion2(mid + 1, right, treeNode * 2 + 2) + tree[treeNode * 2 + 1];
    }
}
