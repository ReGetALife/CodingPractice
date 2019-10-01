package tk.solidays.algorithm.leetcode;

import java.util.*;

/**
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 *
 * 找出路径和等于给定数值的路径总数。
 *
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 *
 * 示例：
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * 返回 3。和等于 8 的路径有:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3.  -3 -> 11
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode437 {
    //法一：通过遍历树并存储当前节点之前的所有节点的累加和在栈中，每次都遍历栈
    //用Stack实现耗时54 ms，用LinkedList实现耗时21ms
    private int sum;

    public int pathSum(TreeNode root, int sum) {
        this.sum = sum;
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        return recursion(root, stack, 0);
    }

    private int recursion(TreeNode current, Stack<Integer> stack, int currentSum) {
        if (current == null)
            return 0;
        int ans = 0;
        currentSum += current.val;
        for (Integer i : stack) {
            if (currentSum - i == sum) ans++;
        }
        stack.push(currentSum);
        if (current.left != null) ans += recursion(current.left, stack, currentSum);
        if (current.right != null) ans += recursion(current.right, stack, currentSum);
        stack.pop();
        return ans;
    }

    //法二：先遍历树，把每个节点当作根去搜索和为sum的路径，耗时 16 ms
    private int count = 0;
    private int sum2 = 0;

    public int pathSum2(TreeNode root, int sum) {
        this.sum2 = sum;
        walkTree(root);
        return count;
    }

    private void walkTree(TreeNode root) {
        if (root == null)
            return;
        backTrack(root, 0);
        walkTree(root.left);
        walkTree(root.right);
    }

    private void backTrack(TreeNode current, int val) {
        if (current == null)
            return;
        val += current.val;
        if (val == sum2)
            count++;
        backTrack(current.left, val);
        backTrack(current.right, val);
    }

    //法三：在法一的基础上改进，将栈改为map计数，耗时 4ms
    private int sum3;
    private int count3 = 0;

    public int pathSum3(TreeNode root, int sum) {
        this.sum3 = sum;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        recursion(root, 0, map);
        return count3;
    }

    private void recursion(TreeNode current, int currentSum, Map<Integer, Integer> map) {
        if (current == null) return;
        currentSum += current.val;
        int target = currentSum - sum3;
        count3 += map.getOrDefault(target, 0);
        int currentNodeCount = map.getOrDefault(currentSum, 0);
        map.put(currentSum, currentNodeCount + 1);
        recursion(current.left, currentSum, map);
        recursion(current.right, currentSum, map);
        map.put(currentSum, currentNodeCount);
    }
}
