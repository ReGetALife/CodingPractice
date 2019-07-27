package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 输入描述:
 * 输入正整数N（N不大于100）
 *
 * 输出描述:
 * 输出一个N行的蛇形矩阵。
 *
 * 示例1
 * 输入
 * 复制
 * 4
 * 输出
 * 复制
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class SnakeMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    //等差数列1，2，3，4...前N项和，减去i
                    int N = i + j +1;
                    System.out.print((N + 1) * N / 2 - i + " ");
                }
                System.out.print("\n");
            }
        }
    }
}
