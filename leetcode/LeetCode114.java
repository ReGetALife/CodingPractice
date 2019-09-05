package tk.solidays.algorithm.leetcode;

/**
 * 给定一个二叉树，原地将它展开为链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode114 {
    //把所有左子树插到右子树
    public void flatten(TreeNode root) {
        TreeNode current = root;
        TreeNode lastOfLeftSubTree;
        while (current != null) {
            if (current.left != null) {
                lastOfLeftSubTree = current.left;
                //找到左子树的最后一个右节点
                while (lastOfLeftSubTree.right != null)
                    lastOfLeftSubTree = lastOfLeftSubTree.right;
                //插入
                lastOfLeftSubTree.right = current.right;
                current.right = current.left;
                current.left = null;//左子树清空
            }
            current = current.right;
        }
    }
}
