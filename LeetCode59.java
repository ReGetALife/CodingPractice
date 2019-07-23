package tk.solidays.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode59 {
    //思路和54题相同
    public int[][] generateMatrix(int n) {
        if(n==0){
            return new int[0][0];
        }
        int[][] matrix = new int[n][n];
        int up = 0;
        int down =n - 1;
        int left = 0;
        int right = n - 1;
        int count = 0;
        while (up <= down && left <= right) {
            //顺时针的一圈
            for (int i = left; i <= right; i++)
                matrix[up][i]=++count;
            if (up == down)//最后一行
                break;
            for (int j = up + 1; j <= down - 1; j++)
                matrix[j][right]=++count;
            for (int i = right; i >= left; i--)
                matrix[down][i]=++count;
            if (left == right)//最后一列
                break;
            for (int j = down - 1; j >= up + 1; j--)
                matrix[j][left]=++count;
            up++;
            down--;
            left++;
            right--;
        }
        return matrix;
    }
}
