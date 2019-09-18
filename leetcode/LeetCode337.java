package tk.solidays.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode337 {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        //打劫root
        int a = root.val;
        if (root.left != null) a += (rob(root.left.left) + rob(root.left.right));
        if (root.right != null) a += (rob(root.right.left) + rob(root.right.right));
        //不打劫root
        int b = rob(root.left) + rob(root.right);
        return a > b ? a : b;
    }

    //上述方法出现了大量重复计算,耗时1202 ms，试一下使用备忘录，耗时11 ms
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob2(TreeNode root) {
        if (root == null)
            return 0;
        if (memo.containsKey(root))
            return memo.get(root);
        //打劫root
        int a = root.val;
        if (root.left != null) a += (rob2(root.left.left) + rob2(root.left.right));
        if (root.right != null) a += (rob2(root.right.left) + rob2(root.right.right));
        //不打劫root
        int b = rob2(root.left) + rob2(root.right);
        int c = a > b ? a : b;
        memo.put(root, c);
        return c;
    }

    //通过同时返回两种路径的结果，避免了重复的调用，耗时1 ms
    public int rob3(TreeNode root) {
        int[] ans = recursion(root);
        return Math.max(ans[0], ans[1]);
    }

    private int[] recursion(TreeNode root) {
        int[] ans = new int[2];
        if (root == null)
            return ans;
        int[] left = recursion(root.left);
        int[] right = recursion(root.right);
        ans[0] = root.val + left[1] + right[1];//打劫
        ans[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);//不打劫
        return ans;
    }
}
