package tk.solidays.algorithm.leetcode;

import java.util.Stack;

public class LeetCode221 {
    //稍微修改leetcode85即可
    //直接使用动态规划会更快，dp[i][j]记录以该位置为右下角的最大边长，dp(i, j)=min(dp(i−1, j), dp(i−1, j−1), dp(i, j−1))+1
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int max = 0;
        int m = matrix[0].length;
        int[] dp = new int[m];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (char[] matrix1 : matrix) {
            for (int j = 0; j < m; j++) {
                if (matrix1[j] == '0') dp[j] = 0;
                else dp[j]++;
            }
            for (int j = 0; j < m; j++) {
                if (stack.size() <= 1) {
                    stack.push(j);
                } else if (dp[j] < dp[stack.peek()]) {
                    while (stack.size() > 1 && dp[j] < dp[stack.peek()]) {
                        int t = stack.pop();
                        int r = Math.min(dp[t], j - stack.peek() - 1);
                        max = Math.max(max, r * r);
                    }
                    stack.push(j);
                } else stack.push(j);
            }
            while (stack.size() > 1) {
                int t = stack.pop();
                int r = Math.min(dp[t], (m - stack.peek() - 1));
                max = Math.max(max, r * r);
            }
        }
        return max;
    }
}
