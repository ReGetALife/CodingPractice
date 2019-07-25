package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 正整数A和正整数B 的最小公倍数是指 能被A和B整除的最小的正整数值，设计一个算法，求输入A和B的最小公倍数。
 *
 * 输入描述:
 * 输入两个正整数A和B。
 *
 * 输出描述:
 * 输出A和B的最小公倍数。
 *
 * 示例1
 * 输入
 * 复制
 * 5
 * 7
 * 输出
 * 复制
 * 35
 */
public class LeastCommonMultiple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int big = Math.max(a, b);
            int small = Math.min(a, b);
            while (big % small != 0) {
                int remainder = big % small;
                big = small;
                small = remainder;
            }
            System.out.println(a * b / small);
        }
    }
}
