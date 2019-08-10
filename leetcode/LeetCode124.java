package tk.solidays.algorithm.leetcode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 * 示例 2:
 *
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode124 {
    private int max = 0;//记录每次遍历得到的最大和

    //在每个子树的根节点上记录该子树的最大增益
    public int maxPathSum(TreeNode root) {
        if (root != null)
            max = root.val;
        increment(root);
        return max;
    }

    private int increment(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int incLeft = increment(root.left);
        int incRight = increment(root.right);
        int currentMax = root.val;
        //如果子树的增益大于0则加上
        if (incLeft > 0)
            currentMax += incLeft;
        if (incRight > 0)
            currentMax += incRight;
        max = currentMax > max ? currentMax : max;
        //返回作为子树能贡献在最大增益
        if (incLeft < 0 && incRight < 0)
            return root.val;
        else
            return incLeft > incRight ? incLeft + root.val : incRight + root.val;
    }
}
