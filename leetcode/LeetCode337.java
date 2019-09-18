package tk.solidays.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

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
