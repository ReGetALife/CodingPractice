package tk.solidays.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode105 {
    private int[] pre;
    private int idxForPre = 0;
    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(0, inorder.length - 1);
    }

    // 把idxForPre作为头节点，把left到right的范围的中序序列分为左子树，头节点，右子树
    // 然后递增idxForPre，再递归处理子树
    private TreeNode recursion(int left, int right) {
        TreeNode treeNode = null;
        if (left <= right) {
            treeNode = new TreeNode(pre[idxForPre]);
            int p = map.get(pre[idxForPre]);//头节点在中序的位置
            idxForPre++;
            treeNode.left = recursion(left, p - 1);
            treeNode.right = recursion(p + 1, right);
        }
        return treeNode;
    }
}
