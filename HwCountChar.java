package tk.solidays.algorithm;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)。不在范围内的不作统计。
 *
 * 输入描述:
 * 输入N个字符，字符在ACSII码范围内。
 *
 * 输出描述:
 * 输出范围在(0~127)字符的个数。
 *
 * 示例1
 * 输入
 * 复制
 * abc
 * 输出
 * 复制
 * 3
 */
public class HwCountChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            int[] charFlag = new int[128];
            int count = 0;
            for (int i = 0; i < string.length(); i++) {
                if (charFlag[string.charAt(i)] != 1) {
                    count++;
                    charFlag[string.charAt(i)] = 1;
                }
            }
            System.out.println(count);
        }
    }
}
