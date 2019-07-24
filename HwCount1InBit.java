package tk.solidays.algorithm;

import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * 题目描述
 * 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 *
 * 输入描述:
 *  输入一个整数（int类型）
 *
 * 输出描述:
 *  这个数转换成2进制后，输出1的个数
 *
 * 示例1
 * 输入
 * 复制
 * 5
 * 输出
 * 复制
 * 2
 */
public class HwCount1InBit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(System.in));
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = 1;
            int count = 0;
            while (m <= n) {
                if ((n & m) != 0)
                    count++;
                m <<= 1;
            }
            System.out.println(count);
        }
    }
}
