package tk.solidays.algorithm.leetcode;

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
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int[][] dpHor = new int[matrix.length][matrix[0].length];//以某个点为右下角的矩形水平方向的长度
        int[][] dpVer = new int[matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    if (j == 0)
                        dpHor[i][j] = 1;
                    else dpHor[i][j] = dpHor[i][j - 1] + 1;
                    if (i == 0)
                        dpVer[i][j] = 1;
                    else dpVer[i][j] = dpVer[i - 1][j] + 1;
                    max = Math.max(max, dpHor[i][j] * dpVer[i][j]);
                } else {
                    dpHor[i][j] = 0;
                    dpVer[i][j] = 0;
                }
            }
        }
        return max;
    }
}
