package tk.solidays.algorithm.leetcode;

public class LeetCode543 {
    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        recursion(root);
        return max;
    }

    private int recursion(TreeNode root) {
        if (root == null)
            return 0;
        int l = recursion(root.left);
        int r = recursion(root.right);
        max = Math.max(max, l + r);
        return Math.max(l, r) + 1;
    }
}
