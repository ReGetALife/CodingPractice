package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 功能:等差数列 2，5，8，11，14。。。。
 *
 * 输入:正整数N >0
 *
 * 输出:求等差数列前N项和
 *
 * 输入描述:
 * 输入一个正整数。
 *
 * 输出描述:
 * 输出一个相加后的整数。
 *
 * 示例1
 * 输入
 * 2
 * 输出
 * 7
 */
public class GradeSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            //等差数列前n项和
            System.out.println((3 * n + 1) * n / 2);
        }
    }
}
