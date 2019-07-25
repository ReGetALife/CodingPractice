package tk.solidays.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode54 {
    //模拟真实行走过程
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int up = 0;
        int down = matrix.length - 1;
        if (down == -1) return list;
        int left = 0;
        int right = matrix[0].length - 1;
        if (right == -1) return list;
        while (up <= down && left <= right) {
            //顺时针的一圈
            for (int i = left; i <= right; i++)
                list.add(matrix[up][i]);
            if (up == down)//最后一行
                break;
            for (int j = up + 1; j <= down - 1; j++)
                list.add(matrix[j][right]);
            for (int i = right; i >= left; i--)
                list.add(matrix[down][i]);
            if (left == right)//最后一列
                break;
            for (int j = down - 1; j >= up + 1; j--)
                list.add(matrix[j][left]);
            up++;
            down--;
            left++;
            right--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        System.out.println(new LeetCode54().spiralOrder(matrix));
    }
}
