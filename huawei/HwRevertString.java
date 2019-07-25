package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。例如：
 * 输入描述:
 * 输入N个字符
 *
 * 输出描述:
 * 输出该字符串反转后的字符串
 *
 * 示例1
 * 输入
 * 复制
 * abcd
 * 输出
 * 复制
 * dcba
 */
public class HwRevertString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            StringBuilder stringBuilder = new StringBuilder(scanner.nextLine());
            System.out.println(stringBuilder.reverse());
        }
    }
}
