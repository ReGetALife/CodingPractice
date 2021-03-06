package tk.solidays.algorithm.leetcode;

import java.util.Stack;

/**
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 *
 * 说明：
 * 你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 1
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 3
 * 进阶：
 * 如果二叉搜索树经常被修改（插入/删除操作）并且你需要频繁地查找第 k 小的值，你将如何优化 kthSmallest 函数？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode230 {
    //非递归中序遍历，总是把左节点先加到栈里，直到无法继续，则弹出一个，再对它的右节点做同样操作
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root!=null){
            stack.push(root);
            root=root.left;
        }
        while (stack.size()>0){
            root = stack.pop();
            count++;
            if(count==k)
                return root.val;
            root = root.right;
            while (root!=null){
                stack.push(root);
                root = root.left;
            }
        }
        return -1;
    }
}
