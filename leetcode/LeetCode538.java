package tk.solidays.algorithm.leetcode;

/**
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 * 例如：
 *
 * 输入: 二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode538 {
    //后中左遍历，记录累加结果，1ms
    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        if (root.right != null)
            convertBST(root.right);
        root.val += sum;
        sum = root.val;
        if (root.left != null) {
            convertBST(root.left);
        }
        return root;
    }
}
