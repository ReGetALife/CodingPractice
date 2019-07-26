package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 请编写一个函数（允许增加子函数），计算n x m的棋盘格子（n为横向的格子数，m为竖向的格子数）沿着各自边缘线从左上角走到右下角，总共有多少种走法，要求不能走回头路，即：只能往右和往下走，不能往左和往上走。
 * 输入描述:
 * 输入两个正整数
 *
 * 输出描述:
 * 返回结果
 *
 * 示例1
 * 输入
 * 复制
 * 2
 * 2
 * 输出
 * 复制
 * 6
 */
public class WalkTable {
    //同LeetCode62
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt() + 1;
            int m = scanner.nextInt() + 1;
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0 || j == 0) {
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
                    }
                }
            }
            System.out.println(matrix[m - 1][n - 1]);
        }
    }
}
