package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 *
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 *
 *
 *
 * 示例 1：
 *
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 *
 * 输出：[7,4,1]
 *
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 *
 *
 *
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 *
 *
 * 提示：
 *
 * 给定的树是非空的，且最多有 K 个结点。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 */
public class LeetCode863 {
    private List<TreeNode> list;
    private List<Integer> ans;
    private TreeNode target;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        list = new ArrayList<>();
        ans = new ArrayList<>();
        this.target = target;
        findTarget(root);
        for (int i = 0; i < list.size(); i++) {
            findAns(list.get(i), K - list.size() + i + 1);
        }
        return ans;
    }

    private boolean findTarget(TreeNode current) {
        list.add(current);
        if (current == target) {
            return true;
        }
        if (current.left != null && findTarget(current.left)) {
            return true;
        }
        if (current.right != null && findTarget(current.right)) {
            return true;
        }
        list.remove(current);
        return false;
    }

    private void findAns(TreeNode current, int count) {
        if (count == 0) {
            ans.add(current.val);
            return;
        }
        if (current.left != null && !list.contains(current.left))//属于target的父节点不能再遍历
            findAns(current.left, count - 1);
        if (current.right != null && !list.contains(current.right))
            findAns(current.right, count - 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}