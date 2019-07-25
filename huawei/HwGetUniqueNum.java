package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
 *
 * 输入描述:
 * 输入一个int型整数
 *
 * 输出描述:
 * 按照从右向左的阅读顺序，返回一个不含重复数字的新的整数
 *
 * 示例1
 * 输入
 * 复制
 * 9876673
 * 输出
 * 复制
 * 37689
 */
public class HwGetUniqueNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] ns = new int[10];
            int res = 0;
            do {
                int last = n % 10;
                if (ns[last] != 1) {
                    res = res * 10 + last;
                    ns[last] = 1;
                }
                n /= 10;
            } while (n != 0);
            System.out.print(res);
        }
    }
}
