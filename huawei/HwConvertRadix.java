package tk.solidays.algorithm.huawei;

import java.io.BufferedInputStream;
import java.math.BigInteger;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * 题目描述
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 *
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 *
 * 输出描述:
 * 输出该数值的十进制字符串。
 *
 * 示例1
 * 输入
 * 复制
 * 0xA
 * 输出
 * 复制
 * 10
 */
public class HwConvertRadix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedInputStream(in));
        while (scanner.hasNext()) {
            String string = scanner.nextLine();
            BigInteger bigInteger = new BigInteger(string.substring(2),16);
            System.out.println(bigInteger.intValue());
        }
    }
}
