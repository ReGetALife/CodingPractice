package tk.solidays.algorithm.leetcode;

import java.util.Stack;

/**
 * 给定一个仅包含 0 和 1 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]
 * ]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode85 {
    //dp计算竖直方向的延伸长度，然后看作圆柱，计算最大的矩形
    public int maximalRectangle(char[][] matrix) {
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
                        max = Math.max(max, dp[t] * (j - stack.peek() - 1));
                    }
                    stack.push(j);
                } else stack.push(j);
            }
            while (stack.size() > 1) {
                int t = stack.pop();
                max = Math.max(max, dp[t] * (m - stack.peek() - 1));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1'}};
        System.out.println(new LeetCode85().maximalRectangle(matrix));
    }
}
